package Models;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<ProductModel> productList;

    public Inventory(){
        productList = new ArrayList<ProductModel>();
        productList.add(new ProductModel("Brass Knob", "A knob made of premium brass", "brandon i hate you"));
        productList.add(new ProductModel("Glass Knob", "A luxurious glass knob", "brandon i hate you"));
        productList.add(new ProductModel("Stainless Steel Knob", "A sleek modern knob", "brandon i hate you"));
    }

    public List<ProductModel> getProductList() {
        return productList;
    }
}
