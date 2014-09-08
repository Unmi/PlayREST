package learning;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by uqiu on 9/7/14.
 */
public class WorkObservableList extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("ObservableLists");
    Group root = new Group();
    Scene scene = new Scene(root, 400, 250, Color.WHITE);

    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(5));
    gridPane.setHgap(10);
    gridPane.setVgap(10);

    Label candidatesLbl = new Label("Candidates");
    gridPane.add(candidatesLbl, 0, 0);

    Label heroesLbl = new Label("Heroes");
    gridPane.add(heroesLbl, 2, 0);
    GridPane.setHalignment(heroesLbl, HPos.CENTER);

    final ObservableList<String> candidates = FXCollections.observableArrayList(
        "Spiderman",
        "Wolverine",
        "Police",
        "Fire Rescue",
        "Soldiers",
        "Dad & Mom",
        "Doctor",
        "Politician",
        "Pastor",
        "Teacher");
    final ListView<String> candidatesListView = new ListView<>(candidates);
    candidatesListView.setPrefWidth(150);
    candidatesListView.setPrefHeight(150);

    gridPane.add(candidatesListView, 0, 1);

    final ObservableList<String> heroes = FXCollections.observableArrayList();
    final ListView<String> hereListView = new ListView<>(heroes);
    hereListView.setPrefSize(150, 150);

    gridPane.add(hereListView, 2, 1);

    Button sendRightButton = new Button(">");
    sendRightButton.setOnAction((actionEvent) -> {
      String potential = candidatesListView.getSelectionModel().getSelectedItem();
      if(potential != null) {
        candidatesListView.getSelectionModel().clearSelection();
        candidates.remove(potential);
        heroes.add(potential);
      }
    });

    VBox vbox = new VBox(5);
    vbox.getChildren().addAll(sendRightButton);

    gridPane.add(vbox, 1, 1);
    GridPane.setConstraints(vbox, 1, 1, 1, 2, HPos.CENTER, VPos.CENTER);

    root.getChildren().add(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
