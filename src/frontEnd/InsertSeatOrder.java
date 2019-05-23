package frontEnd;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.movieSystem.MovieSystemDB;
import database.orderUtil.Order;
import database.sceneUtil.Scene;
import frontEnd.utils.ServletUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet(name = "InsertSeatOrder", urlPatterns = {"/InsertSeatOrder"})
public class InsertSeatOrder extends HttpServlet {

    /**
        @param newSeat is the seats produced by new order.it should be like
                'A1,B2,C3,D4', which is a string and different part in the string
                is splitted by ','
     */
    public boolean updateSeat(String Sno, String newSeat){

        Scene scene = MovieSystemDB.getSceneTable().select(Sno);
        //seat used before insert the newSeat
        String usedSeat = scene.getSeat();

        //split newSeat into seats
        String []seats = newSeat.split(",");
        for(int i = 0;i<seats.length;i++){
            usedSeat += ("," + seats[i]);
        }

        scene.setSeat(usedSeat);
        if(true == MovieSystemDB.getSceneTable().update(scene)){
            return true;
        }
        return false;
    }

    public String getDateTime(){
        String sql = "select now()";
        Statement stmt = null;
        ResultSet rs = null;
        String now = null;
        try {
            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                now = rs.getString("now()");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBOpration.closeRsStmt(rs, stmt);
        }
        String []dateTime = now.split("\\.");
        return dateTime[0];
    }

    /**
     * @param dateTime, format:2019-05-22 14:56:32
     *  handle datetime, change it into 20190522145632
     */
    public String handleDateTime(String dateTime){
        String []handle = dateTime.split("-| |:");
        String ret = "";
        for(int i = 0;i<handle.length;i++){
            ret += handle[i];
        }
        return ret;
    }

    public boolean insertOrder(String Sno, String Uno, String seat){
        String Odate = getDateTime();
        String Ono = handleDateTime(Odate)+Uno;
        String []seatnum = seat.split(",");

        Scene scene = MovieSystemDB.getSceneTable().select(Sno);
        double price = scene.getPrice()*seatnum.length;
        Order order = new Order(Ono, Odate, Sno, Uno, seat,price);
        if(true == MovieSystemDB.getOrderTable().insert(order)){
            return true;
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String Sno = req.getParameter("Sno");
        //seat should be like 'A1,B2,C3,D4' in the req
        String newSeat = req.getParameter("seat");
        //primary key of UserTable, i.e. Uno
        String Uno = req.getParameter("email");

        //todo:use commit
        String response = "fail";
        try {
            MovieSystemDB.getConn().setAutoCommit(false);
            if(updateSeat(Sno, newSeat) && insertOrder(Sno, Uno,newSeat)){
                response = "successful";
                MovieSystemDB.getConn().commit();
            }
            MovieSystemDB.getConn().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ServletUtils.resJsonString(resp, JSON.toJSONString(response));
    }
}
