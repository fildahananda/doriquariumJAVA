package com.example.model;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Snail.
 */
public class Snail extends Entity {

    /** The distance per step. */
    private float distancePerStep = 2;

    /** The current target X. */
    private int currentTargetX;

    /** The current target Y. */
    private int currentTargetY;

    /** The target coin. */
    private Coin targetCoin;

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
            moveDirection(distancePerStep, currentTargetX - this.x >= 0 ? 0 : (float) Math.PI);
            distancePerStep *= 1.001;
        }

//        if (isHungry() && targetFood != null) {
//            setTarget(targetFood);
//            moveDirection(distancePerStep,
//                    (float) Math.atan2(currentTargetY - this.y, currentTargetX - this.x));
//            distancePerStep *= 1.001;
//        } else {
//            if (isTimeToDecideYet()) {
//                Random rand = new Random();
//                nextDecisionTimer = rand.nextInt(30) + 15;
//                setTarget(rand.nextInt(Aquarium.WIDTH), rand.nextInt(Aquarium.HEIGHT));
//                distancePerStep = rand.nextInt(5) + STANDARDDISTANCEPERSTEP / 2;
//            } else {
//                moveDirection(distancePerStep,
//                        (float) Math.atan2(currentTargetY - this.y, currentTargetX - this.x));
//                nextDecisionTimer--;
//            }
//        }
//        increaseHunger(distancePerStep);
//        increaseSpawningCoin(distancePerStep);
    }

    /**
     * Sets the target.
     *
     * @param mo the new target
     */
    private void setTarget(Entity mo) {
        setTarget(mo.x, mo.y);
    }

    /**
     * Sets the target.
     *
     * @param x the x
     * @param y the y
     */
    private void setTarget(int x, int y) {
        this.currentTargetX = x;
        this.currentTargetY = y;
    }

    /**
     * Checks if is near target yet.
     *
     * @return true, if is near target yet
     */
    private boolean isNearTargetYet() {
        int dx = Math.abs(currentTargetX - this.x);
        int dy = Math.abs(currentTargetY - this.y);
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
     * Checks for eaten.
     */
    public void hasEaten() {
//        this.hunger = 0;
//        this.growth += 5;
    }

    public boolean isOnRemoval() {
        return removeFlag;
    }
}
