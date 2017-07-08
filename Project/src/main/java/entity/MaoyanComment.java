package entity;

/**
 * Created by fulinhua on 2017/7/8.
 */
public class MaoyanComment {
    private int id;
    private String movieId;
    private String name;
    private double score;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public String toString() {

        return "电影:" + name + " 打分:" + score + " 评论:" + comment;

    }
}
