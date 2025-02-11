package command;

import model.VendingMachine;

public class DispenseItemCommand implements Command {
    private VendingMachine vendingMachine;
    private String item;

    public DispenseItemCommand(VendingMachine vendingMachine, String item) {
        this.vendingMachine = vendingMachine;
        this.item = item;
    }

    @Override
    public void execute() {
        vendingMachine.dispenseItem(item);
    }
}
