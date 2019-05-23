package testFrontEnd;

import com.alibaba.fastjson.JSON;
import database.movieSystem.MovieSystemDB;
import frontEnd.SelectMovies;
import frontEnd.utils.Pair4Filter;

import java.util.concurrent.LinkedBlockingQueue;

public class TestSelectMovies {
    public static void main(String[] args) {
        MovieSystemDB.DBinit();
        SelectMovies selectMovies = new SelectMovies();
        LinkedBlockingQueue<Pair4Filter> attr = new LinkedBlockingQueue<>();
        System.out.println(JSON.toJSONString(selectMovies.getMovies(attr)));

    }
}
