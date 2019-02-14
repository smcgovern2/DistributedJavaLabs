package FirstServlet;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public static final Inventory INVENTORY = new Inventory();
    private static List<Product> productList;

    private Inventory(){
        productList = new ArrayList<Product>();
        productList.add(new Product("Brass Knob", "A knob made of premium brass", "brandon i hate you"));
        productList.add(new Product("Glass Knob", "A luxurious glass knob", "brandon i hate you"));
        productList.add(new Product("Stainless Steel Knob", "A sleek modern knob", "brandon i hate you"));
    }

    public static List<Product> getProductList() {
        return productList;
    }
}
