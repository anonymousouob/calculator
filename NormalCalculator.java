package FinalProject;

import javax.swing.*;
import java.awt.*;

public class NormalCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorUI();
        });
    }
}