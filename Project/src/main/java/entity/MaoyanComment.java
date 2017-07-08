package entity;

/**
 * Created by fulinhua on 2017/7/8.
 */
public class MaoyanComment {
    private String movieName;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String tag;

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

    private double Score;
    private String comment;
public String toString(){

    return "电影:"+movieName+" 类型:"+tag+" 打分:"+Score+" 评论:"+comment;

}
}
