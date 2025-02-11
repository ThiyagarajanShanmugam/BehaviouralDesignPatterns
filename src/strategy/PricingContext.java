package strategy;

public class PricingContext {
    private PricingStrategy strategy;

    // Ensure strategy is always initialized
    public PricingContext() {
        this.strategy = new DemandBasedPricingStrategy();  // Default strategy
    }

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price) {
        if (strategy == null) { 
            throw new IllegalStateException("Pricing strategy not set before calling getPrice()");
        }
        return strategy.getPrice(price);
    }
}
