package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FlappyBirdApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);

        // Attach key press event directly to the Scene
        scene.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("SPACE")) {
                GameController controller = loader.getController();
                controller.handleSpaceKey();
            }
        });

        stage.setTitle("Flappy Bird");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}