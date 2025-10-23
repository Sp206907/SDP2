package Products;

import Bridge.OS;
import Strategy.PerformanceStrategy;

public class ClassicComputer implements Computer {
    private final OS os;
    private PerformanceStrategy performanceStrategy;



    public ClassicComputer(OS os, PerformanceStrategy performanceStrategy) {
        this.os = os;
        this.performanceStrategy = performanceStrategy;

    }

    @Override
    public void display() {
        System.out.println("Affordable Classic Computer");
        if (os != null) {
            os.installOS();
        }
        performanceStrategy.performTask();

    }
}
