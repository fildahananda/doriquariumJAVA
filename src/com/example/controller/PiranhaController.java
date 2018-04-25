package com.example.controller;

import com.example.model.Aquarium;
import com.example.model.Piranha;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc

/**
 * The Class Piranha Controller
 * GuppyController class managing guppies outside its behavior.
 *
 */
public class PiranhaController implements ISubController {

    /** The guppies. */
    private List<Piranha> piranhas;

    /** The list of guppies to remove. */
    private List<Piranha> toRemove;

    /**
     * Instantiates a new fish controller.
     */
    public PiranhaController() {
        piranhas = new ArrayList<Piranha>();
        toRemove = new ArrayList<Piranha>();
    }

    /**
     * Gets the piranhas.
     *
     * @return the piranhas
     */
    public List<Piranha> getPiranhas() {
        return piranhas;
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
        removeObsoleteFishes();
        for (Piranha piranha : piranhas) {
            if (!piranha.isDeadByStarvation()) {
                piranha.move();
            } else {
                toRemove.add(piranha);
            }
        }
    }

    /**
     * Removes the obsolete piranhas.
     */
    private void removeObsoleteFishes() {
        for (Piranha piranha : piranhas) {
            if (piranha.isOnRemoval()) {
                toRemove.add(piranha);
            }
        }
        if (!toRemove.isEmpty()) {
            for (Piranha piranha : toRemove) {
                piranhas.remove(piranha);
            }
        }
        toRemove.clear();
    }

    /**
     * Adds the new entity.
     */
    public void addNewEntity() {
        Random random = new Random();
        int bound = Aquarium.WIDTH / 10;
        int randX = bound + random.nextInt(Aquarium.WIDTH - (2 * bound));
        int randY = bound + random.nextInt(Aquarium.HEIGHT - (2 * bound));
        Piranha newPiranha = new Piranha(randX, randY);
        piranhas.add(newPiranha);
    }
}
