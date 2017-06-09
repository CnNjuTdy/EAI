package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Tondiyee on 2017/6/10.
 */
public class DateUtil {
    private static DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");

    public static String getToday(){
        return df1.format(new Date());
    }

    public static String get2Day(){
        return df1.format(nextNDay(new Date(),1));
    }

    public static String get3Day(){
        return df1.format(nextNDay(new Date(),2));
    }

    private static Date nextNDay(Date date,int n){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE,n);
        return c.getTime();
    }
}
