package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spider.GewaraSpider;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Tondiyee on 2017/6/1.
 */
@Controller
//@RequestMapping("/top")
public class IndexController  {

    @Resource(name = "GewaraSpider")
    GewaraSpider gewaraSpider;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView index(){

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/wonder",method = RequestMethod.GET)
    public ModelAndView wonder(HttpServletRequest request){
        String wonder = request.getParameter("wonder");
        try {
            gewaraSpider.getPlans();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("wonder");
    }

}
