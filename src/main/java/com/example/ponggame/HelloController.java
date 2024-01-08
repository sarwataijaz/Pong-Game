package com.example.ponggame;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

public class HelloController implements Runnable {
   @FXML
    Rectangle paddle1;
   @FXML
    AnchorPane layout;
   @FXML
   Rectangle up;
   @FXML
   Rectangle down;
   @FXML
   Circle ball;

   Thread gameThread;

    final static double RECTANGLE_HEIGHT = 95;
    final static double SCREEN_HEIGHT = 504;
    private static final int SCREEN_WIDTH = 690;
    final static double MOVING_LIMIT_UP = -185; // can be customized tho-
    final static double MOVING_LIMIT_DOWN= 195;
    private static final int CIRCLE_RADIUS = 20;
    private static final int SPEED = 5;

    boolean gameOver = false;
    Random random;
    int directionX;
    int directionY;
    int xVelocity;
    int yVelocity;

    @FXML
    public void initialize() {
        // Add event handler directly in the initialize method
        layout.setOnMouseMoved(event -> movePaddle1(event.getY()));
        gameThread = new Thread((Runnable) this);
        gameThread.start();
    }

   public void movePaddle1(double mouseY) {

       double newY = mouseY - RECTANGLE_HEIGHT ;
       paddle1.setY(newY-RECTANGLE_HEIGHT);

        if(paddle1.getBoundsInParent().intersects(up.getBoundsInParent())) {
            paddle1.setY(MOVING_LIMIT_UP);
        }
       if(paddle1.getBoundsInParent().intersects(down.getBoundsInParent())) {
           paddle1.setY(MOVING_LIMIT_DOWN);
       }
   }

   void setBall() {
       random = new Random();
        directionX = random.nextInt(4);
        directionY = random.nextInt(4);
        if(directionX == 0) { // this way the ball wont move
            directionX--;
        }
        if(directionY==0) {
            directionY--;
        }
        setXDirection(directionX*SPEED);
        setYDirection(directionY*SPEED);
   }

    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }
    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }

    public void moveBall() {
        double currentX = ball.getLayoutX();
        double currentY = ball.getLayoutY();

            ball.setLayoutX(currentX + xVelocity);
            ball.setLayoutY(currentY + yVelocity);

    }


    @Override
    public void run() {
        //game loop
        try {
            Thread.sleep(100); // Adjust the duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!gameOver) {

                setBall();
                moveBall();
            }

    }

}