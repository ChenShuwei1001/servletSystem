package database.orderUtil;

import database.baseInterfaces.ClassFunction;

public class Order  implements ClassFunction{
    private String Ono;
    private String OdateTime;
    private String Sno;
    private String Uno;
    private String seat;

    public Order() {
        this.Ono = null;
        this.OdateTime = null;
        this.Sno = null;
        this.Uno = null;
        this.seat = null;
    }

    public Order(String Ono, String Odate, String Sno, String Uno, String seat) {
        this.Ono = Ono;
        this.OdateTime = Odate;
        this.Sno = Sno;
        this.Uno = Uno;
        this.seat = seat;
    }

    @Override
    public String showSelf() {
        return "{" +
                this.Ono + ", " +
                this.OdateTime + ", " +
                this.Sno  + ", "+
                this.Uno + ", " +
                this.seat + "}";
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
}
