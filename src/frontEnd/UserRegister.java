package frontEnd;

import com.alibaba.fastjson.JSON;
import database.movieSystem.MovieSystemDB;
import database.userUtil.User;
import frontEnd.utils.ServletUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegister", urlPatterns = {"/UserRegister"})
public class UserRegister extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String Uname = req.getParameter("Uname");
        String Upswd = req.getParameter("Upswd");

        User user = new User(email, Uname, Upswd, "", 0, "");

        String response = "fail";
        if(MovieSystemDB.getUserTable().insert(user)){
            //successfully registe
            response = "successful";
        }
        ServletUtils.resJsonString(resp, JSON.toJSONString(response));
    }
}
