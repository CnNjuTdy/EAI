package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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


    @RequestMapping(value="/getPlan")
    public String getData(ModelMap model, String cinemaName){
//
        return "showCinemaData";
    }

}
