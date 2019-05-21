package admin_fkh;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.movieSystem.MovieSystemDB;
import database.movieUtil.Movie;
import database.movieUtil.MovieTable;
import database.movieUtil.MovieToFrontEnd;
//import database.system.MovieSystemDB;
import frontEnd.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.LinkedBlockingQueue;

public class Admin_LoadData_movie_list extends HttpServlet {

    private static final String defaultImagePath = "C://users/swchen/Desktop/test.png";
    private boolean fileExist(String filePath){
        File testFile = new File(filePath);
        return testFile.exists();
    }

    public LinkedBlockingQueue<MovieToFrontEnd> getTop10(){
        LinkedBlockingQueue<MovieToFrontEnd> top10 = new LinkedBlockingQueue<>();


        //这里修改为 选择所有数据
        String sql = "Select Mno From " + MovieTable.movieTableName + " Order By Mrating limit 10";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(sql);
            LinkedBlockingQueue<String> Mno = new LinkedBlockingQueue<>();
            while(rs.next()){
                Mno.put(rs.getString(1));
            }
            while(!Mno.isEmpty()){
                Movie movie = MovieSystemDB.getMovieTable().select(Mno.remove());
                if(!fileExist(movie.getMposterPath())){
                    movie.setMposterPath(defaultImagePath);
                }
                MovieToFrontEnd movieToFrontEnd = new MovieToFrontEnd(movie);
                top10.put(movieToFrontEnd);
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.resJsonString(resp, JSON.toJSONString(getTop10()));
    }
}