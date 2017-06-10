package dao;

import entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tondiyee on 2017/6/10.
 */
@Repository
public class MovieDao extends BaseDao{
    public List<Movie> findAll(){
        return findBySQL("select * from movie",null,Movie.class);
    }
}
