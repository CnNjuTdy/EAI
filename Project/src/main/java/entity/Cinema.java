package entity;

/**
 * Created by Tondiyee on 2017/6/10.
 */
public class Cinema {
    private int id;
    private int maoyanId;
    private int taobaoId;
    private int gewalaId;
    private String name;
    private String area;
    private String address;
    private double price;

    public Cinema() {
    }

    public Cinema(int id, int maoyanId, int taobaoId, int gewalaId, String name, String area, String address, double price) {
        this.id = id;
        this.maoyanId = maoyanId;
        this.taobaoId = taobaoId;
        this.gewalaId = gewalaId;
        this.name = name;
        this.area = area;
        this.address = address;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaoyanId() {
        return maoyanId;
    }

    public void setMaoyanId(int maoyanId) {
        this.maoyanId = maoyanId;
    }

    public int getTaobaoId() {
        return taobaoId;
    }

    public void setTaobaoId(int taobaoId) {
        this.taobaoId = taobaoId;
    }

    public int getGewalaId() {
        return gewalaId;
    }

    public void setGewalaId(int gewalaId) {
        this.gewalaId = gewalaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", maoyanId=" + maoyanId +
                ", taobaoId=" + taobaoId +
                ", gewalaId=" + gewalaId +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }
}
