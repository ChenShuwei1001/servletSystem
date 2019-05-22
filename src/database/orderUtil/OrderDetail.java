package database.orderUtil;

import database.movieUtil.Movie;
import database.sceneUtil.Scene;
import database.theaterUtil.Theater;

public class OrderDetail {
    private String Ono;
    private String Mname;
    private String beginDate;
    private String beginTime;
    private String Tname;
    private String Taddress;
    private String Ttel;
    private String roomName;
    private String seat;
    private double price;

    public OrderDetail(){}

    public OrderDetail(Order order, Movie movie, Scene scene, Theater theater){
        this.Ono = order.getOno();
        this.Mname = movie.getMname();
    }

    public String getOno() {
        return Ono;
    }

    public String getMname() {
        return Mname;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public String getTname() {
        return Tname;
    }

    public String getTaddress() {
        return Taddress;
    }

    public String getTtel() {
        return Ttel;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public void setOno(String Ono){
        this.Ono = Ono;
    }

    public void setMname(String Mname) {
        this.Mname = Mname;
    }
    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public void setTaddress(String taddress) {
        Taddress = taddress;
    }

    public void setTtel(String ttel) {
        Ttel = ttel;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
