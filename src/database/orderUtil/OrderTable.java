package database.orderUtil;

import database.DBOpration;
import database.baseInterfaces.TableOperation;
import database.sceneUtil.SceneTable;
import database.movieSystem.MovieSystemDB;
import database.userUtil.UserTable;
import logger.SimpleLogger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderTable implements TableOperation {
    //order is a Reserved-Word in mysql, thus using 'orders' instead of using 'order'
    private static final String tableName = "orders";

    /**
     * create table with name @userTableName
     */
    @Override
    public void createTable() {
        String sql = "Create Table " + tableName + "(" +
                "Ono Char(50) Primary Key," +
                "OdateTime DateTime," +
                "Sno Char(12),"+
                "Uno Char(50), " +
                "seat Char(50), " +
                "price double, " +
                " Foreign Key(Sno) References " +
                SceneTable.sceneTableName + "(Sno)" +
                //todo: order shouldn't be deleted, about money
                " On Delete Cascade On Update Cascade,"+
                " Foreign Key(Uno) References " +
                UserTable.userTableName + "(Uno)" +
                " On Delete Cascade On Update Cascade"+
                " )Default Charset = utf8";
        DBOpration.executeSql(sql);
    }

    /**
     * drop table with name @userTableName
     */
    @Override
    public void dropTable() {
        String sql = "Drop table " + tableName;
        DBOpration.executeSql(sql);
    }

    /**
     * @param o an object of class Order containing the information needed to
     *          be inserted into table
     * @return a value tells that if the operation is executed successfully
     */
    @Override
    public boolean insert(Object o) {
        String sql = "Insert Into " + tableName + " Values(?, ?, ?,?,?,?)";
        PreparedStatement pstmt = null;
        Order order = (Order) o;
        try {
            pstmt = MovieSystemDB.getConn().prepareStatement(sql);

            pstmt.setString(1, order.getOno());
            pstmt.setString(2, order.getOdateTime());
            pstmt.setString(3, order.getSno());
            pstmt.setString(4, order.getUno());
            pstmt.setString(5,order.getSeat());
            pstmt.setDouble(6,order.getPrice());

            if (pstmt.executeUpdate() > 0) {
                SimpleLogger.logger.info("insert " + order.showSelf()
                        + " to table '" + tableName + "'");
                return true;
            }
            SimpleLogger.logger.error("failed to insert " + order.showSelf()
                    + " to table '" + tableName + "'");
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
        SimpleLogger.logger.error("failed to insert " + order.showSelf()
                + " to table '" + tableName + "'");
        return false;
    }

    /**
     * the return value tells that if the operation is executed successfully
     *
     * @param Ono the value tells the function which record to select in
     *            the table, as UnoPK is the primary key of a record
     */
    @Override
    public Order select(String Ono) {
        String sql = "Select * FROM " + tableName + " Where Ono = '" + Ono + "'";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DBOpration.getStmt();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {

                Order order = new Order();

                order.setOno(rs.getString("Ono"));
                order.setOdateTime(rs.getString("Odate"));
                order.setSno(rs.getString("Sno"));
                order.setUno(rs.getString("Uno"));
                order.setSeat(rs.getString("seat"));
                order.setPrice(rs.getDouble("price"));

                SimpleLogger.logger.info("select " + order.showSelf() +
                        " from table '" + tableName + "'");

                return order;
            } else {
                // TODO: 2019/5/2 说明传递给前端首页的电影信息有误
                SimpleLogger.logger.error("failed to select item with Ono values " +
                        Ono + " from table '" + tableName + "'");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBOpration.closeRsStmt(rs, stmt);
        }
        SimpleLogger.logger.error("failed to select item with Ono values " +
                Ono + " from table '" + tableName + "'");
        return null;
    }

    /**
     * the return value tells that if the operation is executed successfully
     *
     * @param o an object of class Order containing the information needed to
     *          be updated into table
     */
    @Override
    public boolean update(Object o) {

        String sql = "Update " + tableName + " Set ";
        int count = 0;

        Order order = (Order) o;
        //make sql statement
        //----------------------------------
        if (order.getOdateTime() != null) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" OdateTime = '" + order.getOdateTime() + "'");
        }
        if (order.getSno() != null) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" Sno = '" + order.getSno() + "'");
        }
        if (order.getUno() != null) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" Uno = '" + order.getUno() + "'");
        }
        if (order.getSeat() != null) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" seat = '" + order.getSeat() + "'");
        }
        if (order.getPrice() != 0) {
            if (0 < count++) {
                sql += ", ";
            }
            sql += (" price = " + order.getPrice() );
        }
        sql += " Where Ono = '" + order.getOno() + "'";
        //----------------------------------
        Statement stmt = null;
        try {
            if (count > 0) {
                stmt = DBOpration.getStmt();
                if (stmt.executeUpdate(sql) > 0) {
                    SimpleLogger.logger.info("update item with Ono '" + order.getOno() +
                            "' in table '" + tableName + "'");
                    return true;
                }
            }
            //not existing Mno
            SimpleLogger.logger.info("failed to update item with Ono '" +
                    order.showSelf() + "' in table '" + tableName + "'");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBOpration.closeStmt(stmt);
        }
        //not existing Mno
        SimpleLogger.logger.info("failed to update item with Ono '" +
                order.showSelf() + "' in table '" + tableName + "'");
        return false;
    }

    /**
     * the return value tells that if the operation is executed successfully
     *
     * @param Ono the value tells the function which record to delete in
     *            the table, as Uno is the primary key of a record
     */
    @Override
    public boolean delete(String Ono) {
        String sql = "Delete From " + tableName + " Where Ono = '" + Ono + "'";
        Statement stmt = null;
        try {
            stmt = DBOpration.getStmt();
            if (stmt.executeUpdate(sql) > 0) {
                SimpleLogger.logger.info("delete item with Ono '" + Ono + "' from table '"
                        + tableName + "'");
                return true;
            }
            SimpleLogger.logger.error("failed to delete item with Ono '" + Ono +
                    "' from table '" + tableName + "'");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBOpration.closeStmt(stmt);
        }
        SimpleLogger.logger.error("failed to delete item with Ono '" + Ono +
                "' from table '" + tableName + "'");
        return false;
    }
}
