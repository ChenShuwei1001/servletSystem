package testFrontEnd;

import com.alibaba.fastjson.JSON;
import database.movieSystem.MovieSystemDB;
import frontEnd.UsedSeat;

public class TestSeatUsed {
    public static void main(String[] args) {
        MovieSystemDB.DBinit();
        UsedSeat usedSeat = new UsedSeat();
        System.out.println(
                JSON.toJSON(usedSeat.getSeat("1")));
    }
}
