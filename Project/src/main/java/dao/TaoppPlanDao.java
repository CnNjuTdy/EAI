package dao;

import entity.TaoppPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fulinhua on 2017/6/10.
 */
@Repository
public class TaoppPlanDao extends BaseDao {
    public List<TaoppPlan> findAll(){
        return findBySQL("select * from TaoppPlan",null,TaoppPlan.class);
    }
}
