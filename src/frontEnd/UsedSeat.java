package frontEnd;

import com.alibaba.fastjson.JSON;
import database.movieSystem.MovieSystemDB;
import database.sceneUtil.Scene;
import frontEnd.utils.ServletUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "UsedSeat", urlPatterns = {"/UsedSeat"})
public class UsedSeat extends HttpServlet {

    public String getSeat(String Sno){
        Scene scene = MovieSystemDB.getSceneTable().select(Sno);
        return scene.getSeat();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String Sno = req.getParameter("Sno");

        ServletUtils.resJsonString(resp, JSON.toJSONString(getSeat(Sno)));
    }
}
