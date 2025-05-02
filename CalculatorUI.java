package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 5, 5, 5));
        String[] buttons = {
                "MC", "MR", "M+", "M-", "MS", "M↺", "%", "CE", "C", "⌫",
                "1/x", "x²", "√x", "÷", "7", "8", "9", "×", "4", "5",
                "6", "-", "1", "2", "3", "+", "+/-", "0", ".", "="
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(text);
                }
            });
            buttonPanel.add(btn);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null); // 置中顯示
        frame.setVisible(true);
    }

    private void handleButtonClick(String command) {
        String result = logic.processInput(command);
        display.setText(result);
    }
}