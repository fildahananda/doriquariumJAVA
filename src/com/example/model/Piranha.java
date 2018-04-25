package com.example.model;

import java.util.Random;

// TODO: Auto-generated Javadoc

/**
 * The Class Piranha.
 */

public class Piranha extends Entity implements Fish {
    /** The distance per step. */
    private int distancePerStep = 2;

    /** The next decision timer. */
    private int nextDecisionTimer;

    /** The current target X. */
    private int currentTargetX;

    /** The current target Y. */
    private int currentTargetY;

    /** The target guppy. */
    private Guppy targetGuppy;

    /** The hunger. */
    private int hunger;

    /** The spawning coin time. */
    private int spawningCoin;

    private boolean removeFlag;
    private boolean facingRight;

    /** The spawned coin value. */
    private int spawnedCoinValue;

    /**
     * Instantiates a new fish.
     */
    public Piranha() {
        this(0, 0);
    }

    /**
     * Instantiates a new fish.
     *
     * @param x the x
     * @param y the y
     */
    public Piranha(int x, int y) {
        super(x, y);
        nextDecisionTimer = -1;
        hunger = 0;
        spawningCoin = 0;
        removeFlag = false;
        spawnedCoinValue = 400;
        facingRight = true;
    }

    /*
     * (non-Javadoc)
     *
     * @see models.MovingObject#move()
     */
    public void move() {
        if (isHungry() && targetGuppy != null) {
            setTarget(targetGuppy);
            moveDirection(distancePerStep,
                    (float) Math.atan2(currentTargetY - this.getPosition().getY(), currentTargetX - this.getPosition().getX()));
            distancePerStep *= 1.001;
        } else {
            if (isTimeToDecideYet()) {
                Random rand = new Random();
                nextDecisionTimer = rand.nextInt(30) + 15;
                setTarget(rand.nextInt(Aquarium.WIDTH), rand.nextInt(Aquarium.HEIGHT) - 70);
                distancePerStep = rand.nextInt(5) + STANDARDDISTANCEPERSTEP / 2;
            } else {
                moveDirection(distancePerStep,
                        (float) Math.atan2(currentTargetY - this.getPosition().getY(), currentTargetX - this.getPosition().getX()));
                nextDecisionTimer--;
            }
        }
        increaseHunger(distancePerStep);
        increaseSpawningCoin(distancePerStep);
    }

    /**
     * Sets the target.
     *
     * @param mo the new target
     */
    public void setTarget(Entity mo) {
        setTarget(mo.getPosition().getX(), mo.getPosition().getY());
    }

    /**
     * Sets the target.
     *
     * @param x the x
     * @param y the y
     */
    public void setTarget(int x, int y) {
        this.currentTargetX = x;
        this.currentTargetY = y;
    }

    /**
     * Checks if is hungry.
     *
     * @return true, if is hungry
     */
    public boolean isHungry() {
        return hunger > 2500;
    }

    /**
     * Checks if is dead by starvation.
     *
     * @return true, if is dead by starvation
     */
    public boolean isDeadByStarvation() {
        return hunger > 3000;
    }

    /**
     * Checks if is spawning coin.
     *
     * @return true, if is spawning coin
     */
    public boolean isSpawningCoin() {
        return spawningCoin > 2000;
    }

    /**
     * Increase hunger.
     *
     * @param distanceTaken the distance taken
     */
    public void increaseHunger(double distanceTaken) {
        this.hunger += distancePerStep;
    }

    /**
     * Increase spawning coin time.
     *
     * @param distanceTaken the distance taken
     */
    public void increaseSpawningCoin(double distanceTaken) {
        this.spawningCoin += distancePerStep;
    }

    /**
     * Checks if is time to decide yet.
     *
     * @return true, if is time to decide yet
     */
    public boolean isTimeToDecideYet() {
        return (nextDecisionTimer < 0 || isNearTargetYet());
    }

    /**
     * Checks if is near target yet.
     *
     * @return true, if is near target yet
     */
    public boolean isNearTargetYet() {
        int dx = Math.abs(currentTargetX - this.getPosition().getX());
        int dy = Math.abs(currentTargetY - this.getPosition().getY());
        return (dx < 10 && dy < 10);
    }


    /**
     * Gets the hunger.
     *
     * @return the hunger
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * Gets the coin value.
     *
     * @return the coin value
     */
    public int getSpawnedCoinValue() {
        return spawnedCoinValue;
    }

    /**
     * Sets the target guppy.
     *
     * @param targetGuppy the new target guppy
     */
    public void setTargetGuppy(Guppy targetGuppy) {
        this.targetGuppy = targetGuppy;
    }

    /**
     * Checks for eaten.
     */
    public void hasEaten() {
        this.hunger = 0;
    }

    /**
     * Checks for spawned coin.
     */
    public void hasSpawnedCoin() {
        this.spawningCoin = 0;
    }

    public boolean isOnRemoval() {
        return removeFlag;
    }

    public void hasBeenSold() {
        removeFlag = true;
    }
}

