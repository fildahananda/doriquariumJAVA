package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.model.Aquarium;
import com.example.model.Fish;
import com.example.model.Food;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodController.
 */
public class FoodController implements ISubController {

    /** The foods. */
    private List<Food> foods;

    /** The list of foods to remove. */
    private List<Food> toRemove;

    /**
     * Instantiates a new food controller.
     */
    public FoodController() {
        foods = new ArrayList<>();
        toRemove = new ArrayList<>();
    }

    /**
     * Gets the foods.
     *
     * @return the foods
     */
    public List<Food> getFoods() {
        return foods;
    }

    /*
     * (non-Javadoc)
     *
     * @see controllers.ISubController#perform()
     */
    @Override
    public void perform() {
        removeObsoleteFoods();
        for (Food food : foods) {
            if (!(food.getPosition().getY() > Aquarium.HEIGHT - 20)) {
                food.move();
            } else {
                toRemove.add(food);
            }
        }
    }

    /**
     * Removes the obsolete foods.
     */
    private void removeObsoleteFoods() {
        for (Food food : foods) {
            if (food.isOnRemoval()) {
                toRemove.add(food);
            }
        }
        if (!toRemove.isEmpty()) {
            for (Food food : toRemove) {
                foods.remove(food);
            }
        }
        toRemove.clear();
    }

    /**
     * Adds the new entity.
     */
    public void addNewEntity(int xPos, int yPos) {
        Food newFood = new Food(xPos, yPos);
        foods.add(newFood);
    }
}

