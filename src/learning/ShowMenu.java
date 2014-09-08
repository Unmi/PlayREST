package learning;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by uqiu on 9/7/14.
 */
public class ShowMenu extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Creating Menus");
    Group root = new Group();
    Scene scene = new Scene(root, 300,250, Color.YELLOW);

    MenuBar menuBar = new MenuBar();

    Menu menu = new Menu("File");
    menu.getItems().add(new MenuItem("New"));
    menu.getItems().add(new MenuItem("Save"));
    menu.getItems().add(new SeparatorMenuItem());
    menu.getItems().add(new MenuItem("Exit"));

    menuBar.getMenus().add(menu);

    Menu tools = new Menu("Cameras");

    CheckMenuItem checkMenuItem = new CheckMenuItem("Show Camera 1");
    checkMenuItem.setSelected(true);
    tools.getItems().add(checkMenuItem);

    menuBar.getMenus().add(tools);

    Menu alarm = new Menu("Alarm");
    ToggleGroup toggleGroup = new ToggleGroup();
    RadioMenuItem soundAlarmItem = new RadioMenuItem("Sound Alarm");
    soundAlarmItem.setToggleGroup(toggleGroup);
    RadioMenuItem stopAlarmItem = new RadioMenuItem("Alarm Off");
    stopAlarmItem.setSelected(true);
    stopAlarmItem.setToggleGroup(toggleGroup);
    alarm.getItems().add(soundAlarmItem);
    alarm.getItems().add(stopAlarmItem);
    menuBar.getMenus().add(alarm);

    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
    menuBar.setUseSystemMenuBar(true);
    root.getChildren().add(menuBar);
    primaryStage.setScene(scene);
    primaryStage.show();

  }
}
