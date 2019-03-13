package Models;

public class Product {

    private String name;
    private String shortDesc;
    private String longDesc;
    private double price;

    public Product(String name, String shortDesc, String longDesc, double price) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
