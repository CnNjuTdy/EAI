package dao;

import entity.MaoyanMovie;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tondiyee on 2017/6/10.
 */
@Repository
public class MaoyanMovieDao extends BaseDao{
    public List<MaoyanMovie> findAll(){
        return findBySQL("select * from maoyan_movie",null,MaoyanMovie.class);
    }
}
