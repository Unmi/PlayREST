package views;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * Created by uqiu on 9/8/14.
 */
public class MainMenuBar {

  public static MenuBar build(Stage primaryStage) {
    MenuBar menuBar = new MenuBar();

    Menu fileMenu = new Menu("File");
    fileMenu.getItems().add(new MenuItem("Save"));
    fileMenu.getItems().add(new MenuItem("Load routes"));

    menuBar.getMenus().add(fileMenu);

    Menu serverMenu = new Menu("Server");

    ToggleGroup serverGroup = new ToggleGroup();
    RadioMenuItem localItem = new RadioMenuItem("local");
    localItem.setSelected(true);
    localItem.setToggleGroup(serverGroup);
    localItem.setOnAction(actionEvent -> {
      primaryStage.setTitle("Play REST Client - " + "local");
    });

    RadioMenuItem mobdevItem = new RadioMenuItem("mobdev");
    mobdevItem.setToggleGroup(serverGroup);
    mobdevItem.setOnAction(actionEvent -> {
      primaryStage.setTitle("Play REST Client - " + "mobdev");
    });

    serverMenu.getItems().add(localItem);
    serverMenu.getItems().add(mobdevItem);

    menuBar.getMenus().add(serverMenu);

    menuBar.setUseSystemMenuBar(true);

    return menuBar;
  }
}
