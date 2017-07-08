package dao;

import entity.DoubanComment;

import java.util.List;

/**
 * Created by lois on 2017/7/8.
 */
public class DoubanCommentDao extends BaseDao{

    public List<DoubanComment> findAll(){
        return findBySQL("select * from douban_comment",null,DoubanComment.class);
    }

    public List<DoubanComment> findById(String movieId) {
        String[] parms=new String[1];
        parms[0]=movieId;
        return findBySQL("select * from douban_comment where movie_id=?",parms,DoubanComment.class);
    }


}
