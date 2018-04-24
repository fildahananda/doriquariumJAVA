package com.example.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Coin.
 */
public class Coin extends MovingObject {

    /** The remove flag. */
    private boolean removeFlag;

    /** The coin value. */
    private int coinValue;

    /**
     * Instantiates a new coin.
     *
     * @param x the x
     * @param y the y
     * @param coinValue the coinValue
     */
    public Coin(int x, int y, int coinValue) {
        super(x, y);
        removeFlag = false;
        this.coinValue = coinValue;
    }

    /**
     * Checks if is on removal.
     *
     * @return true, if is on removal
     */
    public boolean isOnRemoval() {
        return removeFlag;
    }

    /*
     * (non-Javadoc)
     *
     * @see models.MovingObject#move()
     */
    /*
     * method for moving coin down the aquarium
     *
     */
    @Override
    public void move() {
        if (getY() < Aquarium.HEIGHT - 20) moveDirection(STANDARDDISTANCEPERSTEP / 5, (float) (0.5 * Math.PI));
    }

    /**
     * Checks for been eaten.
     */
    public void hasBeenEaten() {
        removeFlag = true;
        Aquarium.money += coinValue;
    }
}

