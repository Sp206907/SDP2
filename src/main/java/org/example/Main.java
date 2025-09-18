package org.example;

interface Computer{
    void display();
}
abstract class GamingComputer implements Computer{
    @Override
    public void display() {
        System.out.println("Gaming");
    }
}
abstract class ClassicComputer implements Computer{
    @Override
    public void display() {
        System.out.println("Classic");
    }
}
interface ComputerFactory {
    Computer createComputer();
}
abstract class GamingComputerFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new GamingComputer() {};

    }
}
abstract class ClassicComputerFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new ClassicComputer() {};
    }
}
public class Main {
    public static void main(String[] args) {
        ComputerFactory GamingComputerFactory = new GamingComputerFactory() {};
        Computer GamingComputer = GamingComputerFactory.createComputer();
        GamingComputer.display();
        ComputerFactory ClassicComputerFactory = new ClassicComputerFactory() {};
        Computer ClassicComputer = ClassicComputerFactory.createComputer();
        ClassicComputer.display();
    }
}
