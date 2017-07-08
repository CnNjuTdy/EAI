package spider;

import entity.MaoyanComment;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fulinhua on 2017/7/8.
 */
public class Maoyan {


    public static void main(String[] args) throws IOException, InterruptedException {
        Maoyan maoyan=new Maoyan();
        List<MaoyanComment> list= maoyan.getComments("246012");
        System.out.println(list.size());
        for(MaoyanComment comment:list){
            System.out.println(comment);
        }
      //  System.out.println(maoyan.getType("246012"));
    }


    public String[] getMovieNameAndTag(String movieId) throws IOException {
       String url="http://m.maoyan.com/movie/"+movieId+".json";
        Document doc = Jsoup.connect(url).
                header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").
                data().get();
        String tag = new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("MovieDetailModel").get("cat").toString();
        String movieName=new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("MovieDetailModel").get("nm").toString();
        String[] result=new String[2];
        result[0]=movieName;
        result[1]=tag;
        return result;
    }

    /**
     * 根据猫眼ID获得影评
     * @param movieId
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public List getComments(String movieId) throws IOException, InterruptedException {
                String url = "http://m.maoyan.com/comments.json";
        List<MaoyanComment> commentList=new ArrayList<>();
        String[] tag=getMovieNameAndTag(movieId);
       // System.out.println(tag[0]+" "+tag[1]);
        for(int i=0;i<65;i++){
            HashMap<String, String> params = new HashMap<>();
            params.put("movieid",movieId);
            params.put("offset",i*15+"");
            params.put("limit","15");
            Document doc = Jsoup.connect(url).
                    header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").
                    data(params).get();
            JSONArray dataShows = new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("CommentResponseModel").getJSONArray("cmts");
            for(Object obj:dataShows){
                MaoyanComment comment =new MaoyanComment();
//                comment.setMovieName(tag[0]);
//                comment.setTag(tag[1]);
               JSONObject jsonObject=(JSONObject) obj;
                comment.setScore(Double.parseDouble(jsonObject.get("score").toString()));
                comment.setComment(jsonObject.get("content").toString());
                commentList.add(comment);
            }
          //  System.out.println(dataShows.toString());
        System.out.println("第"+i+"次");
        }
return commentList;
    }
}
