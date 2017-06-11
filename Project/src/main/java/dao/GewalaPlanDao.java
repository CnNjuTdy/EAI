package dao;

import entity.CommonData;
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

    public List<GewalaPlan> findByCinemaName(String cinemaName) {
        String[] parms=new String[1];
        parms[0]=cinemaName;
        return findBySQL("select * from gewala_plan where c_name=?",parms,GewalaPlan.class);
    }

    public GewalaPlan findPlanByCommonData(CommonData common) {
        String[] parms=new String[4];
        parms[0]=common.getMovie_name();
        parms[1]=common.getCinema_name();
        parms[2]=common.getStart();
        parms[3]=common.getDate();
        List<GewalaPlan> list=findBySQL("select * from gewala_plan where m_name=? and c_name=? and start=? and date=?",parms, GewalaPlan.class);
        return list.size()==0?null:list.get(0);
    }
}
