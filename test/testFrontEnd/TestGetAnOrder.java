package testFrontEnd;

import com.alibaba.fastjson.JSON;
import database.movieSystem.MovieSystemDB;
import database.orderUtil.OrderDetail;
import frontEnd.GetAnOrder;

public class TestGetAnOrder {
    public static void main(String[] args) {
        MovieSystemDB.DBinit();
        String Ono = "1";
        GetAnOrder getAnOrder = new GetAnOrder();
        OrderDetail orderDetail = getAnOrder.getOrderDetail("1");
        System.out.println(JSON.toJSONString(orderDetail));

    }
}
