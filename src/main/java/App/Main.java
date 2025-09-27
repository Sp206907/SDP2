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
        // Gaming computer with light theme
        Main gamingLightApp = new Main(new GamingComputerFactory(), new LightThemeFactory());
        gamingLightApp.sellComputer();
        gamingLightApp.renderUI();

        System.out.println("-------------------");

        // Classic computer with dark theme
        Main classicDarkApp = new Main(new ClassicComputerFactory(), new DarkThemeFactory());
        classicDarkApp.sellComputer();
        classicDarkApp.renderUI();

        System.out.println("-------------------");

        // Imperial system computer adapted to our Computer interface
        ImperialComputer imperial = new ImperialComputer();
        Computer adapted = new ImperialToMetricAdapter(imperial);
        adapted.display();
    }
}

