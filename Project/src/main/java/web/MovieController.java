package web;

import entity.UniformPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.SearchMovieService;

import java.util.List;

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

    @Autowired
    SearchMovieService searchMovieService;

    @RequestMapping(value="/getPlan")
    public String inputBook(ModelMap model, String movieName){
        System.out.println("hhhhhhhhh");
        System.out.println(movieName);
//        String movieName = request.getParameter("wonder");
        List<UniformPlan> datalist=searchMovieService.getPlansByMovie(movieName);
        model.addAttribute("datalist",datalist);
        System.out.println(datalist.size());
        for (int i=0;i<datalist.size();i++)
            System.out.println(datalist.get(i).getcName());
        return "showData";
    }

}
