package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Controller {
    public Button sendMessage;
    public TextField newMessageTextField;
    public TextArea chatWindow;

    public void sendMessage() {
        chatWindow.appendText(newMessageTextField.getText() + "\n");
        newMessageTextField.setText("");
        newMessageTextField.requestFocus();
    }

    public void enterSendMessage(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            sendMessage();
        }
    }

    public void exit() {
        Stage stage =(Stage)chatWindow.getScene().getWindow();
        stage.close();
    }
}
