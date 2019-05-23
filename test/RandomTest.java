import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import database.movieSystem.MovieSystemDB;
import frontEnd.MovieOptions;
import frontEnd.utils.JsonUtils;

import java.util.concurrent.LinkedBlockingQueue;

class A{
    public int a;
}

class B extends A{
    public int b;
}
public class RandomTest {

    public static void main(String[] args) throws InterruptedException {
        B b = new B();
        b.a = 1;
        b.b = 2;
        System.out.println(JSON.toJSONString(b));

    }
}
