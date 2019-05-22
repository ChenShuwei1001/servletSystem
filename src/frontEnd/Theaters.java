package frontEnd;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.sceneUtil.Scene;
import database.sceneUtil.SceneTable;
import database.movieSystem.MovieSystemDB;
import database.theaterUtil.Theater;
import frontEnd.utils.Filter;
import frontEnd.utils.Pair4Filter;
import frontEnd.utils.ServletUtils;
import logger.SimpleLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

@WebServlet(name = "Theaters", urlPatterns = {"/theaters"})
public class Theaters extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LinkedBlockingQueue<Pair4Filter> attr = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Theater> theaters = new LinkedBlockingQueue<>();
        try {
            attr.put(new Pair4Filter("Mno", req.getParameter("Mno")));
            attr.put(new Pair4Filter("Sdate", req.getParameter("Sdate")));
            attr.put(new Pair4Filter("Tbrand", req.getParameter("Tbrand")));
            attr.put(new Pair4Filter("location", req.getParameter("location")));
            attr.put(new Pair4Filter("roomType", req.getParameter("roomType")));
            attr.put(new Pair4Filter("Tno", req.getParameter("Tno")));

            LinkedBlockingQueue<String> Snos = Filter.filter(attr);
            while(!Snos.isEmpty()){
                Scene scene = MovieSystemDB.getSceneTable().select(Snos.remove());
                String Tno = scene.getTno();
                Theater theater = MovieSystemDB.getTheaterTable().select(Tno);
                theaters.put(theater);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ServletUtils.resJsonString(resp, JSON.toJSONString(theaters));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletUtils.resJsonString(resp, JSON.toJSONString(""));
    }

}
