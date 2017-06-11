package entity;

/**
 * Created by fulinhua on 2017/6/11.
 */
public class UniformPlan {


    private String cName;//电影院名称
    private String mName;//电影名称
    private String date;//日期





    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getGewala_th() {
        return gewala_th;
    }

    public void setGewala_th(String gewala_th) {
        this.gewala_th = gewala_th;
    }

    public String getTaobao_th() {
        return taobao_th;
    }

    public void setTaobao_th(String taobao_th) {
        this.taobao_th = taobao_th;
    }

    public double getGewala_price() {
        return gewala_price;
    }

    public void setGewala_price(double gewala_price) {
        this.gewala_price = gewala_price;
    }

    public double getTaobao_price() {
        return taobao_price;
    }

    public void setTaobao_price(double taobao_price) {
        this.taobao_price = taobao_price;
    }

    private String start;//需要解析
    private String end;
    private String gewala_th;//格瓦拉场次
    private String taobao_th;//淘票票场次
    private double gewala_price;//格瓦拉价格
    private double taobao_price;//淘票票价格



   public String toString(){
       return "场次信息{" +
               "电影名称='" + mName + '\'' +
               ", 影院名称='" + cName + '\'' +
               ", 放映日期='" + date + '\'' +
               ", 开始时间='" + start + '\'' +
               ", 结束时间='" + end + '\'' +
               ", 格瓦拉场次='" + gewala_th + '\'' +
               ", 格瓦拉价格=" + gewala_price +
               ", 淘宝场次='" + taobao_th + '\'' +
               ", 淘宝价格=" + taobao_price +
               '}';

   }


}
