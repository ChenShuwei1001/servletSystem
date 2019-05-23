package testFrontEnd;

import com.alibaba.fastjson.JSON;
import database.movieSystem.MovieSystemDB;
import frontEnd.SearchMovie;

public class TestSearchMovie {
    public static void main(String[] args) {
        MovieSystemDB.DBinit();
        SearchMovie searchMovie = new SearchMovie();
        System.out.println(JSON.toJSONString(searchMovie.searchMovie("是")));
    }
}
