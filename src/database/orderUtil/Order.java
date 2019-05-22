package database.orderUtil;

import database.baseInterfaces.ClassFunction;

public class Order  implements ClassFunction{
    private String Ono;
    private String OdateTime;
    private String Sno;
    private String Uno;

    public Order() {
        this.Ono = null;
        this.OdateTime = null;
        this.Sno = null;
        this.Uno = null;
    }

    public Order(String Ono, String Odate, String Sno, String Uno) {
        this.Ono = Ono;
        this.OdateTime = Odate;
        this.Sno = Sno;
        this.Uno = Uno;
    }

    @Override
    public String showSelf() {
        return "{" +
                this.Ono + ", " +
                this.OdateTime + ", " +
                this.Sno  + ", "+
                this.Uno + "}";
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
}
