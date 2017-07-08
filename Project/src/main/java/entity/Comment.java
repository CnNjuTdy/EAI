package entity;

/**
 * Created by fulinhua on 2017/7/8.
 */
public class Comment {
    private int id;
    private String movieId;
    private double score;
    private double preScore;
    private String comment;

    public double getPreScore() {
        return preScore;
    }

    public void setPreScore(double preScore) {
        this.preScore = preScore;
    }

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
}
