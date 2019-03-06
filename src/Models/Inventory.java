package Models;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> productList = new ArrayList<>();

    public Inventory(){
        productList.add(new Product("Brass Knob", "A knob made of premium brass", "brandon i hate you", 5.99));
        productList.add(new Product("Glass Knob", "A luxurious glass knob", "brandon i hate you", 8.99));
        productList.add(new Product("Stainless Steel Knob", "A sleek modern knob", "brandon i hate you", 7.99));
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
