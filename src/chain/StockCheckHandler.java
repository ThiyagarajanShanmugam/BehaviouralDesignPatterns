package chain;

import model.VendingMachine;

public class StockCheckHandler extends Handler {
    private VendingMachine vendingMachine;

    public StockCheckHandler(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void processRequest(String item) {
        if (vendingMachine.isInStock(item)) {
            if (nextHandler != null) nextHandler.processRequest(item);
        } else {
            System.out.println("Out of stock: " + item);
        }
    }
}
