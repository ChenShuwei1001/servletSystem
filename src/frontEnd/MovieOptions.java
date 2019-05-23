package frontEnd;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import database.DBOpration;
import database.movieUtil.Movie;
import database.movieUtil.MovieTable;
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

@WebServlet(name = "MovieOptions", urlPatterns = {"/MovieOptions"})
public class MovieOptions extends HttpServlet {

    public MovieOptions(){}

    public LinkedBlockingQueue<LinkedBlockingQueue<String>> getOptions(){
        LinkedBlockingQueue<LinkedBlockingQueue<String>> options = new LinkedBlockingQueue<>();
        String sql = "Select Distinct %s From " + MovieTable.movieTableName;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(String.format(sql, "Mtype"));
            LinkedBlockingQueue<String> Mtype = new LinkedBlockingQueue<>();
            while(rs.next()){
                Mtype.put(rs.getString("Mtype"));
            }

            rs = stmt.executeQuery(String.format(sql, "Mlocation"));
            LinkedBlockingQueue<String> Mlocation = new LinkedBlockingQueue<>();
            while(rs.next()){
                Mlocation.put(rs.getString("Mlocation"));
            }

            LinkedBlockingQueue<String> Mlanguage = new LinkedBlockingQueue<>();
            rs = stmt.executeQuery(String.format(sql, "Mlanguage"));
            while(rs.next()){
                Mlanguage.put(rs.getString("Mlanguage"));
            }

            options.put(Mtype);
            options.put(Mlocation);
            options.put(Mlanguage);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            DBOpration.closeRsStmt(rs, stmt);
        }
        return options;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletUtils.resJsonString(resp, JSON.toJSONString(getOptions()));
    }

}
