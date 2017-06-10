package dao;

import entity.Cinema;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tondiyee on 2017/6/10.
 */
@Repository
public class CinemaDao extends BaseDao{
    public List<Cinema> findAll(){
        return findBySQL("select * from cinema",null,Cinema.class);
    }
}
