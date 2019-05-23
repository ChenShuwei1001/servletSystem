package Sevlet;


import database.movieSystem.MovieSystemDB;
import database.movieUtil.Movie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminServlet",urlPatterns = "/adminServlet")
public class adminSevelet extends HttpServlet{
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
        System.out.println("接收到请求");
        String Name= req.getParameter("Name");
        String Password= req.getParameter("Password");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

    }
}
