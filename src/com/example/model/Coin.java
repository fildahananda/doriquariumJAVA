package com.example.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Coin.
 */
public class Coin extends Entity {

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
     * Gets the coin value.
     *
     * @return the coin value.
     */
    public int getCoinValue() {
        return coinValue;
    }

    /**
     * Sets the coin value.
     *
     * @param val the coin value
     */
    public void setCoinValue(int val){
        this.coinValue = val;
    }

    /**
     * Checks if is on removal.
     *
     * @return true, if is on removal
     */
    public boolean isOnRemoval() {
        return removeFlag;
    }

    @Override
    public void move() {
        if (getPosition().getY() < Aquarium.HEIGHT - 20) moveDirection(STANDARDDISTANCEPERSTEP / 5, (float) (0.5 * Math.PI));
    }

    /**
     * Checks for been eaten.
     */
    public void hasBeenEaten() {
        removeFlag = true;
        Aquarium.money += coinValue;
    }
}

