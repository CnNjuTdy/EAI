package service;

import entity.CommonData;
import entity.GewalaPlan;
import entity.TaoppPlan;
import entity.UniformPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spider.GewaraSpider;
import spider.TaopiaopiaoSpider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fulinhua on 2017/6/11.
 */
@Service
public class SearchMovieService  {

    @Autowired
    private GewaraSpider gewaraSpider;
    @Autowired
    private TaopiaopiaoSpider taopiaopiaoSpider;


    public List<UniformPlan> getPlansByMovie(String movieName){
        List<GewalaPlan> gewalaPlanList=gewaraSpider.getPlansByDB(movieName);
        List<UniformPlan> uniformList=new ArrayList<>();
        for(GewalaPlan gewalaplan:gewalaPlanList){
            UniformPlan uniform=new UniformPlan();
            uniform.setStart(gewalaplan.getStart());
            uniform.setDate(gewalaplan.getDate());
            uniform.setmName(gewalaplan.getmName());
            uniform.setcName(gewalaplan.getcName());
            uniform.setEnd(gewalaplan.getEnd());
            uniform.setGewala_price(gewalaplan.getPrice());
            uniform.setGewala_th(gewalaplan.getTh());
            CommonData common=new CommonData();
            common.setMovie_name(gewalaplan.getmName());
            common.setCinema_name(gewalaplan.getcName());
            common.setDate(gewalaplan.getDate());
            common.setStart(gewalaplan.getStart());
            TaoppPlan taobao=taopiaopiaoSpider.getSinglePlanByCommonData(common);
            if(taobao==null){
                uniform.setTaobao_price(-1);
                uniform.setTaobao_th("无");
            }else{
                uniform.setTaobao_th(taobao.getTh());
                uniform.setTaobao_price(taobao.getPrice());
            }
            uniformList.add(uniform);
        }


        return uniformList;
    }




}
