package Products;
import Visitor.ComputerVisitor;
//Target
public interface Computer {
    void display();
    void accept(ComputerVisitor visitor);
}

