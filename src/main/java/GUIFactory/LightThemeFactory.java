package GUIFactory;

public class LightThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Label createLabel() {
        return new LightLabel();
    }
}
