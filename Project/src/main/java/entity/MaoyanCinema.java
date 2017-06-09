package entity;

/**
 * Created by Tondiyee on 2017/6/10.
 */
public class MaoyanCinema {
    private int id;
    private String name;
    private String area;
    private String address;
    private int price;

    public MaoyanCinema(int id, String name, String area, String address, int price) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.address = address;
        this.price = price;
    }

    public MaoyanCinema() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MaoyanCinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }
}
