package com.example.model;

/**
 * The Class Point.
 */
public class Point {

    /** The x. */
    private int x;

    /** The y. */
    private int y;

    /**
     * Instantiates a new point.
     *
     */
    public Point(){
        x = 0;
        y = 0;
    }

    /**
     * Instantiates a new point.
     *
     * @param _x the x
     * @param _y the y
     */
    public Point(int _x, int _y){
        x = _x;
        y = _y;
    }

    /**
     * Gets the x.
     *
     * @return the x.
     */
    public int getX(){
        return x;
    }

    /**
     * Gets the y.
     *
     * @return the y.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the x.
     *
     * @param _x the x
     */
    public void setX(int _x) {
        this.x = _x;
    }

    /**
     * Sets the y.
     *
     * @param _y the y
     */
    public void setY(int _y) {
        this.y = _y;
    }
}
