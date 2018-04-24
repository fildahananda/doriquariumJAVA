package com.example.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Entity.
 */
public abstract class Entity {

    /** The Constant STANDARDDISTANCEPERSTEP. */
    protected final static int STANDARDDISTANCEPERSTEP = 10;

    protected Point position;

    private float realX;

    private float realY;

    public Point getPosition(){
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * Instantiates a new moving object.
     */
    public Entity() {
        this.position = new Point(0,0);
        realX=0;
        realY=0;
    }

    /**
     * Instantiates a new moving object.
     *
     * @param x the x
     * @param y the y
     */
    public Entity(float x, float y) {
        this.position = new Point(0,0);
        realX = x;
        realY = y;
        determinePosition();
    }

    /**
     * Move.
     */
    abstract public void move();

    /**
     * Move direction.
     *
     * @param distance the distance
     * @param angle the angle
     */
    public void moveDirection(float distance, float angle) {
        realX += distance*Math.cos(angle);
        realY += distance*Math.sin(angle);
        determinePosition();
    }

    /**
     * Move towards.
     *
     * @param toX the to X
     * @param toY the to Y
     * @param desiredStepTaken the desired step taken
     */
    public void moveTowards(float toX, float toY, float desiredStepTaken) {
        realX = position.getX()+(toX - position.getX())/desiredStepTaken;
        realY = position.getX()+(toY - position.getX())/desiredStepTaken;
        determinePosition();
    }

    /**
     * Determine position.
     */
    private void determinePosition() {
        this.position.setX(Math.round(realX));
        this.position.setY(Math.round(realY));
    }

    /**
     * Calc dist between.
     *
     * @param o1 the o 1
     * @param o2 the o 2
     * @return the float
     */
    public static Float calcDistBetween(Entity o1, Entity o2) {
        return (float) Math.sqrt(Math.pow(o1.getPosition().getX() - o2.getPosition().getX(), 2) + Math.pow(o1.getPosition().getX() - o2.getPosition().getX(), 2));
    }
}
