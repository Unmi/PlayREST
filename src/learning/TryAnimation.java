package learning;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by uqiu on 9/8/14.
 */
public class TryAnimation extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    Group root = new Group();
    Scene scene = new Scene(root, 600, 400);

    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(5));
    gridPane.setHgap(5);
    gridPane.setVgap(5);

    Button button = new Button("Move");
    button.setPrefSize(100,60);

    Button fadeOutBtn = new Button("FadeOut");
    fadeOutBtn.setOnAction((activeEvent) -> {
      FadeTransition fadeButton = new FadeTransition(Duration.millis(1000), button);
      fadeButton.setFromValue(1.0);
      fadeButton.setToValue(0.0);
      fadeButton.play();
    });

    gridPane.add(button, 0, 0);
    gridPane.add(fadeOutBtn, 0, 1);

    Button translateBtn = new Button("move");
    translateBtn.setOnAction(actionEvent -> {
      TranslateTransition trans = new TranslateTransition(Duration.millis(1000), button);
      trans.setFromX(10);
      trans.setToX(400);
      trans.setToY(200);
      trans.setInterpolator(Interpolator.EASE_IN);
      trans.play();
    });

    gridPane.add(translateBtn, 1, 1);
    root.getChildren().add(gridPane);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
