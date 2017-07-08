package dao;

import entity.Comment;
import entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spider.Maoyan;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tondiyee on 2017/7/8.
 */
@Repository
public class CommentDao extends BaseDao {
    @Autowired
    Maoyan maoyan;

    public List<Comment> getComments() {
        return findBySQL("select * from comment", null, Comment.class);
    }

    public void saveAll() {
        List<Movie> movies = findBySQL("select * from movie", null, Movie.class);
        try {
            for (Movie movie : movies) {
                List<Comment> comments = maoyan.getComments(movie.getMaoyanId() + "", movie.getId() + "");

                for (Comment comment : comments) {
                    Object[] params = {comment.getMovieId(), comment.getScore(), comment.getComment(), comment.getPreScore()};
                    updateBySQL("insert into comment(movie_id,score,comment,preScore) values(?,?,?,?)", params);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
