package com.example.controller;

import java.util.List;

import com.example.model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class GameRuleController.
 */
public class GameRuleController implements ISubController {

    /** The Constant FISHPRICE. */
    private static final int FISHPRICE = 200;

    /** The Constant FOODPRICE. */
    private static final int FOODPRICE = 20;

    /** The Constant EGGPRICE. */
    private static final int EGGPRICE = 1000;

    /** The fish controller. */
    GuppyController guppyController;

    /** The food controller. */
    FoodController foodController;

    /** The coin controller. */
    CoinController coinController;

    /** The snail controller. */
    SnailController snailController;

    /**
     * Instantiates a new game rule controller.
     *
     * @param guppyController the fish controller
     * @param foodController the food controller
     * @param coinController the coin controller
     * @param snailController the snail controller
     */
    public GameRuleController(GuppyController guppyController, FoodController foodController, CoinController coinController, SnailController snailController) {
        this.guppyController = guppyController;
        this.foodController = foodController;
        this.coinController = coinController;
        this.snailController = snailController;
    }

    /*
     * (non-Javadoc)
     *
     * @see controllers.ISubController#perform()
     */
    @Override
    public void perform() {
        // Aquarium.money++;
    }

    /**
     * Handle buy fish command.
     */
    public void handleBuyFishCommand() {
        if (Aquarium.money >= FISHPRICE) {
            guppyController.addNewEntity();
            Aquarium.money -= FISHPRICE;
        }
    }

    /**
     * Handle buy food command.
     */
    public void handleAddFoodCommand(int xPos, int yPos) {
        if (Aquarium.money >= FOODPRICE) {
            foodController.addNewEntity(xPos, yPos);
            Aquarium.money -= FOODPRICE;
        }
    }

    /**
     * Handle add coin command.
     */
    public void handleAddCoinCommand(int xPos, int yPos, int spawnedCoinValue) {
        coinController.addNewEntity(xPos, yPos, spawnedCoinValue);
    }

    /**
     * Handle buy egg command.
     */
    public void handleBuyEggCommand(){
         if(Aquarium.money>=EGGPRICE) {
             Aquarium.money -= EGGPRICE;
             Aquarium.egg++;
         }
    }

    /**
     * Gets the fishes.
     *
     * @return the fishes
     */
    // TODO these below, along with the whole design of GuiController seems like a bad choice
    public List<Guppy> getFishes() {
        return guppyController.getGuppies();
    }

    /**
     * Gets the foods.
     *
     * @return the foods
     */
    public List<Food> getFoods() {
        return foodController.getFoods();
    }

    /**
     * Gets the coins.
     *
     * @return the coins
     */
    public List<Coin> getCoins() {
        return coinController.getCoins();
    }

    /**
     * Gets the snails.
     *
     * @return the snails
     */
    public List<Snail> getSnails() {
        return snailController.getSnails();
    }
}
