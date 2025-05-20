package FinalProject;

class CalculatorLogic {
    private double result = 0;
    private String lastCommand = "=";
    private boolean start = true;
    private String currentDisplay = "0";
    private double memory = 0; // 新增記憶體變數

    public String processInput(String command) {
        if (command.equals("1/x")) { // 優先處理 1/x
            System.out.println("Entering 1/x with currentDisplay: " + currentDisplay);
            try {
                double x = Double.parseDouble(currentDisplay.trim()); // 去除可能的空格
                if (x != 0) {
                    currentDisplay = String.format("%.6f", 1 / x); // 格式化到 6 位小數
                    System.out.println("1/x result: " + currentDisplay);
                } else {
                    currentDisplay = "Cannot divide by zero";
                    System.out.println("1/x error: Division by zero");
                }
            } catch (NumberFormatException e) {
                currentDisplay = "Invalid input";
                System.out.println("1/x error: Invalid number");
            }
            start = true; // 重置狀態
        } else if (command.equals("%")) { // 新增 % 按鈕邏輯
            System.out.println("Entering % with currentDisplay: " + currentDisplay);
            try {
                double x = Double.parseDouble(currentDisplay.trim());
                currentDisplay = String.format("%.6f", x / 100); // 將輸入除以 100
                System.out.println("% result: " + currentDisplay);
            } catch (NumberFormatException e) {
                currentDisplay = "Invalid input";
                System.out.println("% error: Invalid number");
            }
            start = true; // 重置狀態
        } else if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            if (start) {
                currentDisplay = command;
                start = false;
            } else {
                currentDisplay += command;
            }
        } else if (command.equals("+/-")) {
            if (!currentDisplay.equals("error")) {
                try {
                    double value = Double.parseDouble(currentDisplay);
                    value = -value;
                    currentDisplay = String.valueOf(value);
                } catch (NumberFormatException e) {
                    currentDisplay = "error";
                }
            }
        } else if (command.equals("C")) {
            result = 0;
            currentDisplay = "0";
            lastCommand = "=";
            start = true;
        } else if (command.equals("CE")) {
            currentDisplay = "0";
            start = true;
        } else if (command.equals("⌫")) {
            if (currentDisplay.length() > 1) {
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
            } else {
                currentDisplay = "0";
            }
        } else if (command.equals("x²")) {
            try {
                double x = Double.parseDouble(currentDisplay);
                currentDisplay = String.valueOf(x * x);
            } catch (NumberFormatException e) {
                currentDisplay = "error";
            }
        } else if (command.equals("√x")) {
            try {
                double x = Double.parseDouble(currentDisplay);
                if (x >= 0) {
                    currentDisplay = String.valueOf(Math.sqrt(x));
                } else {
                    currentDisplay = "error";
                }
            } catch (NumberFormatException e) {
                currentDisplay = "error";
            }
        } else if (command.equals("M+")) {
            try {
                memory += Double.parseDouble(currentDisplay);
                start = true;
            } catch (NumberFormatException e) {
                currentDisplay = "error";
            }
        } else if (command.equals("MR")) {
            currentDisplay = String.valueOf(memory);
            start = true;
        } else if (command.equals("MC")) {
            memory = 0;
        } else {
            try {
                double x = Double.parseDouble(currentDisplay);
                calculate(x);
                lastCommand = command;
                start = true;
                currentDisplay = String.valueOf(result);
            } catch (NumberFormatException e) {
                currentDisplay = "error";
            }
        }
        return currentDisplay;
    }

    private void calculate(double x) {
        switch (lastCommand) {
            case "+":
                result += x;
                break;
            case "-":
                result -= x;
                break;
            case "×":
                result *= x;
                break;
            case "÷":
                if (x != 0) result /= x;
                else result = 0;
                break;
            case "=":
                result = x;
                break;
        }
    }
}