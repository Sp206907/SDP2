package Products;

import Bridge.OS;
import Strategy.PerformanceStrategy;
import Visitor.ComputerVisitor;

public class GamingComputer implements Computer {
    private final OS os;
    private PerformanceStrategy performanceStrategy;

    public GamingComputer(OS os, PerformanceStrategy performanceStrategy) {
        this.os = os;
        this.performanceStrategy = performanceStrategy;

    }

    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public void display() {
        System.out.println("High-performance Gaming Computer");
        if (os != null) {
            os.installOS();
        }
        performanceStrategy.performTask();
    }
}
