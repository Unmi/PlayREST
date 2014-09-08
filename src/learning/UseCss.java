package learning;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by uqiu on 9/7/14.
 */
public class UseCss extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Generating Borders");

    Group root = new Group();
    Scene scene = new Scene(root, 925, 623, Color.WHITE);
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(5));
    gridPane.setHgap(10);
    gridPane.setVgap(10);

    Label cssEditorLbl = new Label("CSS Editor");
    GridPane.setHalignment(cssEditorLbl, HPos.CENTER);
    gridPane.add(cssEditorLbl, 0, 0);

    Label borderLbl = new Label("Border View");
    GridPane.setHalignment(borderLbl, HPos.CENTER);
    gridPane.add(borderLbl, 1, 0);

    final TextArea cssEditorFld = new TextArea();
    cssEditorFld.setPrefRowCount(10);
    cssEditorFld.setPrefColumnCount(100);
    cssEditorFld.setWrapText(true);
    cssEditorFld.setPrefWidth(150);
    GridPane.setHalignment(cssEditorFld, HPos.CENTER);
    gridPane.add(cssEditorFld, 0, 1);

    String cssDefault = "-fx-border-color: blue;\n"
        + "-fx-border-insets: 5;\n"
        + "-fx-border-width: 3;\n"
        + "-fx-border-style: dashed;\n";

    cssEditorFld.setText(cssDefault);

    final ImageView imv = new ImageView();
    final Image image2 = new Image(this.getClass().
        getResourceAsStream("/learning/images/smoke_glass_buttons1.png"));
    imv.setImage(image2);

    final HBox pictureRegion = new HBox();
    pictureRegion.setStyle(cssDefault);
    pictureRegion.getChildren().add(imv);
    gridPane.add(pictureRegion, 1, 1);

    Button apply = new Button("Bling!");
    GridPane.setHalignment(apply, HPos.RIGHT);
    gridPane.add(apply, 0, 2);

    apply.setOnAction((actionEvent) -> {
      pictureRegion.setStyle(cssEditorFld.getText());
    });

    root.getChildren().add(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
