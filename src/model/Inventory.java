package model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public boolean isProductAvailable(String name) {
        return products.containsKey(name) && !products.get(name).isOutOfStock();
    }

    public void reduceStock(String name) {
        if (isProductAvailable(name)) {
            products.get(name).reduceStock();
        }
    }
}
