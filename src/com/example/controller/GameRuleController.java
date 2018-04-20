package com.example.controller;

import java.util.List;

import com.example.model.Aquarium;
import com.example.model.Coin;
import com.example.model.Fish;
import com.example.model.Food;

// TODO: Auto-generated Javadoc
/**
 * The Class GameRuleController.
 */
public class GameRuleController implements ISubController {

    /** The Constant FISHPRICE. */
    private static final int FISHPRICE = 200;

    /** The Constant FOODPRICE. */
    private static final int FOODPRICE = 20;

    /** The fish controller. */
    FishController fishController;

    /** The food controller. */
    FoodController foodController;

    /** The coin controller. */
    CoinController coinController;

    /**
     * Instantiates a new game rule controller.
     *
     * @param fishController the fish controller
     * @param foodController the food controller
     */
    public GameRuleController(FishController fishController, FoodController foodController, CoinController coinController) {
        this.fishController = fishController;
        this.foodController = foodController;
        this.coinController = coinController;
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
     * Handle add fish command.
     */
    public void handleAddFishCommand() {
        if (Aquarium.money > FISHPRICE) {
            fishController.addNewEntity();
            Aquarium.money -= FISHPRICE;
        }
    }

    /**
     * Handle add food command.
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

    public void handleSellFishCommand(List<Fish> toSell) {
        for (Fish fish : toSell) {
            fish.hasBeenSold();
            Aquarium.money += fish.value();
        }
    }

    /**
     * Gets the fishes.
     *
     * @return the fishes
     */
    // TODO these below, along with the whole design of GuiController seems like a bad choice
    public List<Fish> getFishes() {
        return fishController.getFishes();
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
}
