package admin_fkh;

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
import java.io.IOException;

@MultipartConfig(location = "F://")//测试路径
public class Admin_addmovie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        super.doPost(req, resp);

//        Should import:
//        lib  commons-fileupload-1.3.2.jar
//        lib  commons-io-2.5.jar


        //设置海报路径
//        String Path="F:\\myCode\\411movieSystemImage\\";
//        String PathStemp = this.getClass().getClassLoader().getResource(".").getPath();
        //        F:\myCode\411movieSystem\servletSystem\web\image
        String Path="F:/myCode/411movieSystemImage/";


        Part result=  req.getPart("addMpo");

        String movieNo=req.getParameter("addMno");
        String movieName=req.getParameter("addMname");
        String movieEngName=req.getParameter("addEngname");
        String Mduration=req.getParameter("addMTL");
        String MboxOffice=req.getParameter("addMcash");

        String moviePath=Path+movieNo+movieName+".jpg";

        String movieoD=req.getParameter("addMoD");
        String movieoA=req.getParameter("addMoA");
        String movieoT=req.getParameter("addMoT");
        String movieoL=req.getParameter("addMoL");
        String movieoC=req.getParameter("addMoC");
        String movieoDA=req.getParameter("addMoDA");
        String movieoSC=req.getParameter("addMoSC");
        String movieMscoreNumber=req.getParameter("addscoreNum");
        String movieMintroduction=req.getParameter("addMnote");


        MovieSystemDB.DBinit();
        MovieTable movieTable = MovieSystemDB.getMovieTable();
        Movie movie = new Movie(
                movieNo,//编号
                movieName,
                movieEngName, //英文名
                Mduration,//时长
                Double.valueOf(MboxOffice),//票房
                moviePath, //海报  执行语句 alter table movie modify column mposterpath varchar(100);
                movieoD, //导演
                movieoA,//演员
                movieoT, //类型
                movieoL,
                movieoC,//上映地区
                movieoDA, //上映时间
                Double.valueOf(movieoSC),//评分
                Integer.valueOf(movieMscoreNumber),//评分人数
                movieMintroduction
        );
        movieTable.insert(movie);


        if(result.getContentType().contains("image")){
            result.write(moviePath);
        }else{

        }
    }
}
