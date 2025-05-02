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
        else {
            if (start) {
                if (command.equals("-")) {
                    currentDisplay = command;
                    start = false;
                } else {
                    lastCommand = command;
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