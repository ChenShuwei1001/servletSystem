package database.orderUtil;

import database.baseInterfaces.ClassFunction;

public class Order  implements ClassFunction{
    private String Ono;
    private String OdateTime;
    private String Sno;
    private String Uno;
    private String seat;
    private double price;

    public Order() {
        this.Ono = null;
        this.OdateTime = null;
        this.Sno = null;
        this.Uno = null;
        this.seat = null;
        this.price = 0;
    }

    public Order(String Ono, String Odate, String Sno, String Uno, String seat, double price) {
        this.Ono = Ono;
        this.OdateTime = Odate;
        this.Sno = Sno;
        this.Uno = Uno;
        this.seat = seat;
        this.price = price;
    }

    @Override
    public String showSelf() {
        return "{" +
                this.Ono + ", " +
                this.OdateTime + ", " +
                this.Sno  + ", "+
                this.Uno + ", " +
                this.seat + ", " +
                Double.toString(this.price) + "}";
    }
    public String getOno() {
        return Ono;
    }

    public void setOno(String ono) {
        Ono = ono;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getOdateTime() {
        return OdateTime;
    }

    public void setOdateTime(String odateTime) {
        OdateTime = odateTime;
    }

    public String getUno() {
        return Uno;
    }

    public void setUno(String uno) {
        Uno = uno;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
