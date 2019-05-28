package frontEnd;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.movieSystem.MovieSystemDB;
import database.movieUtil.Movie;
import database.movieUtil.MovieTable;
import database.movieUtil.MovieToFrontEnd;
import database.sceneUtil.SceneTable;
import frontEnd.utils.Pair4Filter;
import frontEnd.utils.ServletUtils;
import logger.SimpleLogger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
@WebServlet(name = "SelectMovies", urlPatterns = {"/SelectMovies"})
public class SelectMovies extends HttpServlet {

    public static LinkedBlockingQueue<MovieToFrontEnd> getMovies(LinkedBlockingQueue<Pair4Filter> attr){
        LinkedBlockingQueue<MovieToFrontEnd> movies = new LinkedBlockingQueue<>();
        HashMap hashMap = new HashMap();
        hashMap.put("Mtype", "");
        hashMap.put("Mlocation", "");
        hashMap.put("Mlanguage","");

        while(!attr.isEmpty()){
            Pair4Filter temp = attr.remove();
            hashMap.put(temp.attribute, temp.value);
        }

        int count = 0;
        String sql = "";

        if("" != hashMap.get("Mtype")){
            if(count++>0){
                sql +=" And ";
            }
            sql += "Mtype lIKE '%" + hashMap.get("Mtype") + "%' ";
        }
        if("" != hashMap.get("Mlocation")){
            if(count++>0){
                sql +=" And ";
            }
            sql += "Mlocation = '" + hashMap.get("Mlocation") + "' ";
        }
        if("" != hashMap.get("Mlanguage")){
            if(count++>0){
                sql +=" And ";
            }
            sql += "Mlanguage = '" + hashMap.get("Mlanguage") + "' ";
        }
        if(count>0){
            sql = "Select Mno from " + MovieTable.movieTableName +
                    " Where " + sql;
        }else{
            sql = "Select Mno from " + MovieTable.movieTableName;
        }
        SimpleLogger.logger.info(sql);
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Movie movie = MovieSystemDB.getMovieTable().select(rs.getString("Mno"));
                movies.put(new MovieToFrontEnd(movie));
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            DBOpration.closeRsStmt(rs, stmt);
        }
        return movies;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LinkedBlockingQueue<Pair4Filter> attr = new LinkedBlockingQueue<>();
        try{
            attr.put(new Pair4Filter("Mtype", req.getParameter("Mtype")));
            attr.put(new Pair4Filter("Mlocation", req.getParameter("Mlocation")));
            attr.put(new Pair4Filter("Mlanguage",req.getParameter("Mlanguage")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ServletUtils.resJsonString(resp, JSON.toJSONString(getMovies(attr)));
    }
}
