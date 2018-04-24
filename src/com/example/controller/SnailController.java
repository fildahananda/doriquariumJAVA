package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.model.Aquarium;
import com.example.model.Snail;
import com.example.model.Coin;

// TODO: Auto-generated Javadoc
/**
 * SnailController class managing snails outside its behavior.
 *
 */
public class SnailController implements ISubController {

    /** The snails. */
    private List<Snail> snails;

    /** The to remove. */
    private List<Snail> toRemove;

    /**
     * Instantiates a new fish controller.
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
//        removeObsoleteSnails();
//        for (Snail snail : snails) {
//            if (!snail.isDeadByStarvation()) {
//                snail.move();
//            } else {
//                toRemove.add(snail);
//            }
//        }

        for (Snail snail : snails) {
            snail.move();
        }
    }

    /**
     * Adds the new entity.
     */
    public void addNewEntity() {
//        Random random = new Random();
//        int bound = Aquarium.WIDTH / 10;
//        int randX = bound + random.nextInt(Aquarium.WIDTH - (2 * bound));
//        int randY = bound + random.nextInt(Aquarium.HEIGHT - (2 * bound));
        Snail newSnail = new Snail(Aquarium.WIDTH / 2, Aquarium.HEIGHT - 50);
        snails.add(newSnail);
    }

    /**
     * Gets the number of snail.
     *
     * @return the number of snail
     */
    public int getNumberOfSnail() {
        return snails.size();
    }
}
