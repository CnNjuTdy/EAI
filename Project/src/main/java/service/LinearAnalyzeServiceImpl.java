package service;

import entity.Point;
import entity.Ratio;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tondiyee on 2017/7/8.
 */
@Service
public class LinearAnalyzeServiceImpl{
    public Ratio getRatio(List<Point> points) {
        DecimalFormat df   =new   java.text.DecimalFormat("#.00");
        double avx = 0;
        double avy = 0;
        double b = 0;
        double a = 0;
        double temp = 0;
        for (Point point : points) {
            double x = point.getX();
            double y = point.getY();
            avx += x;
            avy += y;
        }
        avx = avx / points.size();
        avy = avy / points.size();
        for (Point point : points) {
            double x = point.getX();
            double y = point.getY();
            b += x * y;
            temp += x*x;
        }
        b = b-points.size()*avx*avy;
        b = b/(temp-points.size()*avx*avx);
        a = avy-b*avx;
        return new Ratio(Double.parseDouble(df.format(b)),Double.parseDouble(df.format(a)));
    }

    public static void main(String[] args){
        LinearAnalyzeServiceImpl impl = new LinearAnalyzeServiceImpl();
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(0,1));
        points.add(new Point(1,2));
        Ratio ratio = impl.getRatio(points);
    }
}
