import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import database.movieSystem.MovieSystemDB;
import frontEnd.MovieOptions;
import frontEnd.utils.JsonUtils;

import java.util.concurrent.LinkedBlockingQueue;

public class RandomTest {

    public static void main(String[] args) throws InterruptedException {
        MovieSystemDB.DBinit();
        MovieOptions movieOptions = new MovieOptions();
        System.out.println(JSON.toJSONString(movieOptions.getOptions()));

    }
}
