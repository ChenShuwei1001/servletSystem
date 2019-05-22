package testFrontEnd;

import com.alibaba.fastjson.JSON;
import database.movieSystem.MovieSystemDB;
import database.orderUtil.OrderToFrontEnd;
import frontEnd.GetOrders;
import frontEnd.utils.JsonUtils;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class TestGetOrders {
    public static void main(String[] args) throws InterruptedException {
        MovieSystemDB.DBinit();
        GetOrders getOrders = new GetOrders();
        LinkedBlockingQueue<OrderToFrontEnd> ordersGet = getOrders.getOrders("1");
        LinkedBlockingQueue<OrderToFrontEnd> orders = new LinkedBlockingQueue<>();
        while(!ordersGet.isEmpty()){
            orders.put(ordersGet.remove());
        }
        System.out.println(JSON.toJSONString(orders));
    }
}
