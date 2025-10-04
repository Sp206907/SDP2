package Factory;

import Products.Computer;

public interface ComputerFactory {
    /**
     * Create a computer with a sensible default OS (factory decides default).
     */
    Computer createComputer();
}
