package Models;

public class Product {

    private String name;
    private String shortDesc;
    private String longDesc;

    public Product(String name, String shortDesc, String longDesc) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }
}
