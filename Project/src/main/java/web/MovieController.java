package web;

import entity.UniformPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.SearchMovieService;

import java.util.List;

/**
 * Created by Tondiyee on 2017/6/1.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String index(){
        System.out.println("hhhhhh");
        return "home";
    }

    @Autowired
    SearchMovieService searchMovieService;

    @RequestMapping(value="/getPlan")
    public String inputBook(Model model,String movieName){
        System.out.println(movieName);
//        String movieName = request.getParameter("wonder");
        List<UniformPlan> datalist=searchMovieService.getPlansByMovie(movieName);
        model.addAttribute("data",datalist);
        for (int i=0;i<datalist.size();i++)
            System.out.println(datalist.get(i));
        return "showData";
    }

}
