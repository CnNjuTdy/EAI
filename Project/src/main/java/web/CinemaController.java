package web;

import entity.UniformPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.SearchCinemaService;

import java.util.List;

/**
 * Created by fulinhua on 2017/6/11.
 */
@Controller
@RequestMapping("/cinema")
@SessionAttributes(value = {"datalist"})
public class CinemaController {

    @RequestMapping(value = "/cinemahome",method = RequestMethod.GET)
    public String index(){
//        System.out.println("hhhhhh");
        return "CinemaHome";
    }

    @Autowired
    SearchCinemaService searchCinemaService;

    @RequestMapping(value="/getPlan")
    public String getData(ModelMap model, String cinemaName){
//        System.out.println("hhhhhhhhh");
        System.out.println(cinemaName);
//        String movieName = request.getParameter("wonder");
        List<UniformPlan> datalist=searchCinemaService.getPlansByCinema(cinemaName);
        model.addAttribute("datalist",datalist);
//        model.put("datalist",datalist);
        System.out.println(datalist.size());
//        int ume=0,jinyi=0,lu=0,peace=0;
//        for (int i=0;i<datalist.size();i++) {
//            switch (datalist.get(i).getcName()){
//                case "UME国际影城(玄武门店)":ume++;break;
//                case "金逸影城(大观店)":jinyi++;break;
//                case "卢米埃影城(紫峰店)":lu++;break;
//                case "和平影视娱乐城":peace++;break;
//                default:break;
//            }
//            System.out.println(datalist.get(i));
//        }
//        System.out.println(ume+" " +jinyi+" "+lu+" "+peace+" ");
//        model.addAttribute("ume",ume);
//        model.addAttribute("jinyi",jinyi);
//        model.addAttribute("lu",lu);
//        model.addAttribute("peace",peace);
        return "showCinemaData";
    }

}
