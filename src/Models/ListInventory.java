package Models;

import java.util.ArrayList;

public class ListInventory implements Inventory {

    private ArrayList<Product> productList = new ArrayList<>();

    public ListInventory(){
        productList.add(new Product("Brass Knob", "A knob made of premium brass", "A classic style knob made of the finest swiss brass", 5.99));
        productList.add(new Product("Glass Knob", "A luxurious glass knob", "A knob crafted by the finest glassblower in all of Mozambique", 8.99));
        productList.add(new Product("Stainless Steel Knob", "A sleek modern knob", "A fresh new style of knob made of 100% recycled railroad steel", 7.99));
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
