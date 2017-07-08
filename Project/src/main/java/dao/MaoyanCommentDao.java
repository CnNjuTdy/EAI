package dao;

import entity.DoubanComment;
import entity.MaoyanComment;

import java.util.List;

/**
 * Created by lois on 2017/7/8.
 */
public class MaoyanCommentDao extends BaseDao {

    public List<MaoyanComment> findAll(){
        return findBySQL("select * from maoyan_comment",null,MaoyanComment.class);
    }

    public List<MaoyanComment> findById(String movieId) {
        String[] parms=new String[1];
        parms[0]=movieId;
        return findBySQL("select * from maoyan_comment where movie_id=?",parms,MaoyanComment.class);
    }
}
