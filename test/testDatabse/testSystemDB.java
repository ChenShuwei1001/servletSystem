package testDatabse;

import database.movieSystem.MovieSystemDB;

public class testSystemDB {
    public static void main(String[] args) {
        //init datebase
        MovieSystemDB.DBinit();
        MovieSystemDB.DBclose();
        MovieSystemDB.DBinit();

        //insert some data
        TestMovieTable.handleMovieTable();
        TestUserTable.handleUserTable();
        TestTheaterTable.handleTheaterTable();
        TestSceneTable.handleSceneTable();
        TestOrderTable.handleOrderTable();
    }
}
