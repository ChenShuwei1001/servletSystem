package frontEnd;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.movieSystem.MovieSystemDB;
import database.movieUtil.Movie;
import database.orderUtil.Order;
import database.orderUtil.OrdersToFrontEnd;
import database.sceneUtil.Scene;
import database.theaterUtil.Theater;
import frontEnd.utils.ServletUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.LinkedBlockingQueue;
@WebServlet(name = "GetOrders", urlPatterns = {"/GetOrders"})
public class GetOrders extends HttpServlet {

    public LinkedBlockingQueue<OrdersToFrontEnd> getOrders(String Uno){
        LinkedBlockingQueue<String> Onos = new LinkedBlockingQueue<>();
        String sql = "Select Ono from orders where Uno = '" + Uno +"'";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Onos.put(rs.getString("Ono"));
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            DBOpration.closeRsStmt(rs, stmt);
        }
        LinkedBlockingQueue<OrdersToFrontEnd> orders = new LinkedBlockingQueue<>();
        while(!Onos.isEmpty()){
            try {
                String Ono = Onos.remove();
                Order order = MovieSystemDB.getOrderTable().select(Ono);

                String Sno = order.getSno();
                Scene scene = MovieSystemDB.getSceneTable().select(Sno);

                String Mno = scene.getMno();
                Movie movie = MovieSystemDB.getMovieTable().select(Mno);

                String Tno = scene.getTno();
                Theater theater = MovieSystemDB.getTheaterTable().select(Tno);

                OrdersToFrontEnd orderToFrontEnd =
                        new OrdersToFrontEnd(order, movie, scene, theater);
                orders.put(orderToFrontEnd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String Uno = req.getParameter("email");

        LinkedBlockingQueue<OrdersToFrontEnd> orders = getOrders(Uno);
        ServletUtils.resJsonString(resp, JSON.toJSONString(orders));
    }
}
