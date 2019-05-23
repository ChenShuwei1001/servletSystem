package database.userUtil;

import database.baseInterfaces.ClassFunction;

public class User implements ClassFunction {

    private String Uno;         //primary key
    private String Uname;       //the name of the userUtil
    private String Upswd;   //the password of a userUtil
    //Do not store password plaintext in database, you should store password coded by some algorithm
    private String Utel;    //the userUtil's telephone
    private double Ubalance;       //the balance of a userUtil

    public User() {
        this.Uno = null;
        this.Uname = null;
        this.Upswd= null;
        this.Utel = null;
        this.Ubalance = 0;
    }

    public User(String Uno, String Unama, String Upswd,
                String Utel, double Ubalance) {
        this.Uno = Uno;
        this.Uname = Unama;
        this.Upswd = Upswd;
        this.Utel = Utel;
        this.Ubalance = Ubalance;
    }

    @Override
    public String showSelf() {
        return "{" +
                this.Uno + ", " +
                this.Uname + ", " +
                this.Upswd + ", " +
                this.Utel + ", " +
                Double.toString(this.Ubalance) + "}";
    }

    public String getUno() {
        return Uno;
    }

    public void setUno(String uno) {
        Uno = uno;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUpswd() {
        return Upswd;
    }

    public void setUpswd(String upswd) {
        Upswd = upswd;
    }

    public double getUbalance() {
        return Ubalance;
    }

    public void setUbalance(double ubalance) {
        Ubalance = ubalance;
    }

    public String getUtel() {
        return Utel;
    }

    public void setUtel(String utel) {
        Utel = utel;
    }
}
