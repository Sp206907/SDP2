package Factory;

import Products.Computer;
import Products.ClassicComputer;
import Bridge.OS;
import Bridge.LinuxOS;
import Strategy.OfficePerformance;
import Strategy.PerformanceStrategy;


/**
 * Creates ClassicComputer. Default OS = Linux.
 * Also provides overloaded helper to create with a specific OS.
 */
public class ClassicComputerFactory implements ComputerFactory {

    @Override
    public Computer createComputer() {
        // default: Linux for classic
        return new ClassicComputer(new LinuxOS(),new OfficePerformance());
    }

    // helper if you want to specify OS explicitly
    public Computer createComputer(OS os, PerformanceStrategy performanceStrategy) {
        return new ClassicComputer(os, performanceStrategy);
    }
}
