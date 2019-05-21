package frontEnd;

import com.alibaba.fastjson.JSON;
import database.movieSystem.MovieSystemDB;
import database.userUtil.User;
import frontEnd.utils.ServletUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String Upswd = req.getParameter("Upswd");

        User user = MovieSystemDB.getUserTable().select(email);
        String response = "fail";
        if(null != user){
            if(user.getUpswd().equals(Upswd)){
                response = "successful";
            }
        }

        ServletUtils.resJsonString(resp, JSON.toJSONString(response));
    }

}
