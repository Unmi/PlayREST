package learning;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by uqiu on 9/7/14.
 */
public class HelloWorldMain  extends Application{

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Hello World");
    Group root = new Group();
    Scene scene = new Scene(root, 300, 250);
    Button btn = new Button();

    btn.setLayoutX(100);
    btn.setLayoutY(80);
    btn.setText("Hello World");

    btn.setOnAction((ActionEvent event) -> {
      System.out.println("Hello World");
    });

    root.getChildren().add(btn);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
