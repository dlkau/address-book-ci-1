package com.example.javafxreadingdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Define the root node and set the alignment and spacing properties.
        // Also, set the fillWidth property to false so the children are not
        // resized to fil the width of the VBox.
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15.0);
        root.setFillWidth(false);
        // Create a TextField, a Label and an HBox with appropriate text.
        TextField textField = new TextField();
        textField.setText("TextField");
        Label label = new Label("Label");
        // The HBox is used to hold the buttons
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(15.0);
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        // Add the buttons to the HBox
        hbox.getChildren().addAll(button1, button2, button3);
        // Add the children to the root vbox
        root.getChildren().addAll(textField, label, hbox);
        // Define the scene, add to the stage (window) and show the stage
        Scene scene = new Scene(root, 320, 180);
        stage.setScene(scene);
        stage.setTitle("JavaFX Example Scene");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}