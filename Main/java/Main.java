/*
 * File: Main.java
 * Names: Alex, Mike, Vivek
 * Class: CS361
 * Project 1
 * Date: September 7, 2016
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Main extends Application
{

    public TextInputDialog createDialogBox() {
        TextInputDialog dialog = new TextInputDialog("walter");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter your name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Your name: " + result.get());
        }


        return dialog;
    }


    @Override
    public void start(Stage primaryStage) {

        Button playButton = new Button();
        playButton.setText("Play Scale");
        playButton.setStyle("-fx-base: #008000");
        playButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                // create new dialog box
                // from that dialog box, grab the input text
                TextInputDialog dBox = createDialogBox();
            }
        });

        Button stopButton = new Button();
        stopButton.setText("Stop Playing");
        stopButton.setStyle("-fx-base: #FF0000");

        HBox hbox = new HBox(8);
        hbox.getChildren().addAll(playButton, stopButton);
        hbox.setAlignment(Pos.CENTER);


        Scene scene = new Scene(hbox, 300, 250);

        primaryStage.setTitle("Scale Player");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
