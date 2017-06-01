package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tondiyee on 2017/6/1.
 */
@Controller
@RequestMapping("/top")
public class IndexController  {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("index");
    }


}
