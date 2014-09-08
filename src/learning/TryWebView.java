package learning;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Created by uqiu on 9/8/14.
 */
public class TryWebView extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("WebView");

    Group root = new Group();
    Scene scene = new Scene(root, 640, 480);

    BorderPane borderPane = new BorderPane();

    WebView browser = new WebView();
    browser.getEngine().load("http://unmi.cc");

    browser.prefWidthProperty().bind(scene.widthProperty());
    browser.prefHeightProperty().bind(scene.heightProperty());

    borderPane.setCenter(browser);
    root.getChildren().add(borderPane);

    primaryStage.setScene(scene);
    primaryStage.show();

  }
}
