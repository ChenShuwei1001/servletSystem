package frontEnd;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.movieSystem.MovieSystemDB;
import database.movieUtil.Movie;
import database.orderUtil.Order;
import database.orderUtil.OrderDetail;
import database.orderUtil.OrdersToFrontEnd;
import database.sceneUtil.Scene;
import database.theaterUtil.Theater;
import frontEnd.utils.ServletUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.LinkedBlockingQueue;

public class GetAnOrder extends HttpServlet {

    public OrderDetail getOrderDetail(String Ono){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOno(Ono);

        Order order = MovieSystemDB.getOrderTable().select(Ono);
        orderDetail.setSeat(order.getSeat());
        orderDetail.setPrice(order.getPrice());
        String Sno = order.getSno();

        Scene scene = MovieSystemDB.getSceneTable().select(Sno);
        orderDetail.setBeginDate(scene.getSdate());
        orderDetail.setBeginTime(scene.getBeginTime());
        orderDetail.setRoomName(scene.getRoomName());

        String Mno = scene.getMno();
        Movie movie = MovieSystemDB.getMovieTable().select(Mno);
        orderDetail.setMname(movie.getMname());

        String Tno = scene.getTno();
        Theater theater = MovieSystemDB.getTheaterTable().select(Tno);
        orderDetail.setTname(theater.getTname());
        orderDetail.setTaddress(theater.getTaddress());
        orderDetail.setTtel(theater.getTtel());

        return orderDetail;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String Ono = req.getParameter("Ono");

        OrderDetail orderDetail = getOrderDetail(Ono);

        ServletUtils.resJsonString(resp, JSON.toJSONString(orderDetail));
    }
}
