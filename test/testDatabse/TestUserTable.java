package testDatabse;

import database.movieSystem.MovieSystemDB;
import database.userUtil.User;
import database.userUtil.UserTable;

public class TestUserTable {
    public static void handleUserTable(){
        MovieSystemDB.DBinit();
        UserTable userTable = MovieSystemDB.getUserTable();

        //test insert
        User user = new User("1", "Kelvin", "wdnmd", "13568994472",
                99999999);
        userTable.insert(user);

        //test select
        User user2 = userTable.select("1");

        //test update
        user2.setUno("2");
        user2.setUname("陈大屌");
        userTable.insert(user2);
        User userUpdate = new User();
        userUpdate.setUno("1");
        userUpdate.setUname("陈叔炜");
        userTable.update(userUpdate);

        //test delete, make a breakpoint here
        userTable.delete(user2.getUno());
    }

    public static void main(String[] args) {
        TestUserTable.handleUserTable();
    }
}
