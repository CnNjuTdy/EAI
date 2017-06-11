package dao;

import entity.CommonData;
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

    public List<TaoppPlan> findByName(String movieName) {
        String[] parms=new String[1];
        parms[0]=movieName;
        return findBySQL("select * from taobao_plan where m_name=?",parms, TaoppPlan.class);
    }

    public TaoppPlan findPlanByCommonData(CommonData common) {
        String[] parms=new String[4];
        parms[0]=common.getMovie_name();
        parms[1]=common.getCinema_name();
        parms[2]=common.getStart();
        parms[3]=common.getDate();
        List<TaoppPlan> list=findBySQL("select * from taobao_plan where m_name=? and c_name=? and start=? and date=?",parms, TaoppPlan.class);
        return list.size()==0?null:list.get(0);
    }

    public List<TaoppPlan> findByCinemaName(String cinema){
        String[] parms=new String[1];
        parms[0]=cinema;
        return findBySQL("select * from taobao_plan where c_name=?",parms, TaoppPlan.class);
    }
}
