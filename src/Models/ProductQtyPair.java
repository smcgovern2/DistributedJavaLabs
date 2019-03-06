package Models;

public class ProductQtyPair{
    private Product product;
    private Integer quantity;

    public ProductQtyPair(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductQtyPair(){}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
