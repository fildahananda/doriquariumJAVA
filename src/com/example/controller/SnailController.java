package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Aquarium;
import com.example.model.Snail;

// TODO: Auto-generated Javadoc
/**
 * The Class SnailController.
 * SnailController class managing snails outside its behavior.
 *
 */
public class SnailController implements ISubController {

    /** The snails. */
    private List<Snail> snails;

    /** The list of snails to remove. */
    private List<Snail> toRemove;

    /**
     * Instantiates a new snail controller.
     */
    public SnailController() {
        snails = new ArrayList<Snail>();
        toRemove = new ArrayList<Snail>();
    }

    /**
     * Gets the snails.
     *
     * @return the snails
     */
    public List<Snail> getSnails() {
        return snails;
    }

    /*
     * (non-Javadoc)
     *
     * @see controllers.ISubController#perform()
     */
    /*
     * implementing from ISubController interface method
     *
     */
    @Override
    public void perform() {
        for (Snail snail : snails) {
            snail.move();
        }
    }

    /**
     * Adds the new entity.
     */
    public void addNewEntity() {
        Snail newSnail = new Snail(Aquarium.WIDTH / 2, Aquarium.HEIGHT - 55);
        snails.add(newSnail);
    }
}
