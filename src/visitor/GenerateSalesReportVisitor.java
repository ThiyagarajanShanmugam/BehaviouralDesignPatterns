package visitor;

import model.Product;

public class GenerateSalesReportVisitor implements VendingMachineVisitor {
    @Override
    public void visit(Product product) {
        System.out.println("Generating sales report for: " + product.getName());
    }
}
