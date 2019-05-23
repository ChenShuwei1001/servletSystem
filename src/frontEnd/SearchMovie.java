package frontEnd;

import com.alibaba.fastjson.JSON;
import database.DBOpration;
import database.movieSystem.MovieSystemDB;
import database.movieUtil.Movie;
import database.movieUtil.MovieSearched;
import database.movieUtil.MovieTable;
import frontEnd.utils.Pair4Filter;
import frontEnd.utils.ServletUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.LinkedBlockingQueue;
@WebServlet(name = "SearchMovie", urlPatterns = {"/SearchMovie"})
public class SearchMovie extends HttpServlet {

    public LinkedBlockingQueue<MovieSearched> searchMovie(String Mname){
        String sql = "Select Mno From " + MovieTable.movieTableName +
                " Where Mname Like '%" + Mname + "%'";
        Statement stmt = null;
        ResultSet rs = null;
        LinkedBlockingQueue<MovieSearched> movies = new LinkedBlockingQueue<>();
        try {
            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(sql);
            LinkedBlockingQueue<String> Mnos = new LinkedBlockingQueue<>();
            while(rs.next()){
                Mnos.put(rs.getString("Mno"));
            }
            while(!Mnos.isEmpty()){
                String Mno = Mnos.remove();
                Movie movie = MovieSystemDB.getMovieTable().select(Mno);
                movies.put(new MovieSearched(movie));
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            DBOpration.closeRsStmt(rs, stmt);
        }
        return movies;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String Mname = req.getParameter("Mname");
        ServletUtils.resJsonString(resp, JSON.toJSONString(searchMovie(Mname)));
    }

}
