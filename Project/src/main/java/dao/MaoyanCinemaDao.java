package dao;

import entity.MaoyanCinema;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tondiyee on 2017/6/10.
 */
@Repository
public class MaoyanCinemaDao extends BaseDao{
    public List<MaoyanCinema> findAll(){
        return findBySQL("select * from maoyan_cinema",null,MaoyanCinema.class);
    }
}
