package Sevlet;

import com.alibaba.fastjson.annotation.JSONField;

public class Welcome_1 {
    @JSONField(name = "MoviesNum")
    private int MoviesNum;
    @JSONField(name = "UserNum")
    private int UserNum;
    @JSONField(name = "OrderNum")
    private int OrderNum;
    @JSONField(name = "TheaterNum")
    private int TheaterNum;
    @JSONField(name = "SceneNum")
    private int SceneNum;

    public Welcome_1(int moviesNum, int userNum, int orderNum, int theaterNum, int sceneNum) {
        MoviesNum = moviesNum;
        UserNum = userNum;
        OrderNum = orderNum;
        TheaterNum = theaterNum;
        SceneNum = sceneNum;
    }

    public int getTheaterNum() {
        return TheaterNum;
    }

    public void setTheaterNum(int theaterNum) {
        TheaterNum = theaterNum;
    }

    public int getSceneNum() {
        return SceneNum;
    }

    public void setSceneNum(int sceneNum) {
        SceneNum = sceneNum;
    }

    public Welcome_1() {
    }

    public int getMoviesNum() {
        return MoviesNum;
    }

    public void setMoviesNum(int moviesNum) {
        MoviesNum = moviesNum;
    }

    public int getUserNum() {
        return UserNum;
    }

    public void setUserNum(int userNum) {
        UserNum = userNum;
    }

    public int getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(int orderNum) {
        OrderNum = orderNum;
    }
}
