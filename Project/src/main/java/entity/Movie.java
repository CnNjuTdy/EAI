package entity;

/**
 * Created by Tondiyee on 2017/6/10.
 */
public class Movie {
    private int id;
    private int maoyanId;
    private int doubanId;


    public Movie(int id, int maoyanId, int doubanId) {
        this.id = id;
        this.maoyanId = maoyanId;
        this.doubanId = doubanId;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaoyanId() {
        return maoyanId;
    }

    public void setMaoyanId(int maoyanId) {
        this.maoyanId = maoyanId;
    }

    public int getDoubanId() {
        return doubanId;
    }

    public void setDoubanId(int doubanId) {
        this.doubanId = doubanId;
    }
}
