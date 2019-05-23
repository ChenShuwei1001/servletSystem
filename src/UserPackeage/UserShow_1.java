package UserPackeage;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.movieSystem.MovieSystemDB;
import database.sceneUtil.Scene;
import database.sceneUtil.SceneTable;
import database.userUtil.User;
import database.userUtil.UserTable;
import frontEnd.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.LinkedBlockingQueue;

//@WebServlet(name = "UserShow",urlPatterns = "/UserShow")
public class UserShow_1 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到请求");
        String Uno = req.getParameter("Uno");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        MovieSystemDB.DBinit();
        LinkedBlockingQueue<User> show = new LinkedBlockingQueue<>();
        if (Uno.trim().equals("ALL")) {
            show=getALL();
        } else {
            User user=new User();
            user=MovieSystemDB.getUserTable().select(Uno);
            show.add(user);
        }
        ServletUtils.resJsonString(resp, JSON.toJSONString(show));
    }
    public LinkedBlockingQueue<User> getALL(){
        LinkedBlockingQueue<User> top10 = new LinkedBlockingQueue<>();

        String sql = "Select * From " + UserTable.userTableName;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(sql);
            LinkedBlockingQueue<String> Uno = new LinkedBlockingQueue<>();
            while(rs.next()){
                Uno.put(rs.getString(1));
            }
            while(!Uno.isEmpty()){
                User user = MovieSystemDB.getUserTable().select(Uno.remove());
                top10.put(user);
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
