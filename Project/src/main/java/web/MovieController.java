package web;

import entity.UniformPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.SearchMovieService;

import java.util.List;

/**
 * Created by Tondiyee on 2017/6/1.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @Autowired
    SearchMovieService searchMovieService;

    @RequestMapping(value="/getPlan")
    public String inputBook(Model model,String movieName){
        List<UniformPlan> datalist=searchMovieService.getPlansByMovie(movieName);
        model.addAttribute("data",datalist);
        return "showData";
    }

}
