package admin_fkh;

//import database.movieSystem.MovieSystemDB;
//import database.movieUtil.Movie;
//import database.movieUtil.MovieTable;

import database.movieSystem.MovieSystemDB;
import database.movieUtil.Movie;
import database.movieUtil.MovieTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
@MultipartConfig(location = "F://")//测试路径
public class Admin_alterPoster extends HttpServlet {
    //删除原海报 拷贝新海报
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        Part result=  req.getPart("alterPosterNew");

//        String movieNo=req.getParameter("altermovieMNo");
        String moviePath=req.getParameter("alterPosterPath");


//        MovieSystemDB.DBinit();
//        MovieTable movieTable = MovieSystemDB.getMovieTable();
//
//        Movie movieUpdate = new Movie();
//        movieUpdate.setMno(movieNo);
//        movieUpdate.setMposterPath(moviePath);
//        movieTable.update(movieUpdate);
//



        if(result.getContentType().contains("image")){
            result.write(moviePath);
        }else{

        }
    }
}
