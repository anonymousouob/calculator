package FinalProject;

import java.awt.*;
import javax.swing.*;

class CalculatorUI {
    private CalculatorLogic logic;
    private JTextField display;
    private JFrame frame;

    public CalculatorUI() {
        this.logic = new CalculatorLogic();
        setupUI();
    }

    private void setupUI() {
        frame = new JFrame("計算機");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));//字體大小
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        String[] buttons = {
            "MC", "MR", "M+", "M-", "MS", "M↺", 
            "%", "CE", "C", "⌫",
            "1/x", "x²", "√x", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "="
        };
        JPanel row1 = new JPanel(new GridLayout(1, 6, 5, 5));//第一列
        for (int i = 0; i < 6; i++) {
            String text = buttons[i];
            JButton btn = new JButton(text);
            btn.addActionListener(e -> handleButtonClick(text));
            row1.add(btn);
        }
        buttonPanel.add(row1);

        for (int i = 6; i < buttons.length; i += 4) {
            JPanel row = new JPanel(new GridLayout(1, 4, 5, 5));
            for (int j = 0; j < 4; j++) {
                if (i + j < buttons.length) {
                    String text = buttons[i + j];
                    JButton btn = new JButton(text);
                    btn.addActionListener(e -> handleButtonClick(text));
                    row.add(btn);
                }
            }
            buttonPanel.add(row);
        }


        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null); // 置中顯示
        frame.setVisible(true);
        frame.setSize(380, 550);//螢幕大小
    }

    private void handleButtonClick(String command) {
        String result = logic.processInput(command);
        display.setText(result);
    }
}