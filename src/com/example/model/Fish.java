package com.example.model;

import java.util.Random;

public interface Fish {
    /*
     * (non-Javadoc)
     *
     * @see models.MovingObject#move()
     */
    void move();

    /**
     * Sets the target.
     *
     * @param mo the new target
     */
    void setTarget(Entity mo);

    /**
     * Sets the target.
     *
     * @param x the x
     * @param y the y
     */
    void setTarget(int x, int y);

    /**
     * Checks if is hungry.
     *
     * @return true, if is hungry
     */
    boolean isHungry();

    /**
     * Checks if is dead by starvation.
     *
     * @return true, if is dead by starvation
     */
    boolean isDeadByStarvation();

    /**
     * Checks if is spawning coin.
     *
     * @return true, if is spawning coin
     */
    boolean isSpawningCoin();

    /**
     * Increase hunger.
     *
     * @param distanceTaken the distance taken
     */
    void increaseHunger(double distanceTaken);

    /**
     * Increase spawning coin time.
     *
     * @param distanceTaken the distance taken
     */
    void increaseSpawningCoin(double distanceTaken);

    /**
     * Checks if is time to decide yet.
     *
     * @return true, if is time to decide yet
     */
    abstract boolean isTimeToDecideYet();

    /**
     * Checks if is near target yet.
     *
     * @return true, if is near target yet
     */
    boolean isNearTargetYet();

    /**
     * Gets the hunger.
     *
     * @return the hunger
     */
    int getHunger();

    /**
     * Gets the coin value.
     *
     * @return the coin value
     */
    int getSpawnedCoinValue();

    /**
     * Checks for eaten.
     */
    void hasEaten();

    /**
     * Checks for spawned coin.
     */
    void hasSpawnedCoin();

    public boolean isOnRemoval();
}
