package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller{

    @FXML private ChoiceBox<String> host;
    @FXML private ChoiceBox<String> context;
    @FXML private TextField path;
    @FXML private ChoiceBox<String> method;

    @FXML
    private void sendRequest(ActionEvent event) {
        System.out.println(host.getValue()+method.getValue());
    }


}
