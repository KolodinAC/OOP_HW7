import controller.Calculator;
import controller.NumCreator;
import model.ComplexNumber;
import view.Gui;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        NumCreator prod = new NumCreator();
        Gui console = new Gui();
        console.run();
    }
}
