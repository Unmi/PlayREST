package learning;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by uqiu on 9/7/14.
 */
public class DrawingText extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Drawing Text");
    Group root = new Group();
    Scene scene = new Scene(root, 300,250, Color.WHITE);
    Random rand = new Random(System.currentTimeMillis());
    for(int i=0; i< 100; i++) {
      int x = rand.nextInt((int) scene.getWidth());
      int y = rand.nextInt((int) scene.getHeight());

      int red = rand.nextInt(255);
      int green = rand.nextInt(255);
      int blue = rand.nextInt(255);

      Text text = new Text(x, y, "JavaFX 2.0");
      text.setFont(Font.font("Monospaced"));

      Reflection reflection = new Reflection();
      reflection.setFraction(0.8f);
      text.setEffect(reflection);

      int rot = rand.nextInt(360);
      text.setFill(Color.rgb(red, green, blue, .99));
      text.setRotate(rot);

      root.getChildren().add(text);
    }

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
