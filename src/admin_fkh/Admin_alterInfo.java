package admin_fkh;

import database.movieSystem.MovieSystemDB;
import database.movieUtil.Movie;
import database.movieUtil.MovieTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@MultipartConfig(location = "F://")//测试路径
public class Admin_alterInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        MovieSystemDB.DBinit();
        MovieTable movieTable = MovieSystemDB.getMovieTable();
        Movie movieUpdate = new Movie();

        String addMno=req.getParameter("addMno");
        movieUpdate.setMno(addMno);

        String addMname=req.getParameter("addMname");
        movieUpdate.setMname(addMname);

        String addEngname=req.getParameter("addEngname");
        movieUpdate.setMEnglishName(addEngname);

        String addMTL=req.getParameter("addMTL");
        movieUpdate.setMduration(addMTL);



        String addMcash=req.getParameter("addMcash");
        movieUpdate.setMboxOffice(Double.valueOf(addMcash));

        String moviePath=req.getParameter("addMpo");//旧路径
        //修改名字的同时修改路径 重新保存海报
        //修改路径
        String Path="F:/myCode/411movieSystemImage/";
        String NewmoviePath=Path+addMno+addMname+".jpg";//新路径
        movieUpdate.setMposterPath(NewmoviePath);
        File oldname=new File(moviePath);
        File newname=new File(NewmoviePath);
        oldname.renameTo(newname);

        String addMoD=req.getParameter("addMoD");
        movieUpdate.setDirector(addMoD);

        String addMoA=req.getParameter("addMoA");
        movieUpdate.setActor(addMoA);

        String addMoT=req.getParameter("addMoT");
        movieUpdate.setMtype(addMoT);

        String addMoL=req.getParameter("addMoL");
        movieUpdate.setMlanguage(addMoL);

        String addMoC=req.getParameter("addMoC");
        movieUpdate.setMlocation(addMoC);

        String addMoDA=req.getParameter("addMoDA");
        movieUpdate.setMdate(addMoDA);

        String addMoSC=req.getParameter("addMoSC");
        movieUpdate.setMrating(Double.valueOf(addMoSC));

        String addscoreNum=req.getParameter("addscoreNum");
        movieUpdate.setMscoreNumber(Integer.valueOf(addscoreNum));

        String addMnote=req.getParameter("addMnote");
        movieUpdate.setMintroduction(addMnote);

        movieTable.update(movieUpdate);
//

    }
}
