package Adapter;

import Products.Computer;
import Visitor.ComputerVisitor;
//Adapter

public class ImperialToMetricAdapter implements Computer {
    private final ImperialComputer imperialComputer;

    public ImperialToMetricAdapter(ImperialComputer imperialComputer) {
        this.imperialComputer = imperialComputer;
    }

    @Override
    public void display() {
        // Adapts the Imperial system to our Computer interface
        System.out.print("Adapted -> ");
        imperialComputer.showSpecsInImperial();
    }

    @Override
    public void accept(ComputerVisitor visitor) {

    }
}

