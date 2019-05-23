package ScenePackeage;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SceneServlet extends HttpServlet {
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
        System.out.println("接收到请求");
        String Sno=req.getParameter("Sno");
        String Mno=req.getParameter("Mno");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");


//        SceneTable sceneTable=new SceneTable();
//        boolean flag=sceneTable.insert(scene);
//        String result;
//        if(flag==true){
//            result="添加成功";
//        }
//        else {
//            result="添加失败";
//        }
//        System.out.println(result);
        PrintWriter print=resp.getWriter();
        JSONObject result1JSON = new JSONObject();//把对象转化成JSON格式
        result1JSON.put("Sno",Sno);
        result1JSON.put("Mno",Mno);

        print.print(result1JSON.toString()); //这里很重要，一定要转成字符串格式
        print.flush();
        print.close();
    }

}
