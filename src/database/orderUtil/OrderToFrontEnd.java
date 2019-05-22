package database.orderUtil;

import com.alibaba.fastjson.annotation.JSONField;
import database.movieUtil.Movie;
import database.sceneUtil.Scene;
import database.theaterUtil.Theater;

public class OrderToFrontEnd {
    @JSONField(name = "Odate")
    private String Odate;
    @JSONField(name = "Ono")
    private String Ono;
    @JSONField(name = "Mname")
    private String Mname;
    @JSONField(name = "Tname")
    private String Tname;
    @JSONField(name = "roomName")
    private String roomName;
    @JSONField(name = "seat")
    private String seat;
    @JSONField(name = "beginDate")
    private String beginDate;
    @JSONField(name = "beginTime")
    private String beginTime;
    @JSONField(name = "price")
    private Double price;

    public OrderToFrontEnd(Order order, Movie movie, Scene scene, Theater theater){
        String []dateTime = order.getOdateTime().split(" ");
        this.Odate = dateTime[0];
        this.Ono = order.getOno();
        this.Mname = movie.getMname();
        this.Tname = theater.getTname();
        this.roomName = scene.getRoomName();
        this.seat = order.getSeat();
        this.beginDate = scene.getSdate();
        this.beginTime = scene.getBeginTime();
        this.price = scene.getPrice();
    }

    public String getOdate() {
        return Odate;
    }

    public void setOdate(String odate) {
        Odate = odate;
    }

    public String getOno() {
        return Ono;
    }

    public void setOno(String ono) {
        Ono = ono;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
