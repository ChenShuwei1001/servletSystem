package Sevlet;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.movieSystem.MovieSystemDB;
import database.movieUtil.MovieTable;
import database.orderUtil.OrderTable;
import database.sceneUtil.SceneTable;
import database.theaterUtil.TheaterTable;
import database.userUtil.UserTable;
import frontEnd.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//@WebServlet(name = "WelcomeServlet",urlPatterns = "/WelcomeServlet")
public class WelcomeServlet_1 extends HttpServlet{
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
        String First=req.getParameter("First");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Welcome_1 welcome=new Welcome_1();
        MovieSystemDB.DBinit();
        if (First.trim().equals("ALL")){
            String sql = "select count(*) from "+ MovieTable.movieTableName;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                stmt = DBOpration.getStmt();

                rs = stmt.executeQuery(sql);
                rs.next();
                welcome.setMoviesNum(rs.getInt(1));

                sql = "select count(*) from "+ SceneTable.sceneTableName;
                rs = stmt.executeQuery(sql);
                rs.next();
                welcome.setSceneNum(rs.getInt(1));

                sql = "select count(*) from "+ OrderTable.tableName;
                rs = stmt.executeQuery(sql);
                rs.next();
                welcome.setOrderNum(rs.getInt(1));

                sql = "select count(*) from "+ TheaterTable.theaterTableName;
                rs = stmt.executeQuery(sql);
                rs.next();
                welcome.setTheaterNum(rs.getInt(1));

                sql = "select count(*) from "+ UserTable.userTableName;
                rs = stmt.executeQuery(sql);
                rs.next();
                welcome.setUserNum(rs.getInt(1));

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(null!=rs){
                    try{
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            welcome=null;
        }

        ServletUtils.resJsonString(resp, JSON.toJSONString(welcome));
    }
}
