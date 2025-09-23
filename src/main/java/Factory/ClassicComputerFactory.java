package Factory;

import Products.ClassicComputer;
import Products.Computer;

public class ClassicComputerFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new ClassicComputer();
    }
}
