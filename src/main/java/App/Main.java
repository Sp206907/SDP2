package App;

import Factory.ComputerFactory;
import Factory.GamingComputerFactory;
import Factory.ClassicComputerFactory;
import Observer.ConcreteObservers.LoggerObserver;
import Observer.ConcreteObservers.SystemMonitorObserver;
import Observer.ConcreteObservers.UserObserver;
import Products.Computer;

import GUIFactory.GUIFactory;
import GUIFactory.LightThemeFactory;
import GUIFactory.DarkThemeFactory;
import GUIFactory.Button;
import GUIFactory.Label;

import Adapter.ImperialComputer;
import Adapter.ImperialToMetricAdapter;

import Products.GamingComputer;
import Products.ClassicComputer;
import Bridge.WindowsOS;
import Bridge.LinuxOS;

import Facade.ComputerSetupFacade;
import Strategy.GamingPerformance;
import Strategy.OfficePerformance;
import Observer.*;
import Visitor.*;

public class Main {
    private final ComputerFactory computerFactory;
    private final GUIFactory guiFactory;

    public Main(ComputerFactory computerFactory, GUIFactory guiFactory) {
        this.computerFactory = computerFactory;
        this.guiFactory = guiFactory;
    }

    public void sellComputer() {
        Computer computer = computerFactory.createComputer();
        computer.display();
    }

    public void renderUI() {
        Button button = guiFactory.createButton();
        Label label = guiFactory.createLabel();
        button.render();
        label.render();
    }

    public static void main(String[] args) {
        ComputerSetupFacade facade = new ComputerSetupFacade();
        Computer gaming = new GamingComputer(new LinuxOS(), new GamingPerformance());
        Computer classic = new ClassicComputer(new WindowsOS(), new OfficePerformance());

        // Create observers
        UserObserver user1 = new UserObserver("Ernar");
        SystemMonitorObserver monitor = new SystemMonitorObserver();
        LoggerObserver logger = new LoggerObserver();

        // Register observers
        facade.addObserver(user1);
        facade.addObserver(monitor);
        facade.addObserver(logger);

        // Trigger events
        facade.setupGamingComputerWithWindows();
        System.out.println("------------------");
        facade.setupClassicComputerWithLinux();

        ComputerVisitor performance = new PerformanceVisitor();
        ComputerVisitor price = new PriceVisitor();

        System.out.println("--- Performance Tests ---");
        gaming.accept(performance);
        classic.accept(performance);

        System.out.println("\n--- Price Evaluation ---");
        gaming.accept(price);
        classic.accept(price);
    }
}
