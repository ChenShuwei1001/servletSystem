package OrderPackeage;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.movieSystem.MovieSystemDB;
import database.orderUtil.Order;
import database.orderUtil.OrderTable;
import frontEnd.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderShow extends HttpServlet {
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
        String Ono = req.getParameter("Ono");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        LinkedBlockingQueue<Order> show = new LinkedBlockingQueue<>();
        if (Ono.trim().equals("ALL")) {
            show=getALL();
        } else {
            Order order=new Order();
            order=MovieSystemDB.getOrderTable().select(Ono);
            show.add(order);
        }
        ServletUtils.resJsonString(resp, JSON.toJSONString(show));
    }
    public LinkedBlockingQueue<Order> getALL(){
        LinkedBlockingQueue<Order> top10 = new LinkedBlockingQueue<>();



        String sql = "Select * From " + OrderTable.tableName;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(sql);
            LinkedBlockingQueue<String> Ono = new LinkedBlockingQueue<>();
            while(rs.next()){
                Ono.put(rs.getString(1));
            }
            while(!Ono.isEmpty()){
                Order order = MovieSystemDB.getOrderTable().select(Ono.remove());
                top10.put(order);
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally{
            if(null!=rs){
                try{
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return top10;
    }
}
