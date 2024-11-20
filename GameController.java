package com.example.demo3;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GameController {
    @FXML
    private Pane gamePane;

    @FXML
    private Rectangle bird;

    @FXML
    private Label scoreLabel;

    private double birdVelocity = 0;
    private final double gravity = 0.5;
    private final double jumpStrength = -8;
    private int score = 0;

    private AnimationTimer gameLoop;

    @FXML
    public void initialize() {
        setupGame();
        startGame();

        // Ensure the gamePane gets focus
        gamePane.requestFocus();

        // Regain focus if clicked
        gamePane.setOnMouseClicked(event -> gamePane.requestFocus());
    }

    private void setupGame() {
        // Debug key press handling
        gamePane.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("SPACE")) {
                System.out.println("Spacebar pressed!");
                birdVelocity = jumpStrength;
            }
        });

        // Ensure focus is set initially
        gamePane.requestFocus();
    }

    private void startGame() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateBird();
            }
        };
        gameLoop.start();
    }

    private void updateBird() {
        birdVelocity += gravity;
        bird.setY(bird.getY() + birdVelocity);

        if (bird.getY() < 0) {
            bird.setY(0);
        }

        // End game if bird hits the ground
        if (bird.getY() > gamePane.getHeight() - bird.getHeight()) {
            endGame();
        }
    }

    private void endGame() {
        gameLoop.stop();
        System.out.println("Game Over!");
    }

    public void handleSpaceKey() {
        System.out.println("Spacebar pressed!");
        birdVelocity = jumpStrength;
    }
}