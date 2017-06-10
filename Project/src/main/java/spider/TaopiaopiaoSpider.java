package spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by fulinhua on 2017/6/10.
 */
public class TaopiaopiaoSpider {

    public static void main(String[] args) throws IOException {
        //影院信息

        HashMap<String,String> parms=new HashMap<>();
        parms.put("showId","150686");
        parms.put("cinemaId","35999");
        parms.put("data","2017-06-10");
        parms.put("regionName","");
        parms.put("n_s","new");
        parms.put("ts","1497065379062");
        getData(parms);

    }

    public static void getData(HashMap<String,String> parms) throws IOException {

        String url="https://dianying.taobao.com/showDetailSchedule.htm";

        Document doc = Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").data(parms).get();

        System.out.println(doc.toString());
    }

}
