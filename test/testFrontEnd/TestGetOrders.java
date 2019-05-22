package testFrontEnd;

import com.alibaba.fastjson.JSON;
import database.movieSystem.MovieSystemDB;
import database.orderUtil.OrdersToFrontEnd;
import frontEnd.GetOrders;

import java.util.concurrent.LinkedBlockingQueue;

public class TestGetOrders {
    public static void main(String[] args) throws InterruptedException {
        MovieSystemDB.DBinit();
        GetOrders getOrders = new GetOrders();
        LinkedBlockingQueue<OrdersToFrontEnd> ordersGet = getOrders.getOrders("1");
        LinkedBlockingQueue<OrdersToFrontEnd> orders = new LinkedBlockingQueue<>();
        while(!ordersGet.isEmpty()){
            orders.put(ordersGet.remove());
        }
        System.out.println(JSON.toJSONString(orders));
    }
}
