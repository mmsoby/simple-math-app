package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    @FXML
    private ChoiceBox selectType;
    private ObservableList<String> mathOptions = FXCollections.observableArrayList("Addition", "Subtraction");


    public void initialize() {
        selectType.setValue("Addition");
        selectType.setItems(mathOptions);
    }

    public void startClicked(ActionEvent event) throws IOException {

        //Gets value of choice box
        String mathType = selectType.getValue().toString();

        //Creates new page
        FXMLLoader loader=new FXMLLoader(getClass().getResource("mathscreen.fxml"));
        Parent root= (Parent)loader.load();




        //Show final window
        Scene mathscreenScene = new Scene(root, 800, 500);

        mathscreenScene.getStylesheets().add(getClass().getResource("FXdarkTheme.css").toString());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle(mathType);
        window.setScene(mathscreenScene);
        window.show();


        //sets mathType in the MathScreen Controller
        MathScreenController mathSceneController = loader.getController();
        mathSceneController.setMathType(mathType);
        mathSceneController.reFresh();

    }

}
