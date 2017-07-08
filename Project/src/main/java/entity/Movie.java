package entity;

/**
 * Created by Tondiyee on 2017/6/10.
 */
public class Movie {
    private int id;
    private int maoyanId;
    private int doubanId;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDoubanId(int doubanId) {
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


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", maoyanId=" + maoyanId +
                ", doubanId=" + doubanId;
    }
}
