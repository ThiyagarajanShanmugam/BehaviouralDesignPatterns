package visitor;

import model.Product;

public interface VendingMachineVisitor {
    void visit(Product product);
}
