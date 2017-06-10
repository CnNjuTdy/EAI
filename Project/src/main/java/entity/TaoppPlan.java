package entity;

/**
 * Created by fulinhua on 2017/6/10.
 */
public class TaoppPlan {
    private int id;
    private int cId;//电影院id
    private int mId;//电影id
    private String cName;//电影院名称
    private String mName;//电影名称
    private String date;//日期
    private String start;//需要解析
    private String end;
    private String th;
    private double price;

    public TaoppPlan() {
    }

    public TaoppPlan(int id, int cId, int mId, String cName, String mName, String date, String start, String end, String th, double price) {
        this.id = id;
        this.cId = cId;
        this.mId = mId;
        this.cName = cName;
        this.mName = mName;
        this.date = date;
        this.start = start;
        this.end = end;
        this.th = th;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

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

    public String getTh() {
        return th;
    }

    public void setTh(String th) {
        this.th = th;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MaoyanPlan{" +
                "id='" + id + '\'' +
                ", cId=" + cId +
                ", mId=" + mId +
                ", cName='" + cName + '\'' +
                ", mName='" + mName + '\'' +
                ", date='" + date + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", th='" + th + '\'' +
                ", price=" + price +
                '}';
    }

}
