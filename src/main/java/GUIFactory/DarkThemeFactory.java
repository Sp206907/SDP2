package GUIFactory;

public class DarkThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Label createLabel() {
        return new DarkLabel();
    }
}
