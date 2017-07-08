package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Tondiyee on 2017/6/1.
 */
@Controller
@RequestMapping("/movie")
@SessionAttributes(value = {"datalist"})
public class MovieController {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String index(){
//        System.out.println("hhhhhh");
        return "home";
    }


    @RequestMapping(value="/getPlan")
    public String inputBook(ModelMap model, String movieName){
//
        return "showData";
    }

}
