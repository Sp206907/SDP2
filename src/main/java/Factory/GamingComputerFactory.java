package Factory;

import Products.Computer;
import Products.GamingComputer;
import Bridge.OS;
import Bridge.WindowsOS;
import Bridge.LinuxOS;

/**
 * Creates GamingComputer. Default OS = Windows.
 * Also provides overloaded helper to create with a specific OS.
 */
public class GamingComputerFactory implements ComputerFactory {

    @Override
    public Computer createComputer() {
        // default: Windows for gaming
        return new GamingComputer(new WindowsOS());
    }

    // helper if you want to specify OS explicitly
    public Computer createComputer(OS os) {
        return new GamingComputer(os);
    }
}
