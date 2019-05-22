package admin_fkh;

//import database.movieSystem.MovieSystemDB;
//import database.movieUtil.Movie;
//import database.movieUtil.MovieTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public class Admin_alterPoster extends HttpServlet {
    //删除原海报 拷贝新海报
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

//        Should import:
//        lib  commons-fileupload-1.3.2.jar
//        lib  commons-io-2.5.jar


        //设置海报路径
        String PathStemp = this.getClass().getClassLoader().getResource(".").getPath();
        String PosterOld=req.getParameter("altermovieMPo12345");//旧海报名称    image/test001.jpg
        String Path=PathStemp.substring(1,PathStemp.indexOf("out"))+"web/";
        String PosterNewPath=Path+PosterOld;//新海报路径

        //删除旧海报
        File oldPoster=new File(PosterNewPath);
        oldPoster.delete();

        Part result=  req.getPart("alterPosterNew");
        String movieNo=req.getParameter("addMno");


//        String moviePath=Path+movieNo+movieName+".jpg";
//        String moviePath=movieNo+movieName+".jpg";//
//        存储的还是绝对路径，admin使用时 自动切割
//        String moviePath2=Path+moviePath;




//        MovieSystemDB.DBinit();
//        MovieTable movieTable = MovieSystemDB.getMovieTable();
//        Movie movie = new Movie(
//                movieNo,//编号
//                movieName,
//                movieEngName, //英文名
//                Mduration,//时长
//                Double.valueOf(MboxOffice),//票房
//                moviePath2, //海报  执行语句 alter table movie modify column mposterpath varchar(100);
//                movieoD, //导演
//                movieoA,//演员
//                movieoT, //类型
//                movieoL,
//                movieoC,//上映地区
//                movieoDA, //上映时间
//                Double.valueOf(movieoSC),//评分
//                Integer.valueOf(movieMscoreNumber),//评分人数
//                movieMintroduction
//        );
//        movieTable.insert(movie);


        if(result.getContentType().contains("image")){
            result.write(PosterNewPath);
        }else{

        }
    }
}
