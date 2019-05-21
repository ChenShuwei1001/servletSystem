package admin_fkh;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
//        super.doPost(req, resp);

//        Should import:
//        lib  commons-fileupload-1.3.2.jar
//        lib  commons-io-2.5.jar


        //设置海报路径
        String Path="F:\\myCode\\411movieSystem\\servletSystem\\web\\image\\";

        Part result=  req.getPart("addMpo");

        String movieNo=req.getParameter("addMno");
        String movieName=req.getParameter("addMname");
        String moviePath=Path+movieNo+movieName+".jpg";
        String movieoD=req.getParameter("addMoD");
        String movieoA=req.getParameter("addMoA");
        String movieoT=req.getParameter("addMoT");
        String movieoL=req.getParameter("addMoL");
        String movieoC=req.getParameter("addMoC");
        String movieoDA=req.getParameter("addMoDA");
        String movieoSC=req.getParameter("addMoSC");

        if(result.getContentType().contains("image")){
            result.write(moviePath);
        }else{

        }
    }
}
