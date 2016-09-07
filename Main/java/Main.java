/*
 * File: Main.java
 * Names: Alex, Mike, Vivek
 * Class: CS361
 * Project 1
 * Date: September 7, 2016
 */

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Main extends Application
{

    public String createDialogBox() {
        TextInputDialog dialog = new TextInputDialog("60");
        dialog.setTitle("Starting Note");
        dialog.setHeaderText("Give me a starting note (0-115)");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            return result.get();
        }
        else {
            return "";
        }
    }

    @Override
    public void start(Stage primaryStage) {

        Menu mainMenu = new Menu("File");
        MenuItem menuItem = new MenuItem("Exit");
        mainMenu.getItems().add(menuItem);
        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
            }
        });

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(mainMenu);

        Button playButton = new Button();
        playButton.setText("Play Scale");
        playButton.setStyle("-fx-base: #008000");
        playButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                // create new dialog box
                // from that dialog box, grab the input text
                String resultString = createDialogBox();
            }
        });

        Button stopButton = new Button();
        stopButton.setText("Stop Playing");
        stopButton.setStyle("-fx-base: #FF0000");

        HBox hbox = new HBox(8);
        hbox.getChildren().addAll(playButton, stopButton);
        hbox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(menuBar, hbox);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 300, 250);

        primaryStage.setTitle("Scale Player");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
