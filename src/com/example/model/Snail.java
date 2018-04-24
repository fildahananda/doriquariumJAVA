package com.example.model;

public class Snail extends MovingObject{

    int isFacingRight;
    int velocity;

    public Snail(){
        super(300,448);
        isFacingRight = 0;
    }

    public int getDirection(){
        return isFacingRight;
    }

    public void setDirection(int direct){
        isFacingRight = direct;
    }

    @Override
    public void move() {
        moveDirection(STANDARDDISTANCEPERSTEP / 5, (float) (0.5 * Math.PI));
    }
}
