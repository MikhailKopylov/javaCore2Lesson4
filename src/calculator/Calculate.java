package calculator;

public class Calculate {


    private final String[] elements;

    public Calculate(String... elements) {
        this.elements = elements;
    }

    public String resultCalculate(){
        double firstNumber = Double.parseDouble(elements[0]);
        double secondNumber = Double.parseDouble(elements[2]);
        String result = "";
        switch (elements[1].charAt(0)) {
            case '+':
                result = String.valueOf(firstNumber + secondNumber);
                break;
            case '-':
                result = String.valueOf(firstNumber - secondNumber);
                break;
            case '*':
                result = String.valueOf(firstNumber * secondNumber);
                break;
            case '/':
                if (secondNumber != 0) {
                    result = String.valueOf(firstNumber / secondNumber);
                } else {
                    result = "Error!";
                }
                break;
        }
        return result;
    }
}
