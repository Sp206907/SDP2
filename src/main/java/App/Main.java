package App;

import Factory.ComputerFactory;
import Factory.GamingComputerFactory;
import Factory.ClassicComputerFactory;
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
        // Gaming computer + Light UI (uses factory default OS = Windows)
        Main gamingLightApp = new Main(new GamingComputerFactory(), new LightThemeFactory());
        gamingLightApp.sellComputer();
        gamingLightApp.renderUI();

        System.out.println("-------------------");

        // Classic computer + Dark UI (factory default OS = Linux)
        Main classicDarkApp = new Main(new ClassicComputerFactory(), new DarkThemeFactory());
        classicDarkApp.sellComputer();
        classicDarkApp.renderUI();

        System.out.println("-------------------");

        // Adapter example: adapt an ImperialComputer to the Computer interface
        ImperialComputer imperial = new ImperialComputer();
        Computer adapted = new ImperialToMetricAdapter(imperial);
        adapted.display();

        System.out.println("-------------------");

        // Example: directly creating a GamingComputer with explicit OS (Bridge)
        GamingComputer gamingPC = new GamingComputer(new WindowsOS(),new GamingPerformance());
        gamingPC.display();

        System.out.println("-------------------");

        ClassicComputer classicPC = new ClassicComputer(new LinuxOS(), new OfficePerformance());
        classicPC.display();
        ComputerSetupFacade facade = new ComputerSetupFacade();

        System.out.println("=== Simple Facade Demo ===");
        facade.setupGamingComputerWithWindows();

        System.out.println("-------------------");
        facade.setupClassicComputerWithLinux();

        System.out.println("-------------------");
        facade.setupGamingComputerWithWindows();

        System.out.println("-------------------");
        facade.setupClassicComputerWithWindows();

        System.out.println("=== Strategy Pattern Demo ===");
        facade.setupGamingComputerWithWindows();

        System.out.println("-------------------");
        facade.setupClassicComputerWithLinux();

        System.out.println("-------------------");
        facade.setupProgrammingComputerWithLinux();
    }
}
