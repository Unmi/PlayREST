package yanbin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Play REST Client");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
//        javafx.scene.layout.FlowPane
    }


    public static void main(String[] args) {
        launch(args);
    }
}