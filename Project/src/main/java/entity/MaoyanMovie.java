package entity;

/**
 * Created by Tondiyee on 2017/6/10.
 */
public class MaoyanMovie {
    private int id;
    private String name;
    private String description;
    private String director;
    private String star;
    private int is3d;
    private int isIMax;
    private String imgUrl;

    public MaoyanMovie() {
    }

    public MaoyanMovie(int id, String name, String description, String director, String star, boolean is3d, boolean isIMax, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.director = director;
        this.star = star;
        this.is3d = is3d ? 1 : 0;
        this.isIMax = isIMax ? 1 : 0;
        this.imgUrl = imgUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public int getIs3d() {
        return is3d;
    }

    public void setIs3d(int is3d) {
        this.is3d = is3d;
    }

    public int getIsIMax() {
        return isIMax;
    }

    public void setIsIMax(int isIMax) {
        this.isIMax = isIMax;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "MaoyanMovie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", star='" + star + '\'' +
                ", is3d=" + is3d +
                ", isIMax=" + isIMax +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
