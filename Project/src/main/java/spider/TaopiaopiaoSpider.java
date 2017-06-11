package spider;

import dao.CinemaDao;
import dao.MovieDao;
import dao.TaoppPlanDao;
import entity.Cinema;
import entity.CommonData;
import entity.Movie;
import entity.TaoppPlan;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.DateUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fulinhua on 2017/6/10.
 */
@Repository
public class TaopiaopiaoSpider {
    @Autowired
    private CinemaDao dao1;
    @Autowired
    private MovieDao dao2;
    @Autowired
    private TaoppPlanDao dao3;

    private final static String URL = "https://dianying.taobao.com/showDetailSchedule.htm";


//    public static void main(String[] args) throws IOException {
//        //影院信息
//
//        HashMap<String, String> parms = new HashMap<>();
//        parms.put("showId", "150686");
//        parms.put("cinemaId", "35999");
//        parms.put("date", "2017-06-10");
//        parms.put("regionName", "");
//        parms.put("n_s", "new");
//        getData(parms);
//
//    }

    public static List<TaoppPlan> getData(HashMap<String, String> parms,String movieName,String cinemaName) throws IOException {

        List<TaoppPlan> result = new ArrayList<>();

        parms.put("regionName", "");
        parms.put("n_s", "new");
        Document doc = Jsoup.connect(URL).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").data(parms).get();
        Element tbody = doc.select("tbody").get(0);
      //  String cName = doc.select("h4").get(0).text();

        for (Element tr : tbody.select("tr")) {
            TaoppPlan taoppPlan=new TaoppPlan();
            taoppPlan.setcId(Integer.parseInt(parms.get("cinemaId")));
            taoppPlan.setmId(Integer.parseInt(parms.get("showId")));
            taoppPlan.setcName(cinemaName);
            taoppPlan.setmName(movieName);
            taoppPlan.setDate(parms.get("date"));
            Elements tds = tr.select("td");
            String start = tds.get(0).select("em").get(0).text();
            String end = tds.get(0).text();
            String th = tds.get(2).text();
            String price = tds.get(4).select("em").get(0).text();
            taoppPlan.setStart(start);
            taoppPlan.setEnd(end);
            taoppPlan.setTh(th);
            taoppPlan.setPrice(Double.parseDouble(price));
            result.add(taoppPlan);
        }
        return result;
    }

    public List<TaoppPlan> getPlansByDB(String movieName){
        return dao3.findByName(movieName);
    }

    public void getPlansBySpider() throws IOException {
        List<Cinema> cinemas = dao1.findAll();
        List<Movie> movies = dao2.findAll();
        for (Cinema cinema : cinemas) {
            for (Movie movie : movies) {
                HashMap<String, String> params = new HashMap<>();
                params.put("showId", movie.getTaobaoId() + "");
                params.put("date", DateUtil.get2Day());//
                params.put("cinemaId", cinema.getTaobaoId() + "");


                List<TaoppPlan> list = getData(params,movie.getName(),cinema.getName());
                // TODO: 2017/6/10  doc转plan
                for (TaoppPlan tp : list)
                  dao3.save(tp);

            }
        }
    }

    public  TaoppPlan getSinglePlanByCommonData(CommonData common) {
        return dao3.findPlanByCommonData(common);
    }

    public List<TaoppPlan> getPlansByCinema(String cinema) {
        return dao3.findByCinemaName(cinema);
    }
}
