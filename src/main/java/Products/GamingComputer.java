package Products;

import Bridge.OS;

public class GamingComputer implements Computer {
    private final OS os;

    public GamingComputer(OS os) {
        this.os = os;
    }

    @Override
    public void display() {
        System.out.println("High-performance Gaming Computer");
        if (os != null) {
            os.installOS();
        }
    }
}
