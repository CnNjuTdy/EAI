package spider;

import entity.Comment;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MovieMarkServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fulinhua on 2017/7/8.
 */
@Service
public class Maoyan {
    @Autowired
    MovieMarkServiceImpl service;

    /**
     * 根据猫眼ID获得影评
     *
     * @param movieId
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public List getComments(String movieId,String id) throws IOException, InterruptedException {
        String url = "http://m.maoyan.com/comments.json";
        List<Comment> commentList = new ArrayList<>();
        for (int i = 0; i < 65; i++) {
            HashMap<String, String> params = new HashMap<>();
            params.put("movieid", movieId);
            params.put("offset", i * 15 + "");
            params.put("limit", "15");
            Document doc = Jsoup.connect(url).
                    header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").
                    data(params).get();
            JSONArray dataShows = new JSONObject(doc.body().text()).getJSONObject("data").getJSONObject("CommentResponseModel").getJSONArray("cmts");
            for (Object obj : dataShows) {
                Comment comment = new Comment();
                JSONObject jsonObject = (JSONObject) obj;
                comment.setMovieId(id);
                comment.setScore(Double.parseDouble(jsonObject.get("score").toString()));
                comment.setComment(jsonObject.get("content").toString());
                comment.setPreScore(service.getMark(comment.getComment()));
                commentList.add(comment);
            }
            System.out.println("第" + i + "次");
        }
        return commentList;
    }
}
