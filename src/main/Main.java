package main;

import chain.*;
import command.*;
import model.VendingMachine;
import observer.StockManager;
import observer.Supplier;
import strategy.DemandBasedPricingStrategy;
import strategy.PricingContext;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        
        // Observer setup
        StockManager stockManager = new StockManager();
        Supplier supplier = new Supplier("Supplier Inc.");
        stockManager.addObserver(supplier);

        // Strategy setup
        PricingContext pricingContext = new PricingContext();
        pricingContext.setStrategy(new DemandBasedPricingStrategy());

        // Command setup
        CommandInvoker invoker = new CommandInvoker();
        invoker.executeCommand(new DispenseItemCommand(vendingMachine, "Soda"));

        // Chain of Responsibility setup
        Handler stockHandler = new StockCheckHandler(vendingMachine);
        stockHandler.processRequest("Soda");
    }
}
