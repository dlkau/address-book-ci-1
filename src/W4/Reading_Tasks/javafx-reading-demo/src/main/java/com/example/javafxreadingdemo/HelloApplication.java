package com.example.javafxreadingdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
       Scene scene = new Scene(fxmlLoader.load(), 320, 180);
       String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
       scene.getStylesheets().add(stylesheet);
       stage.setTitle("Hello!");
       stage.setScene(scene);
       stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}