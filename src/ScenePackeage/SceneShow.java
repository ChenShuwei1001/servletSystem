package ScenePackeage;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.movieSystem.MovieSystemDB;
import database.sceneUtil.Scene;
import database.sceneUtil.SceneTable;
import frontEnd.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.LinkedBlockingQueue;

public class SceneShow extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到请求");
        String Sno = req.getParameter("Sno");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        MovieSystemDB.DBinit();
        LinkedBlockingQueue<Scene> show = new LinkedBlockingQueue<>();
        if (Sno.trim().equals("ALL")) {
            show=getALL();
        } else {
            Scene scene = new Scene();
            scene = MovieSystemDB.getSceneTable().select(Sno);
            show.add(scene);

        }

        ServletUtils.resJsonString(resp, JSON.toJSONString(show));
    }


    public LinkedBlockingQueue<Scene> getALL(){
        LinkedBlockingQueue<Scene> top10 = new LinkedBlockingQueue<>();

        String sql = "Select * From " + SceneTable.sceneTableName;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(sql);
            LinkedBlockingQueue<String> Sno = new LinkedBlockingQueue<>();
            while(rs.next()){
                Sno.put(rs.getString(1));
            }
            while(!Sno.isEmpty()){
                Scene scene = MovieSystemDB.getSceneTable().select(Sno.remove());
                top10.put(scene);
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally{
            if(null!=rs){
                try{
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return top10;
    }
}
