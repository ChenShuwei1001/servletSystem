package Sevlet;

import com.alibaba.fastjson.annotation.JSONField;

public class Welcome {
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

    public Welcome(int moviesNum, int userNum, int orderNum, int theaterNum, int sceneNum) {
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

    public Welcome() {
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
