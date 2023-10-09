package src;

import java.util.List;

public class VendingMachine {
    private List<Product> productList;

    public Product getProduct(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void initProductList(List<Product> productList) {
        this.productList = productList;
    }
}
