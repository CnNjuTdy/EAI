import dao.BaseDao;
import dao.CinemaDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spider.GewaraSpider;
import spider.MaoyanSpider;
import spider.TaopiaopiaoSpider;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tondiyee on 2017/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-core.xml", "classpath*:spring/spring-hibernate.xml"})
public class MyTest {
    @Qualifier("baseDao")
    @Autowired
    private BaseDao dao;
    @Autowired
    private MaoyanSpider spider;
    @Autowired
    private GewaraSpider spider2;

    @Autowired
    private TaopiaopiaoSpider taobaospider;

    @Autowired
    private CinemaDao dao2;


//    @Test
//    public void test1() {
//        dao.save(new Cinema(3, "是的", "3", "4", 5));
//    }

    @Test
    public void test2() {
        try {
            spider.getPlans();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMaoyan() {
        try {
            spider.getPlans();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//    @Test
//    public void test3() {
//        try {
//            spider.getAllMovies();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void test4() {
        List list = dao2.findAll();
        System.out.println("hello world");
    }

    @Test
    public void test5() {
        try {
            spider.getPlans();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6(){
        try {
            spider2.getPlans();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test7(){
        try {
            taobaospider.getPlans();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
