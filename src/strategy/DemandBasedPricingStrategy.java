package strategy;

public class DemandBasedPricingStrategy implements PricingStrategy {
    @Override
    public double getPrice(double basePrice) {
        return basePrice * 1.2; // 20% increase during high demand
    }
}
