package admin_fkh;

import database.movieSystem.MovieSystemDB;
import database.movieUtil.MovieTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class Admin_delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        String Mnno=req.getParameter("Mnooo");
        String path=req.getParameter("Mnnpath");

        MovieSystemDB.DBinit();
        MovieTable movieTable = MovieSystemDB.getMovieTable();
        movieTable.delete(Mnno);


        //删除haibao
        File file=new File(path);
        file.delete();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
