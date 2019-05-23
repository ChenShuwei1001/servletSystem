package Sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import database.movieSystem.MovieSystemDB;


@WebServlet(name = "TestServlet",urlPatterns = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
//        System.out.println("开始交互");
//        String name=req.getParameter("movie");//获取ajax传过来的值
//        System.out.println(name);
//        PrintWriter out = resp.getWriter();
//        out.println(name);
//        String table= (String) req.getAttribute("form1");
//        System.out.println(table);
//        System.out.println("接收到请求");
//        System.out.println(req.getParameter("username"));
//        System.out.println(req.getParameter("password"));
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        People pe=new People();
//        pe.setName("yang");
//        pe.setOrder("666");
//        PrintWriter print=resp.getWriter();
//        JSONObject result1JSON = new JSONObject();//把对象转化成JSON格式
//        result1JSON.put("username",pe.getName());
//        result1JSON.put("password",pe.getPassword());
//        print.print(result1JSON.toString()); //这里很重要，一定要转成字符串格式
//        print.flush();
//        print.close();
        MovieSystemDB.DBinit();


    }


}
