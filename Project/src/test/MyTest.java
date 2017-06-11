import dao.BaseDao;
import dao.CinemaDao;
import entity.UniformPlan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.SearchMovieService;
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

    @Autowired
    private SearchMovieService searchMovieService;


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
    public void initialGewalaPlan(){
        try {
            spider2.getPlansBySpider();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void initialTaobaoPlan(){
        try {
            taobaospider.getPlansBySpider();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test8(){
       List<UniformPlan> list= searchMovieService.getPlansByMovie("新木乃伊");
        for(UniformPlan uniform:list){
            System.out.println(uniform.toString());
        }
    }

}
