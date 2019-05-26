package ScenePackeage;

import database.movieSystem.MovieSystemDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Scene_delete",urlPatterns = "/Scene_delete")
public class Scene_delete extends HttpServlet {
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
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        MovieSystemDB.DBinit();
        MovieSystemDB.getSceneTable().delete(Sno);
    }
}
