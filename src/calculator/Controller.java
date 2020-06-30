package calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Controller {

    public TextArea chatWindow;
    public TextField resultTextField;

    private String sFirstArgument = "";
    private String sSecondArgument = "";
    private String firstOperation = "";


    private boolean isFirstArgument = true;


    public void exit() {
        Stage stage = (Stage) chatWindow.getScene().getWindow();
        stage.close();
    }

    public void pressButton(ActionEvent actionEvent) {
        setDisplayEmpty();
        Button button = (Button) actionEvent.getSource();
        String character = button.getText();
        createExpression(character);
    }


    private void createExpression(String character) {
        switch (character) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
//                String digital = button.getText();
                addDigital(character);
                break;
            case "+":
            case "-":
            case "/":
            case "*":
                if (!sFirstArgument.isEmpty()) {
                    if (sSecondArgument.isEmpty()) {
                        addOperation(character);
                    } else {
                        calculateWithContinuation(character);
                    }
                }
                break;
            case "=":
                if (!sFirstArgument.isEmpty() && !sSecondArgument.isEmpty()) {
                    finalCalculate();
                }
                break;
        }
    }

    private void setDisplayEmpty() {
        if (sSecondArgument.isEmpty() && sFirstArgument.isEmpty()) {
            resultTextField.setText("");
        }
    }

    private void addOperation(String operation) {
        correctDuplicateOperation();
        firstOperation = operation;
        resultTextField.appendText(firstOperation);
        isFirstArgument = false;
    }

    private void calculateWithContinuation(String operation) {
        Calculate calculate = new Calculate(sFirstArgument, firstOperation, sSecondArgument);
        String resultCalculate = calculate.resultCalculate();
        resultTextField.setText(resultCalculate);
        sFirstArgument = resultCalculate;
        sSecondArgument = "";
        firstOperation = "";
        isFirstArgument = false;
        addOperation(operation);
    }

    private void finalCalculate() {
        Calculate calculate = new Calculate(sFirstArgument, firstOperation, sSecondArgument);
        resultTextField.setText(calculate.resultCalculate());
        sFirstArgument = "";
        sSecondArgument = "";
        firstOperation = "";
        isFirstArgument = true;
    }

    private void correctDuplicateOperation() {
        if (!firstOperation.isEmpty()) {
            resultTextField.setText(sFirstArgument);
        }
    }

    private void addDigital(String digital) {
        resultTextField.appendText(digital);
        if (isFirstArgument) {
            sFirstArgument += digital;

        } else {
            sSecondArgument += digital;
        }
    }


    public void pressKey(KeyEvent keyEvent) {
        setDisplayEmpty();
        switch (keyEvent.getCode()) {
            case DIGIT1:
            case NUMPAD1:
                createExpression("1");
                break;
            case DIGIT2:
            case NUMPAD2:
                createExpression("2");
                break;
            case DIGIT3:
            case NUMPAD3:
                createExpression("3");
                break;
            case DIGIT4:
            case NUMPAD4:
                createExpression("4");
                break;
            case DIGIT5:
            case NUMPAD5:
                createExpression("5");
                break;
            case DIGIT6:
            case NUMPAD6:
                createExpression("6");
                break;
            case DIGIT7:
            case NUMPAD7:
                createExpression("7");
                break;
            case DIGIT8:
            case NUMPAD8:
                createExpression("8");
                break;
            case DIGIT9:
            case NUMPAD9:
                createExpression("9");
                break;
            case DIGIT0:
            case NUMPAD0:
                createExpression("0");
                break;
            case PLUS:
            case ADD:
                createExpression("+");
                break;
            case MINUS:
            case SUBTRACT:
                createExpression("-");
                break;
            case MULTIPLY:
                createExpression("*");
                break;
            case DIVIDE:
                createExpression("/");
                break;
            case ENTER:
                createExpression("=");
                break;

        }
    }
}
