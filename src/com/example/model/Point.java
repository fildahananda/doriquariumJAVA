package com.example.model;

public class Point {
    private int x;
    private int y;

    public Point(){
        x = 0;
        y = 0;
    }

    public Point(int _x, int _y){
        x = _x;
        y = _y;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int _x) {
        this.x = _x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
