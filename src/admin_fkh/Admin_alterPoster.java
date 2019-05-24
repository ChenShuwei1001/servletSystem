package admin_fkh;

//import database.movieSystem.MovieSystemDB;
//import database.movieUtil.Movie;
//import database.movieUtil.MovieTable;

import database.movieSystem.MovieSystemDB;
import database.movieUtil.Movie;
import database.movieUtil.MovieTable;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

@MultipartConfig(location = "D://")//测试路径
public class Admin_alterPoster extends HttpServlet {
    //删除原海报 拷贝新海报
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        DiskFileItemFactory factoy=new DiskFileItemFactory();
        //创建解析器
        ServletFileUpload sfu=new ServletFileUpload(factoy);
        sfu.setFileSizeMax(1024 * 1024 * 5);//设置单个上传文件的大小
        sfu.setHeaderEncoding("UTF-8");//设置字符编码
        try {
            List<FileItem> list=sfu.parseRequest(req);
            String bname=list.get(0).getString("utf-8");
            String bname2=list.get(1).getString("utf-8");
            //设置图片保存的目录
            String path=bname2;
            //使用目录和文件名称创建目标文件
            File f=new File(path);
            //保存文件
            list.get(2).write(f);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
        }
    }
}
