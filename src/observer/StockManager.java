package observer;

public class StockManager extends Observable {
    public void lowStockAlert(String item) {
        notifyObservers("Stock low for: " + item);
    }
}
