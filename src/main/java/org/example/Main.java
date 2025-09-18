package org.example;

// Product interface
interface Computer {
    void display();
}
// Concrete products
class GamingComputer implements Computer {
    @Override
    public void display() {
        System.out.println("Gaming Computer");
    }
}
class ClassicComputer implements Computer {
    @Override
    public void display() {
        System.out.println("Classic Computer");
    }
}
// Factory interface
interface ComputerFactory {
    Computer createComputer();
}
// Concrete factories
class GamingComputerFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new GamingComputer();
    }
}
class ClassicComputerFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new ClassicComputer();
    }
}
// Client
public class Main {
    public static void main(String[] args) {
        ComputerFactory gamingFactory = new GamingComputerFactory();
        Computer gaming = gamingFactory.createComputer();
        gaming.display();

        ComputerFactory classicFactory = new ClassicComputerFactory();
        Computer classic = classicFactory.createComputer();
        classic.display();
    }
}
