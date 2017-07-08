package service.impl;

import dao.DoubanCommentDao;
import entity.DoubanComment;
import entity.MaoyanComment;
import service.DoubanService;
import spider.Douban;
import spider.Maoyan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lois on 2017/7/8.
 */
public class DoubanServiceImpl implements DoubanService {

    Douban douban;
    DoubanCommentDao doubanCommentDao;

    public DoubanServiceImpl() {
        this.doubanCommentDao = new DoubanCommentDao();
    }

    @Override
    public List getComments(String movieId) {

        List<DoubanComment> list = new ArrayList<>();
        list = doubanCommentDao.findById(movieId);

        return list;
    }

    @Override
    public void saveComments(String movieId) {
        douban = new Douban();
        List<DoubanComment> list;
        try {
            list = douban.getComments(movieId);
            doubanCommentDao.save(list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
