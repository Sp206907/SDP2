package Products;

import Bridge.OS;

public class ClassicComputer implements Computer {
    private final OS os;

    public ClassicComputer(OS os) {
        this.os = os;
    }

    @Override
    public void display() {
        System.out.println("Affordable Classic Computer");
        if (os != null) {
            os.installOS();
        }
    }
}
