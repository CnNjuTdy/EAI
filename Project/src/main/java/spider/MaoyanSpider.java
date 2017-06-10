package spider;

import dao.MaoyanCinemaDao;
import dao.MaoyanMovieDao;
import entity.MaoyanCinema;
import entity.MaoyanMovie;
import entity.MaoyanPlan;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.DateUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tondiyee on 2017/6/10.
 */
@Service
public class MaoyanSpider {
    @Autowired
    private MaoyanCinemaDao dao1;
    @Autowired
    private MaoyanMovieDao dao2;

    //每个月1号更新
    public void getAllCinemas() throws IOException {
        String url = "http://m.maoyan.com/cinemas.json";
        Document document = Jsoup.connect(url)
                .header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
                .get();
        JSONArray data = new JSONObject(document.body().text()).getJSONObject("data").getJSONArray("鼓楼区");
        System.out.println(data);
        for (int i = 0; i < data.length(); i++) {
            JSONObject jsonCinema = data.getJSONObject(i);
            MaoyanCinema cinema = new MaoyanCinema(jsonCinema.getInt("id"),
                    jsonCinema.getString("nm"), jsonCinema.getString("area"),
                    jsonCinema.getString("addr"), jsonCinema.getInt("sellPrice"));
            dao1.save(cinema);
        }
    }

    //每天0点更新
    public void getAllMovies() throws IOException {
        String url = "http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=1000";
        Document document = Jsoup.connect(url)
                .header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
                .get();
        JSONArray movies = new JSONObject(document.body().text()).getJSONObject("data").getJSONArray("movies");
        for (int i = 0; i < movies.length(); i++) {
            JSONObject jsonMovie = movies.getJSONObject(i);
            MaoyanMovie movie = new MaoyanMovie(jsonMovie.getInt("id"), jsonMovie.getString("nm"),
                    jsonMovie.getString("scm"), jsonMovie.getString("dir"),
                    jsonMovie.getString("star"), jsonMovie.getBoolean("3d"),
                    jsonMovie.getBoolean("imax"), jsonMovie.getString("img"));
            dao2.save(movie);
        }
    }

    //保存3天的数据情况，每天1点更新……
    //访问太快貌似被封号了，所以这里不能频繁访问，应该要实时访问了……不过代码应该和下面的差别不大
    public void getPlans() throws IOException {
        List<MaoyanCinema> cinemas = dao1.findAll();
        List<MaoyanMovie> movies = dao2.findAll();
        for (MaoyanCinema cinema : cinemas) {
            for (MaoyanMovie movie : movies) {
                String url = "http://m.maoyan.com/showtime/wrap.json";
                HashMap<String, String> params = new HashMap<>();
                params.put("movieid", movie.getId() + "");
                params.put("cinemaid", cinema.getId() + "");
                Document doc = Jsoup.connect(url).
                        header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").
                        data(params).get();
                JSONObject dateShows = new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("DateShow");
                if (dateShows.toString().equals("{}")) {
                    continue;
                }
                String movieName = new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("currentMovie").getString("nm");
                String cinemaName = new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("cinemaDetailModel").getString("nm");
                JSONArray array1;
                JSONArray array2;
                JSONArray array3;
                try {
                    array1 = dateShows.getJSONArray(DateUtil.getToday());
                    array2 = dateShows.getJSONArray(DateUtil.get2Day());
                    array3 = dateShows.getJSONArray(DateUtil.get3Day());
                } catch (JSONException e) {
                    array1 = new JSONArray();
                    array2 = new JSONArray();
                    array3 = new JSONArray();
                }
                for (int i = 0; i < array1.length(); i++) {
                    JSONObject show = array1.getJSONObject(i);
                    String url2 = "http://m.maoyan.com/show/seats";
                    HashMap<String, String> params2 = new HashMap<>();
                    params2.put("showId", show.get("showId") + "");
                    params2.put("showDate", show.getString("dt"));
                    Document priceInfo = Jsoup.connect(url2)
                            .header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
                            .data(params2).get();
                    double price;
                    try {
                        price = new JSONObject(priceInfo.body().text()).getJSONObject("showInfo").getDouble("price");
                    }catch (JSONException e){
                        price = -1;
                    }
                    MaoyanPlan plan = new MaoyanPlan(cinema.getId() + "" + movie.getId(),
                            cinemaName, movieName, show.getString("dt"), show.getString("tm"),
                            show.getString("end"), show.getString("th"), price);
                    System.out.println(plan);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < array2.length(); i++) {
                    JSONObject show = array2.getJSONObject(i);
                    String url2 = "http://m.maoyan.com/show/seats";
                    HashMap<String, String> params2 = new HashMap<>();
                    params2.put("showId", show.get("showId") + "");
                    params2.put("showDate", show.getString("dt"));
                    Document priceInfo = Jsoup.connect(url2)
                            .header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
                            .data(params2).get();
                    double price;
                    try {
                        price = new JSONObject(priceInfo.body().text()).getJSONObject("showInfo").getDouble("price");
                    }catch (JSONException e){
                        price = -1;
                    }
                    MaoyanPlan plan = new MaoyanPlan(cinema.getId() + "" + movie.getId(),
                            cinemaName, movieName, show.getString("dt"), show.getString("tm"),
                            show.getString("end"), show.getString("th"), price);
                    System.out.println(plan);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < array3.length(); i++) {
                    JSONObject show = array3.getJSONObject(i);
                    String url2 = "http://m.maoyan.com/show/seats";
                    HashMap<String, String> params2 = new HashMap<>();
                    params2.put("showId", show.get("showId") + "");
                    params2.put("showDate", show.getString("dt"));
                    Document priceInfo = Jsoup.connect(url2)
                            .header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
                            .data(params2).get();
                    double price;
                    try {
                        price = new JSONObject(priceInfo.body().text()).getJSONObject("showInfo").getDouble("price");
                    }catch (JSONException e){
                        price = -1;
                    }
                    MaoyanPlan plan = new MaoyanPlan(cinema.getId() + "" + movie.getId(),
                            cinemaName, movieName, show.getString("dt"), show.getString("tm"),
                            show.getString("end"), show.getString("th"), price);
                    System.out.println(plan);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }

}
