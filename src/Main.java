import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.regexp.joni.ast.AnchorNode;
import views.MainMenuBar;

public class Main extends Application {

  public void start1(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("views/main.fxml"));
    primaryStage.setTitle("Play REST Client");
    primaryStage.setScene(new Scene(root, 1200, 800));
    primaryStage.show();
//        javafx.scene.layout.FlowPane
  }


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Play REST Client - local");
    Group root = new Group();
    Scene scene = new Scene(root, 1024, 768);

    AnchorPane anchorPane = new AnchorPane();

    Label urlLabel = new Label("URL: ");
    urlLabel.setFont(Font.font(16));
    Button sendButton = new Button("Send");
    ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(
        "GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PATCH"));
    comboBox.getSelectionModel().select(0);
    TextField urlTextField = new TextField();

    TextArea requestTextArea = new TextArea();
    TextArea responseTextArea = new TextArea();

    anchorPane.getChildren().addAll(urlLabel, sendButton, comboBox, urlTextField, requestTextArea, responseTextArea);

    AnchorPane.setLeftAnchor(urlLabel, 10d);
    AnchorPane.setTopAnchor(urlLabel, 12d);

    sendButton.setPrefWidth(60);
    AnchorPane.setTopAnchor(sendButton, 10d);
    AnchorPane.setRightAnchor(sendButton, 10d);

    AnchorPane.setTopAnchor(comboBox, 10d);
    AnchorPane.setRightAnchor(comboBox, 80d);

//    urlTextField.prefWidthProperty().bind(scene.widthProperty().subtract(255));
    AnchorPane.setTopAnchor(urlTextField, 10d);
    AnchorPane.setLeftAnchor(urlTextField, 55d);
    AnchorPane.setRightAnchor(urlTextField, 200d);

    AnchorPane.setTopAnchor(requestTextArea, 60d);
    AnchorPane.setLeftAnchor(requestTextArea, 10d);
    AnchorPane.setRightAnchor(requestTextArea, 10d);
    requestTextArea.prefHeightProperty().bind(scene.heightProperty().subtract(80).multiply(0.2).subtract(20));

    AnchorPane.setBottomAnchor(responseTextArea, 20d);
    AnchorPane.setLeftAnchor(responseTextArea, 10d);
    AnchorPane.setRightAnchor(responseTextArea, 10d);
    responseTextArea.prefHeightProperty().bind(scene.heightProperty().subtract(80).multiply(0.8));

    anchorPane.prefWidthProperty().bind(scene.widthProperty());
    anchorPane.prefHeightProperty().bind(scene.heightProperty());
    root.getChildren().add(anchorPane);


    root.getChildren().add(MainMenuBar.build(primaryStage));

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
