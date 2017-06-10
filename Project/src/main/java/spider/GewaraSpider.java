package spider;

import dao.CinemaDao;
import dao.GewalaPlanDao;
import dao.MovieDao;
import entity.Cinema;
import entity.GewalaPlan;
import entity.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.DateUtil;

import java.io.IOException;
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

//    public static void main(String[] args) throws IOException {
//        //影院信息
//
//        HashMap<String, String> parms = new HashMap<>();
//        parms.put("movieid", "323881451");
//        parms.put("fyrq", "315");
//        parms.put("cid", "37950723");
//        getData(parms);
//
//    }
//
//    public static void getData(HashMap<String, String> parms) throws IOException {
//
//        String url = "http://www.gewara.com/movie/ajax/getOpiItemNew.xhtml";
//
//        Document doc = Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").data(parms).get();
//
//        System.out.println(doc.toString());
//    }


    public void getPlans() throws IOException {
        List<Cinema> cinemas = dao1.findAll();
        List<Movie> movies = dao2.findAll();
        for (Cinema cinema:cinemas){
            for(Movie movie:movies){
                HashMap<String, String> params = new HashMap<>();
                params.put("movieid", movie.getGewalaId()+"");
                params.put("fyrq", DateUtil.get2Day());//
                params.put("cid", cinema.getGewalaId()+"");

                String url = "http://www.gewara.com/movie/ajax/getOpiItemNew.xhtml";

                Document doc = Jsoup.connect(url)
                        .header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
                        .data(params).get();
                GewalaPlan plan = null;
                // TODO: 2017/6/10  doc转plan

                System.out.println(plan);
                dao3.save(plan);

            }
        }
    }
}
