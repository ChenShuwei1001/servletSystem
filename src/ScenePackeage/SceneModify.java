package ScenePackeage;

import database.movieSystem.MovieSystemDB;
import database.sceneUtil.Scene;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "SceneModify",urlPatterns = "/SceneModify")
public class SceneModify extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("接收到请求");
        String Sno = req.getParameter("sno");
        String Mno=  req.getParameter("mno");
        String Tno=  req.getParameter("tno");
        String Tbrand=req.getParameter("tbrand");
        String beginTime=req.getParameter("beginTime");
        String endTime=req.getParameter("endTime");
        String language=req.getParameter("language");
        String roomType=req.getParameter("roomType");
        String roomName=req.getParameter("roomName");
        String location=req.getParameter("location");
        String Sdate=req.getParameter("sdate");
        String Seat=req.getParameter("seat");
        String price=req.getParameter("price");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Scene scene=new Scene(Sno,Mno,Tno,Tbrand,beginTime,endTime,language,roomType,roomName,location,Sdate,Seat,Double.valueOf(price));
        MovieSystemDB.getSceneTable().update(scene);
    }
}
