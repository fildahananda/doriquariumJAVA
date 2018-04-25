package com.example.controller;

import java.util.List;

import com.example.model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class GameRuleController.
 */
public class GameRuleController implements ISubController {

    /** The Constant GUPPYPRICE. */
    private static final int GUPPYPRICE = 200;

    /** The Constant PIRANHAPRICE. */
    private static final int PIRANHAPRICE = 300;

    /** The Constant FOODPRICE. */
    private static final int FOODPRICE = 20;

    /** The Constant EGGPRICE. */
    private static final int EGGPRICE = 1000;

    /** The guppy controller. */
    GuppyController guppyController;

    /** The piranha controller. */
    PiranhaController piranhaController;

    /** The food controller. */
    FoodController foodController;

    /** The coin controller. */
    CoinController coinController;

    /** The snail controller. */
    SnailController snailController;

    /**
     * Instantiates a new game rule controller.
     *
     * @param guppyController the guppy controller
     * @param piranhaController the piranha controller
     * @param foodController the food controller
     * @param coinController the coin controller
     * @param snailController the snail controller
     */
    public GameRuleController(GuppyController guppyController, PiranhaController piranhaController, FoodController foodController, CoinController coinController, SnailController snailController) {
        this.guppyController = guppyController;
        this.piranhaController = piranhaController;
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
     * Handle buy guppy command.
     */
    public void handleBuyGuppyCommand() {
        if (Aquarium.money >= GUPPYPRICE) {
            guppyController.addNewEntity();
            Aquarium.money -= GUPPYPRICE;
        }
    }

    /**
     * Handle buy piranha command.
     */
    public void handleBuyPiranhaCommand() {
        if (Aquarium.money >= PIRANHAPRICE) {
            piranhaController.addNewEntity();
            Aquarium.money -= PIRANHAPRICE;
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
         if(Aquarium.money >= EGGPRICE) {
             Aquarium.money -= EGGPRICE;
             Aquarium.egg++;
         }
    }

    /**
     * Gets the guppies.
     *
     * @return the guppies
     */
    // TODO these below, along with the whole design of GuiController seems like a bad choice
    public List<Guppy> getGuppies() {
        return guppyController.getGuppies();
    }

    /**
     * Gets the piranhas.
     *
     * @return the piranhas
     */
    public List<Piranha> getPiranhas() {
        return piranhaController.getPiranhas();
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
