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
    public Movie findByName(String movieName){
        String[] parms=new String[1];
        parms[0]=movieName;
        List<Movie> list=findBySQL("select * from movie where name=?",parms,Movie.class);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
