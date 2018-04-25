package com.example.model;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Snail.
 */
public class Snail extends Entity {

    /** The distance per step. */
    private int distancePerStep = 2;

    /** The current target X. */
    private double currentTargetX;

    /** The current target Y. */
    private double currentTargetY;

    /** The target coin. */
    private Coin targetCoin;

    /** The direction snail is facing. */
    private boolean facingRight;

    /** The remove flag. */
    private boolean removeFlag;

    /**
     * Instantiates a new snail.
     */
    public Snail() {
        this(0, 0);
    }

    /**
     * Instantiates a new snail.
     *
     * @param x the x
     * @param y the y
     */
    public Snail(int x, int y) {
        super(x, y);
        facingRight = true;
        removeFlag = false;
    }

    /*
     * (non-Javadoc)
     *
     * @see models.MovingObject#move()
     */
    public void move() {
        if (targetCoin != null) {
            setTarget(targetCoin);
            moveDirection(distancePerStep, currentTargetX - this.getPosition().getX() >= 0 ? 0 : (float) Math.PI);
            distancePerStep *= 1.001;
            facingRight = currentTargetX - this.getPosition().getX() >= 0 ? true : false;
        }
    }

    /**
     * Sets the target.
     *
     * @param mo the new target
     */
    private void setTarget(Entity mo) {
        setTarget(mo.getPosition().getX(), mo.getPosition().getY());
    }

    /**
     * Sets the target.
     *
     * @param x the x
     * @param y the y
     */
    private void setTarget(double x, double y) {
        this.currentTargetX = x;
        this.currentTargetY = y;
    }

    /**
     * Checks if is near target yet.
     *
     * @return true, if is near target yet
     */
    private boolean isNearTargetYet() {
        double dx = Math.abs(currentTargetX - this.getPosition().getX());
        double dy = Math.abs(currentTargetY - this.getPosition().getY());
        return (dx < 10 && dy < 10);
    }

    /**
     * Sets the target coin.
     *
     * @param targetCoin the new target coin
     */
    public void setTargetCoin(Coin targetCoin) {
        this.targetCoin = targetCoin;
    }

    /**
     * Checks direction snail is facing.
     */
    public boolean isFacingRight() { return facingRight; }

    /**
     * Checks for eaten.
     */
    public void hasEaten() {

    }

    /**
     * Checks if is on removal.
     *
     * @return true, if is on removal
     */
    public boolean isOnRemoval() {
        return removeFlag;
    }
}
