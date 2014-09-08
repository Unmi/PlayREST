package learning;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by uqiu on 9/7/14.
 */
public class GridLayout extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("GridLayout");

    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(5));
    gridPane.setHgap(5);
    gridPane.setVgap(5);

    Label fNameLbl = new Label("First Name");
    TextField fNameFld = new TextField();
    Label lNameLbl = new Label("Last Name");
    TextField lNameFld = new TextField();
    Button saveBtn = new Button("Save");

    GridPane.setHalignment(fNameLbl, HPos.RIGHT);
    gridPane.add(fNameLbl, 0, 0);

    GridPane.setHalignment(fNameFld, HPos.LEFT);
    gridPane.add(fNameFld, 1, 0);

    GridPane.setHalignment(lNameLbl, HPos.RIGHT);
    gridPane.add(lNameLbl, 0, 1);
    GridPane.setHalignment(lNameFld, HPos.LEFT);
    gridPane.add(lNameFld, 1,1);

    GridPane.setHalignment(saveBtn, HPos.RIGHT);
    gridPane.add(saveBtn, 1, 2);

    Group root = new Group();
    Scene scene = new Scene(root, 300, 200);
    root.getChildren().add(gridPane);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
