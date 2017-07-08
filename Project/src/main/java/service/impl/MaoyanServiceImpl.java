package service.impl;

import dao.MaoyanCommentDao;
import entity.MaoyanComment;
import service.MaoyanService;
import spider.Maoyan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lois on 2017/7/8.
 */
public class MaoyanServiceImpl implements MaoyanService{

    Maoyan maoyan;
    MaoyanCommentDao maoyanCommentDao;

    public MaoyanServiceImpl() {
        this.maoyanCommentDao = new MaoyanCommentDao();
    }

    @Override
    public List getComments(String movieId) {

        List<MaoyanComment> commentList=new ArrayList<>();
        commentList = maoyanCommentDao.findById(movieId);

        return commentList;
    }

    @Override
    public void saveComments(String movieId) {
        maoyan = new Maoyan();
        List<MaoyanComment> list;
        try {
            list = maoyan.getComments(movieId);
            maoyanCommentDao.save(list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
