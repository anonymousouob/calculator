package FinalProject;

class CalculatorLogic {
    private double result = 0;
    private String lastCommand = "=";
    private boolean start = true;
    private String currentDisplay = "0";

    public String processInput(String command) {
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            if (start) {
                currentDisplay = command;
                start = false;
            } else {
                currentDisplay += command;
            }
        }
        else if (command.equals("+/-")) {// 轉換正負號
            if (!currentDisplay.equals("error")) {
                try {
                    double value = Double.parseDouble(currentDisplay);
                    value = -value;  // 直接數值翻轉
                    currentDisplay = String.valueOf(value);  // 更新顯示內容
                } catch (NumberFormatException e) {
                    currentDisplay = "error";
                }
            }
        }else {
            if (start) {
                try {
                    double x = Double.parseDouble(currentDisplay);
                    calculate(x);
                    lastCommand = command;
                    currentDisplay = String.valueOf(result);
                } catch (NumberFormatException e) {
                    currentDisplay = "error";
                }
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