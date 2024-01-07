package com.example.ponggame;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Ball {
    double x;
    double y;
    int directionX;
    int directionY;
    int xVelocity;
    int yVelocity;
    int speed=10;
    Random random;

    Ball() {
        random = new Random();
        directionX = random.nextInt(2);
        directionY = random.nextInt(2);
        if(directionX == 0) {
            directionX--;
        }
        if(directionY==0) {
            directionY--;
        }
        setXDirection(directionX*speed);
        setYDirection(directionY*speed);
    }
    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }
    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }
}
