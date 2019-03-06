package Models;

import java.util.ArrayList;

public class Cart {

    private ArrayList<ProductQtyPair> productQtyList = new ArrayList<>();

    public Cart() {

    }

    public ArrayList<ProductQtyPair> getProductQtyList() {
        return productQtyList;
    }

    public void setProductQtyList(ArrayList<ProductQtyPair> productQtyList) {
        this.productQtyList = productQtyList;
    }
}

