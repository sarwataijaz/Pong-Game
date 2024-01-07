package com.example.ponggame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class HelloController {
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

    int speed=10;
    final static double RECTANGLE_HEIGHT = 95;
    final static double SCREEN_HEIGHT = 500;
    final static double MOVING_LIMIT_UP = -185; // can be customized tho-
    final static double MOVING_LIMIT_DOWN= 195;
    Random random;

    @FXML
    public void initialize() {
        // Add event handler directly in the initialize method
        layout.setOnMouseMoved(event -> movePaddle1(event.getY()));
        moveBall();
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

   void moveBall() {
        ball.setVisible(true);
        ball.setCenterX(speed);


   }

}