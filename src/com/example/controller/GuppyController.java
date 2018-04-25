package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.model.Aquarium;
import com.example.model.Guppy;

// TODO: Auto-generated Javadoc
/**
 * The Class Guppy Controller
 * GuppyController class managing guppies outside its behavior.
 *
 */
public class GuppyController implements ISubController {

    /** The guppies. */
    private List<Guppy> guppies;

    /** The list of guppies to remove. */
    private List<Guppy> toRemove;

    /**
     * Instantiates a new fish controller.
     */
    public GuppyController() {
        guppies = new ArrayList<Guppy>();
        toRemove = new ArrayList<Guppy>();
    }

    /**
     * Gets the guppies.
     *
     * @return the guppies
     */
    public List<Guppy> getGuppies() {
        return guppies;
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
        for (Guppy guppy : guppies) {
            if (!guppy.isDeadByStarvation()) {
                guppy.move();
            } else {
                toRemove.add(guppy);
            }
        }
    }

    /**
     * Removes the obsolete guppies.
     */
    private void removeObsoleteFishes() {
        for (Guppy guppy : guppies) {
            if (guppy.isOnRemoval()) {
                toRemove.add(guppy);
            }
        }
        if (!toRemove.isEmpty()) {
            for (Guppy guppy : toRemove) {
                guppies.remove(guppy);
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
        Guppy newGuppy = new Guppy(randX, randY);
        guppies.add(newGuppy);
    }
}
