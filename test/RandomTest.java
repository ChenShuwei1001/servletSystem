import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class RandomTest {

    public static void main(String[] args) throws InterruptedException {
        String test = "A1,B2,C3,D4";
        String []seats = test.split(",");
        for(int i = 0;i<seats.length;i++){
            System.out.println(seats[i]);
        }
    }
}
