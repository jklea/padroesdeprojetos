package com.mycompany.myapp;

import com.mycompany.myapp.view.MainScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        var label = new Label("Hello, JavaFX ");
        var scene = new MainScene(this);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public  void setScene(Scene scene) {
        stage.setScene(scene);
    }

}