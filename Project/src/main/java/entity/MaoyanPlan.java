package entity;

/**
 * Created by Tondiyee on 2017/6/10.
 */
public class MaoyanPlan {
    private String id;
    private String cName;
    private String mName;
    private String date;
    private String start;
    private String end;
    private String th;
    private double price;

    public MaoyanPlan(String id,String cName, String mName, String date, String start, String end, String th, double price) {
        this.id = id;
        this.cName = cName;
        this.mName = mName;
        this.date = date;
        this.start = start;
        this.end = end;
        this.th = th;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
