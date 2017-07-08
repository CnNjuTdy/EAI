package spider;

import entity.DoubanComment;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fulinhua on 2017/7/8.
 */
public class Douban {

    public static void main(String[] args) throws IOException, InterruptedException {
        Douban doubanSpider=new Douban();
      List<DoubanComment> doubanComments=  doubanSpider.getComments("6311303");
        for(DoubanComment comment:doubanComments){
            System.out.println(comment);
        }
    }
    public String[] getMovieNameAndTag(String movieId) throws IOException {
        HashMap<String, String> params = new HashMap<>();
        String url="https://api.douban.com/v2/movie/subject/"+movieId;
        params.put("apikey", "0b2bdeda43b5688921839c8ecb20399b");
        params.put("udid", "dddddddddddddddddddddd");
        params.put("client", "something");
        Connection connection = getConnection(url);
        Document doc = connection.data(params).ignoreContentType(true).get();
        JSONArray tag = new JSONObject(doc.body().text()).getJSONArray("genres");
        String tagname="";
       for(int i=0;i<tag.length()-1;i++){
           tagname+=tag.get(i)+",";
       }
        tagname+=tag.get(tag.length()-1);
        String movieName=new JSONObject(doc.body().text()).get("title").toString();
        String[] result=new String[2];
        result[0]=movieName;
        result[1]=tagname;
        return result;
    }

    public Connection getConnection(String url){
        Connection connection = Jsoup.connect(url);
        connection.header("Host", "api.douban.com");
        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
        connection.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        connection.header("Accept-Language", "zh-CN,zh;q=0.8");
        connection.header("Accept-Encoding", "gzip, deflate, sdch, br");
        connection.header("Connection", "keep-alive");
        connection.header("Cache-Control", "max-age=0");
        return connection;
    }

    public List<DoubanComment> getComments(String movieId) throws IOException, InterruptedException {
        String url = "https://api.douban.com/v2/movie/subject/"+movieId+"/comments";
        List<DoubanComment> commentList=new ArrayList<>();
        String[] movieInfo=getMovieNameAndTag(movieId);
        for(int i=0;i<=10;i++) {
            HashMap<String, String> params = new HashMap<>();
            params.put("apikey", "0b2bdeda43b5688921839c8ecb20399b");
            params.put("start", i*50 + "");
            params.put("count", "50");
            params.put("udid", "dddddddddddddddddddddd");
            params.put("client", "something");
            Connection connection = getConnection(url);
            Document doc = connection.data(params).ignoreContentType(true).get();
            JSONArray array = new JSONObject(doc.body().text()).getJSONArray("comments");
            for(Object obj:array){
                DoubanComment comment =new DoubanComment();
                comment.setMovieName(movieInfo[0]);
                comment.setTag(movieInfo[1]);
                JSONObject jsonObject=(JSONObject) obj;
               comment.setScore(Double.parseDouble(jsonObject.getJSONObject("rating").get("value").toString()));
                comment.setComment(jsonObject.get("content").toString());
                commentList.add(comment);
            }
          //  System.out.println(array.toString());
            System.out.println(array.length());
            System.out.println(i);
        }
        return commentList;
    }


}
