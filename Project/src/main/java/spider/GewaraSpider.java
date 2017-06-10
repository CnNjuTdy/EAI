package spider;

import dao.CinemaDao;
import dao.GewalaPlanDao;
import dao.MovieDao;
import entity.Cinema;
import entity.GewalaPlan;
import entity.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.DateUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fulinhua on 2017/6/10.
 */
@Service
public class GewaraSpider {
    @Autowired
    private CinemaDao dao1;
    @Autowired
    private MovieDao dao2;
    @Autowired
    private GewalaPlanDao dao3;

    private final static String URL="http://www.gewara.com/movie/ajax/getOpiItemNew.xhtml";

    /*
    参数
    movieid:电影ID
    fyrq:放映日期
    cid:影院ID
     */
    public static List<GewalaPlan> getData(HashMap<String,String> parms) throws IOException {

        List<GewalaPlan> result=new ArrayList<>();
        Document doc = Jsoup.connect(URL).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").data(parms).get();
        Elements es=doc.getElementsByClass("chooseOpi_body");
        Elements lis=es.select("ul").get(0).select("li");
       String cName=doc.getElementById("opiCinemaDetail").select("a").get(0).text();

        for (Element li:lis
                ) {
            GewalaPlan gewalaPlan=new GewalaPlan();
            gewalaPlan.setcId(Integer.parseInt(parms.get("cid")));
            gewalaPlan.setmId(Integer.parseInt(parms.get("movieid")));
            gewalaPlan.setcName(cName);
            gewalaPlan.setDate(parms.get("fyrq"));

            Elements ems=li.select("em");
            Elements labels=li.select("label");
            Elements bs=li.select("b");

            gewalaPlan.setStart(bs.get(0).text());
            gewalaPlan.setEnd(ems.get(0).text());
            gewalaPlan.setPrice(Double.parseDouble(bs.get(1).text()));
            gewalaPlan.setTh(labels.get(0).text());
            result.add(gewalaPlan);
        }
      return result;
    }


    public void getPlans() throws IOException {
        List<Cinema> cinemas = dao1.findAll();
        List<Movie> movies = dao2.findAll();
        for (Cinema cinema:cinemas){
            for(Movie movie:movies){
                HashMap<String, String> params = new HashMap<>();
                params.put("movieid", movie.getGewalaId()+"");
                params.put("fyrq", DateUtil.get2Day());//
                params.put("cid", cinema.getGewalaId()+"");


               List<GewalaPlan> list= getData(params);
                // TODO: 2017/6/10  doc转plan
for(GewalaPlan ge:list)
                System.out.println(ge.toString());
              //  dao3.save(plan);

            }
        }
    }
}
