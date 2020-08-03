package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MathScreenController implements Initializable {

    private String mathType;
    private int correctSoFar=0;
    private int incorrectSoFar=0;

    @FXML
    private Label mathTypeLabel;

    @FXML
    private Label num1;
    @FXML
    private Label operation;
    @FXML
    private Label num2;
    @FXML
    private TextField userInput;
    @FXML
    private Label correctCounter;
    @FXML
    private Label incorrectCounter;
    @FXML
    private Label result;

    private int firstInt;
    private int secondInt;

    public String getMathType() {
        return mathType;
    }

    public void setMathType(String mathTypeIn) {
        this.mathType = mathTypeIn;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void reFresh() {
        //Set window Header
        mathTypeLabel.setText("Solve the " + mathType.toLowerCase() + " problem");

        //Set operation Label
        if (mathType == "Addition") {
            operation.setText("+");
        } else {
            operation.setText("-");
        }

        //Set random numbers
        Random rand = new Random();
        firstInt = rand.nextInt(30);
        secondInt = rand.nextInt(30);
        num1.setText(Integer.toString(firstInt));
        num2.setText(Integer.toString(secondInt));

    }

    public void onEnter(ActionEvent event) {
        try {
            if (mathType == "Addition") {
                if (Integer.parseInt(userInput.getText()) == firstInt + secondInt) {
                    result.setText("Correct!");
                    correctSoFar++;
                    correctCounter.setText("Correct: " + correctSoFar);
                    userInput.clear();
                    reFresh();
                } else {
                    result.setText("Incorrect.");
                    incorrectSoFar++;
                    incorrectCounter.setText("Incorrect: " + incorrectSoFar);
                    userInput.clear();
                }
            } else {
                if (Integer.parseInt(userInput.getText()) == firstInt - secondInt) {
                    result.setText("Correct!");
                    correctSoFar++;
                    correctCounter.setText("Correct: " + correctSoFar);
                    userInput.clear();
                    reFresh();
                } else {
                    result.setText("Incorrect.");
                    userInput.clear();

                    incorrectSoFar++;
                    incorrectCounter.setText("Incorrect: " + incorrectSoFar);
                }
            }
        }
        catch(Exception e){

        }
    }

}


//To get the input of the textfield, but found simpler solution
//((TextField)event.getSource()).getText());