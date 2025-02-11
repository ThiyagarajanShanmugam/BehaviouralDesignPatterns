package model;

import observer.StockManager;
import strategy.PricingContext;

public class VendingMachine {
    private Inventory inventory;
    private StockManager stockManager;
    private PricingContext pricingContext;

    public VendingMachine() {
        this.inventory = new Inventory();
        this.stockManager = new StockManager();
        this.pricingContext = new PricingContext();

        // Adding sample products
        inventory.addProduct(new Product("Soda", 1.50, 5));
        inventory.addProduct(new Product("Chips", 2.00, 3));
        inventory.addProduct(new Product("Candy", 1.00, 0)); // Out of stock
    }

    public void dispenseItem(String item) {
        if (inventory.isProductAvailable(item)) {
           // double price = pricingContext.getPrice(inventory.getProduct(item).getPrice());
           if (pricingContext == null) {
            pricingContext = new PricingContext();  // Ensure it's initialized
        }
        
              double price = pricingContext.getPrice(item.getPrice());
         
           System.out.println("Dispensing: " + item + " - Price: $" + price);
            inventory.reduceStock(item);

            // Notify suppliers if stock is critically low
            if (inventory.getProduct(item).getStock() == 0) {
                stockManager.lowStockAlert(item);
            }
        } else {
            System.out.println("Sorry, " + item + " is out of stock.");
        }
    }

    public boolean isInStock(String item) {
        return inventory.isProductAvailable(item);
    }
}
