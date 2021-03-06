package database.userUtil;

import database.DBOpration;
import database.baseInterfaces.TableOperation;
import database.movieSystem.MovieSystemDB;
import logger.SimpleLogger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTable implements TableOperation {
    public static final String userTableName = "user";

    /**
     *  create table with name @userTableName
     */
    @Override
    public void createTable() {
        String sql = "Create Table "+ userTableName +"(" +
                "Uno Char(50) Primary Key," +
                "Uname Char(20)," +
                "Upswd Char(20)," +
                "Utel Char(20)," +
                "Ubalance Double)" +
                " Default Charset = utf8";
        DBOpration.executeSql(sql);
    }

    /**
     *  drop table with name @userTableName
     */
    @Override
    public void dropTable() {
        String sql = "Drop table " + userTableName;
        DBOpration.executeSql(sql);
    }

    /**
     * @param o an object of class User containing the information needed to
     *              be inserted into table
     * @return a value tells that if the operation is executed successfully
     */
    @Override
    public boolean insert(Object o) {
        String sql = "Insert Into " + userTableName + " Values(?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        User user = (User)o;
        try {
            pstmt = MovieSystemDB.getConn().prepareStatement(sql);

            pstmt.setString(1, user.getUno());
            pstmt.setString(2, user.getUname());
            pstmt.setString(3, user.getUpswd());
            pstmt.setString(4, user.getUtel());
            pstmt.setDouble(5, user.getUbalance());

            if (pstmt.executeUpdate() > 0) {
                SimpleLogger.logger.info("insert " + user.showSelf()
                        + " to table '" + userTableName + "'");
                return true;
            }
            SimpleLogger.logger.error("failed to insert " + user.showSelf()
                    + " to table '" + userTableName + "'");
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
        SimpleLogger.logger.error("failed to insert " + user.showSelf()
                + " to table '" + userTableName + "'");
        return false;
    }

    /**
     * the return value tells that if the operation is executed successfully
     *
     * @param UnoPK the value tells the function which record to select in
     *              the table, as UnoPK is the primary key of a record
     */
    @Override
    public User select(String UnoPK) {
        String sql = "Select * FROM " + userTableName + " Where Uno = '" + UnoPK + "'";
        ResultSet rs = null;
        Statement stmt = null;
        try {

            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {

                User user = new User();

                user.setUno(rs.getString("Uno"));
                user.setUname(rs.getString("Uname"));
                user.setUpswd(rs.getString("Upswd"));
                user.setUtel(rs.getString("Utel"));
                user.setUbalance(rs.getDouble("Ubalance"));
                SimpleLogger.logger.info("select " + user.showSelf() +
                        " from table '" + userTableName + "'");
                return user;
            } else {
                // TODO: 2019/5/2 说明传递给前端首页的电影信息有误
                SimpleLogger.logger.error("failed to select item with Uno values " +
                        UnoPK + " from table '" + userTableName + "'");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //close ResultSet
            DBOpration.closeRsStmt(rs, stmt);
        }
        SimpleLogger.logger.error("failed to select item with Uno values " +
                UnoPK + " from table '" + userTableName + "'");
        return null;
    }

    /**
     * the return value tells that if the operation is executed successfully
     *
     * @param o an object of class User containing the information needed to
     *              be updated into table
     */
    @Override
    public boolean update(Object o) {

        String sql = "Update " + userTableName + " Set ";
        int count = 0;

        User user = (User)o;
        //make sql statement
        //----------------------------------
        if (user.getUname() != null) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" Uname = '" + user.getUname() + "'");
        }
        if (user.getUpswd() != null) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" Upswd = '" + user.getUpswd() + "'");
        }
        if (user.getUtel() != null) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" Utel = '" + user.getUtel() + "'");
        }
        if (user.getUbalance() != 0) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" Ubalance = '" + user.getUbalance() + "'");
        }
        sql += " Where Uno = '" + user.getUno() + "'";
        //----------------------------------

        Statement stmt = null;
        try {
            if (count > 0) {
                stmt = DBOpration.getStmt();
                if (stmt.executeUpdate(sql) > 0) {
                    SimpleLogger.logger.info("update item with Uno '" + user.getUno() +
                            "' in table '" + userTableName + "'");
                    return true;
                }
            }
            //not existing Mno
            SimpleLogger.logger.info("failed to update item with Uno '" +
                    user.showSelf() + "' in table '" + userTableName + "'");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBOpration.closeStmt(stmt);
        }
        //not existing Mno
        SimpleLogger.logger.info("failed to update item with Uno '" +
                user.showSelf() + "' in table '" + userTableName + "'");
        return false;
    }

    /**
     * the return value tells that if the operation is executed successfully
     *
     * @param Uno the value tells the function which record to delete in
     *            the table, as Uno is the primary key of a record
     */
    @Override
    public boolean delete(String Uno) {
        String sql = "Delete From " + userTableName + " Where Uno = '" + Uno + "'";
        Statement stmt = null;
        try {
            stmt = DBOpration.getStmt();
            if (stmt.executeUpdate(sql) > 0) {
                SimpleLogger.logger.info("delete item with Uno '" + Uno + "' from table '"
                        + userTableName + "'");
                return true;
            }
            SimpleLogger.logger.error("failed to delete item with Uno '" + Uno +
                    "' from table '" + userTableName + "'");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBOpration.closeStmt(stmt);
        }
        SimpleLogger.logger.error("failed to delete item with Uno '" + Uno +
                "' from table '" + userTableName + "'");
        return false;
    }
}
