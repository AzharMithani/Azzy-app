package azzy.example.com;

/**
 * Created by Siddhant on 31-05-2018.
 */

public class FeedItem {
    private int id;
    private String name;
    private String image;
    private String cat_id;
    private String main_cat_id;
    private String cat_type;

    public FeedItem() {
    }

    public FeedItem(int id, String name, String image,
                    String main_cat_id, String cat_type) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
        this.main_cat_id = main_cat_id;
        this.cat_type = cat_type;
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

    public String getImge() {
        return image;
    }

    public void setImge(String image) {
        this.image = image;
    }

    public String getMain_cat_id() {
        return main_cat_id;
    }

    public void setMain_cat_id(String main_cat_id) {
        this.main_cat_id = main_cat_id;
    }

    public String getCat_type() {
        return cat_type;
    }

    public void setCat_type(String cat_type) {
        this.cat_type = cat_type;
    }
}
