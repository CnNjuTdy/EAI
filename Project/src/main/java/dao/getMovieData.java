package dao;

import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fulinhua on 2017/5/24.
 */
public class getMovieData {


//    public static void main(String[] args) throws IOException {
//
//        Connection.Response res = Jsoup.connect("http://www.meituan.com/dianying/588362?#content")
//                .data()
//                .method(Connection.Method.POST)
//                .execute();
//        Document doc = res.parse();
//        Element menu = doc.getElementById("J-brand-filter");
//        Elements movies = menu.select("a");
//     int start=0;
//        for (Element movie : movies) {
//            if(start>=1) {
//                System.out.print(movie.text() + " 链接为 ");
//                String relHref = movie.attr("abs:href");
//                System.out.print(relHref + "   ");
//
//                Connection.Response movirpeice = Jsoup.connect(relHref)
//                        .data()
//                        .method(Connection.Method.POST)
//                        .execute();
//                Document singlemall = movirpeice.parse();
//                //btn-block__price__tag f4
//              //  System.out.println(singlemall.text());
//                Elements prices = singlemall.getElementsByClass("component-cinema-list");
//                System.out.println(prices.get(0).text());
//
//            }
//            start++;
//        }
//
//    }


    public static void main(String[] args) throws IOException {
        //影院信息
        HashMap<String, String> parms = new HashMap<>();
        parms.put("movieid", "38977");
        parms.put("cinemaid", "1166");
        String url = "http://m.maoyan.com/showtime/wrap.json";
        Document doc = Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").data(parms).get();

        System.out.println(new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("DateShow"));

//
//        //特定场次
//        HashMap<String,String> showparms=new HashMap<>();
//        showparms.put("showId","119204");
//        showparms.put("showDate","2017-06-10");
//        String singleurl="http://m.maoyan.com/show/seats";
//        Document info = Jsoup.connect(singleurl).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").data(showparms).get();
//        System.out.println(info.toString());


    }


}