package database.theaterUtil;

import database.baseInterfaces.TableOperation;
import database.movieSystem.MovieSystemDB;
import logger.SimpleLogger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TheaterTable implements TableOperation {
    public static final String theaterTableName = "theater";

    /**
     * create table with name @theaterTableName
     */
    @Override
    public void createTable() {
        String sql = "Create Table " + theaterTableName + "(" +
                "Tno Char(12) Primary Key," +
                "Tname Char(30), " +
                "Taddress Char(20))" +
                " Default Charset = utf8";
        try {
            MovieSystemDB.getStmt().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * drop table with name @theaterTableName
     */
    @Override
    public void dropTable() {
        String sql = "Drop table " + theaterTableName;
        try {
            MovieSystemDB.getStmt().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param o an object of class Theater containing the information needed to
     *          be inserted into table
     * @return a value tells that if the operation is executed successfully
     */
    @Override
    public boolean insert(Object o) {
        String sql = "Insert Into " + theaterTableName + " Values(?,?, ?)";
        PreparedStatement pstmt = null;
        Theater theater = (Theater) o;
        try {
            pstmt = MovieSystemDB.getConn().prepareStatement(sql);

            pstmt.setString(1, theater.getTno());
            pstmt.setString(2, theater.getTname());
            pstmt.setString(3, theater.getTaddress());

            if (pstmt.executeUpdate() > 0) {
                SimpleLogger.logger.info("insert " + theater.showSelf()
                        + " to table '" + theaterTableName + "'");
                return true;
            }
            SimpleLogger.logger.error("failed to insert " + theater.showSelf()
                    + " to table '" + theaterTableName + "'");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != pstmt) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        SimpleLogger.logger.error("failed to insert " + theater.showSelf()
                + " to table '" + theaterTableName + "'");
        return false;
    }

    /**
     * the return value tells that if the operation is executed successfully
     *
     * @param TnoPK the value tells the function which record to select in
     *              the table, as TnoPK is the primary key of a record
     */
    @Override
    public Theater select(String TnoPK) {
        String sql = "Select * FROM " + theaterTableName + " Where Tno = '" + TnoPK + "'";
        ResultSet rs = null;
        try {

            rs = MovieSystemDB.getStmt().executeQuery(sql);
            if (rs.next()) {

                Theater theater = new Theater();

                theater.setTno(rs.getString("Tno"));
                theater.setTname(rs.getString("Tname"));
                theater.setTaddress(rs.getString("Taddress"));

                SimpleLogger.logger.info("select " + theater.showSelf() +
                        " from table '" + theaterTableName + "'");
                return theater;
            } else {
                // TODO: 2019/5/2 说明传递给前端首页的电影信息有误
                SimpleLogger.logger.error("failed to select item with Tno values " +
                        TnoPK + " from table '" + theaterTableName + "'");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //close ResultSet
            try {
                if (null != rs) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        SimpleLogger.logger.error("failed to select item with Tno values " +
                TnoPK + " from table '" + theaterTableName + "'");
        return null;
    }

    /**
     * the return value tells that if the operation is executed successfully
     *
     * @param o an object of class Theater containing the information needed to
     *          be updated into table
     */
    @Override
    public boolean update(Object o) {

        String sql = "Update " + theaterTableName + " Set ";
        int count = 0;

        Theater theater = (Theater) o;
        //make sql statement
        //----------------------------------
        if (theater.getTname() != null) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" Tname = '" + theater.getTname() + "'");
        }
        if (theater.getTaddress() != null) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" Taddress = '" + theater.getTaddress() + "'");
        }
        sql += " Where Tno = '" + theater.getTno() + "'";
        //----------------------------------

        SimpleLogger.logger.info(sql);
        try {
            if (count > 0) {
                if (MovieSystemDB.getStmt().executeUpdate(sql) > 0) {
                    SimpleLogger.logger.info("update item with Tno '" + theater.getTno() +
                            "' in table '" + theaterTableName + "'");
                    return true;
                }
            }
            //not existing Mno
            SimpleLogger.logger.info("failed to update item with Tno '" +
                    theater.showSelf() + "' in table '" + theaterTableName + "'");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //not existing Mno
        SimpleLogger.logger.info("failed to update item with Tno '" +
                theater.showSelf() + "' in table '" + theaterTableName + "'");
        return false;
    }

    /**
     * the return value tells that if the operation is executed successfully
     *
     * @param Tno the value tells the function which record to delete in
     *            the table, as Mno is the primary key of a record
     */
    @Override
    public boolean delete(String Tno) {
        String sql = "Delete From " + theaterTableName + " Where Mno = '" + Tno + "'";
        try {
            if (MovieSystemDB.getStmt().executeUpdate(sql) > 0) {
                SimpleLogger.logger.info("delete item with Tno '" + Tno + "' from table '"
                        + theaterTableName + "'");
                return true;
            }
            SimpleLogger.logger.error("failed to delete item with Tno '" + Tno +
                    "' from table '" + theaterTableName + "'");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SimpleLogger.logger.error("failed to delete item with Tno '" + Tno +
                "' from table '" + theaterTableName + "'");
        return false;
    }

}
