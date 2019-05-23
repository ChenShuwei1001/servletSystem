package ScenePackeage;

import com.alibaba.fastjson.JSON;
import database.movieSystem.MovieSystemDB;
import database.sceneUtil.Scene;
import frontEnd.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SceneAdd extends HttpServlet {
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
        String Sno = req.getParameter("Sno");
        String Mno=  req.getParameter("Mno");
        String Tno=  req.getParameter("Tno");
        String Tbrand=req.getParameter("Tbrand");
        String beginTime=req.getParameter("beginTime");
        String endTime=req.getParameter("endTime");
        String language=req.getParameter("language");
        String roomType=req.getParameter("roomType");
        String roomName=req.getParameter("roomName");
        String location=req.getParameter("location");
        String Sdate=req.getParameter("Sdate");
        String price=req.getParameter("Price");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        //添加数据
        Scene scene=new Scene(Sno,Mno,Tno,Tbrand,beginTime,endTime,language,roomType,roomName,location,Sdate,"",Double.valueOf(price));
        boolean flag= MovieSystemDB.getSceneTable().insert(scene);
        //传回添加标志
        ServletUtils.resJsonString(resp, JSON.toJSONString(flag));

    }
}
