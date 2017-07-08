import dao.BaseDao;
import dao.CommentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.MovieMarkServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tondiyee on 2017/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-core.xml", "classpath*:spring/spring-hibernate.xml"})
public class MyTest {
    @Autowired
    CommentDao commentDao;
    @Autowired
    MovieMarkServiceImpl impl;

    @Test
    public void test1(){
        commentDao.saveAll();
    }
    @Test
    public void test2(){
        System.out.println(impl.getMark("这个片子很好"));
    }
}
