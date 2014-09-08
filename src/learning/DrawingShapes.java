package learning;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 * Created by uqiu on 9/7/14.
 */
public class DrawingShapes extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Drawing shapes");

    Group root = new Group();
    Scene scene = new Scene(root, 300, 250);

    Path path = new Path();
    MoveTo moveTo = new MoveTo();
    moveTo.setX(10);
    moveTo.setY(10);

    path.getElements().add(moveTo);
    path.setStroke(Color.RED);

    LineTo lineTo = new LineTo();
    lineTo.setX(150);
    lineTo.setY(150);
    path.getElements().add(lineTo);

    root.getChildren().add(path);

    Ellipse circle = new Ellipse(150, 100, 100, 50);
    circle.setFill(Color.YELLOW);
    root.getChildren().add(circle);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
