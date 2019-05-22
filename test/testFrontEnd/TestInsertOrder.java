package testFrontEnd;

import database.movieSystem.MovieSystemDB;
import frontEnd.InsertSeatOrder;

public class TestInsertOrder {
    public static void main(String[] args) {
        MovieSystemDB.DBinit();
        InsertSeatOrder insertSeatOrder = new InsertSeatOrder();
        insertSeatOrder.updateSeat("1","4");
        insertSeatOrder.insertOrder("1","1");
    }
}
