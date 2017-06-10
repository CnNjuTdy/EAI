package dao;

import entity.GewalaPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tondiyee on 2017/6/10.
 */
@Repository
public class GewalaPlanDao extends BaseDao {
    public List<GewalaPlan> findAll(){
        return findBySQL("select * from GewalaPlan",null,GewalaPlan.class);
    }
}
