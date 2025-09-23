package Factory;

import Products.Computer;
import Products.GamingComputer;

public class GamingComputerFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new GamingComputer();
    }
}
