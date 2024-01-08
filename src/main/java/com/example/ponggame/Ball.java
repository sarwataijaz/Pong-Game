package com.example.ponggame;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Ball {
    double x;
    double y;
    int directionX;
    int directionY;
    int xVelocity;
    int yVelocity;

    Circle circle;
    Random random;

//    Ball() {
//        circle = new Circle(CIRCLE_RADIUS);
//        circle.setFill(Color.RED);
//        circle.relocate(WIDTH / 2 - CIRCLE_RADIUS, HEIGHT / 2 - CIRCLE_RADIUS);
//
//        random = new Random();
//        directionX = random.nextInt(2);
//        directionY = random.nextInt(2);
//        if(directionX == 0) { // this way the ball wont move
//            directionX--;
//        }
//        if(directionY==0) {
//            directionY--;
//        }
//        setXDirection(directionX*SPEED);
//        setYDirection(directionY*SPEED);
//
//
//    }
//    public void setXDirection(int randomXDirection) {
//        xVelocity = randomXDirection;
//    }
//    public void setYDirection(int randomYDirection) {
//        yVelocity = randomYDirection;
//    }
//    public void move() {
//        x += xVelocity;
//        y += yVelocity;
//        circle.setLayoutX(x);
//        circle.setLayoutY(y);
//    }
}
