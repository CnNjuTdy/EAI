package spider;

import dao.CinemaDao;
import dao.MovieDao;
import entity.Cinema;
import entity.MaoyanPlan;
import entity.Movie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.DateUtil;
import util.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tondiyee on 2017/6/10.
 */
@Service
public class MaoyanSpider {
    @Autowired
    private CinemaDao dao1;
    @Autowired
    private MovieDao dao2;

    //保存3天的数据情况，每天1点更新……
    //访问太快貌似被封号了，所以这里不能频繁访问，应该要实时访问了……不过代码应该和下面的差别不大
    public void getPlans() throws IOException {
        List<Cinema> cinemas = dao1.findAll();
        List<Movie> movies = dao2.findAll();
        for (Cinema cinema : cinemas) {
            for (Movie movie : movies) {
                String url = "http://m.maoyan.com/showtime/wrap.json";
                HashMap<String, String> params = new HashMap<>();
                params.put("movieid", movie.getMaoyanId() + "");
                params.put("cinemaid", cinema.getMaoyanId() + "");
                Document doc = Jsoup.connect(url).
                        header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").
                        data(params).get();
                JSONObject dateShows = new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("DateShow");
                if (dateShows.toString().equals("{}")) {
                    continue;
                }
                String movieName = new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("currentMovie").getString("nm");
                String cinemaName = new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("cinemaDetailModel").getString("nm");
                JSONArray array2;
                try {
                    array2 = dateShows.getJSONArray(DateUtil.get2Day());
                } catch (JSONException e) {
                    array2 = new JSONArray();
                }
                for (int i = 0; i < array2.length(); i++) {
                    HttpUtil.setProxyIp();
                    JSONObject show = array2.getJSONObject(i);
                    String url2 = "http://m.maoyan.com/show/seats";
                    HashMap<String, String> params2 = new HashMap<>();
                    params2.put("showId", show.get("showId") + "");
                    params2.put("showDate", show.getString("dt"));
                    Document priceInfo = Jsoup.connect(url2)
                            .header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
                            .data(params2).get();
                    double price = new JSONObject(priceInfo.body().text()).getJSONObject("showInfo").getDouble("price");
                    MaoyanPlan plan = new MaoyanPlan(show.getString("dt") + cinema.getId() + "" + movie.getId() + "" + i,
                            cinema.getMaoyanId(), movie.getMaoyanId(), cinemaName, movieName, show.getString("dt"),
                            show.getString("tm"), show.getString("end"), show.getString("th"), price);
                    System.out.println(plan);
                    try {
                        Thread.sleep((long) (1000+1000*Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
