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

    public List<GewalaPlan> findByName(String movieName) {
        String[] parms=new String[1];
        parms[0]=movieName;
        return findBySQL("select * from gewala_plan where m_name=?",parms,GewalaPlan.class);
    }
}
