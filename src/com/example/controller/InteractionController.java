package com.example.controller;

import java.util.List;

import com.example.model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractionController.
 */
public class InteractionController implements ISubController {

    /** The fishes. */
    private List<Fish> fishes;

    /** The foods. */
    private List<Food> foods;

    /** The coins. */
    private List<Coin> coins;

    /** The snails. */
    private List<Snail> snails;

    /** The game rule controller. */

    private GameRuleController gameRuleController;

    /**
     * Instantiates a new interaction controller.
     *
     * @param fishController the fish controller
     * @param foodController the food controller
     * @param coinController the coin controller
     * @param snailController the snail controller
     */
    public InteractionController(FishController fishController, FoodController foodController, CoinController coinController, SnailController snailController, GameRuleController gameRuleController) {
        fishes = fishController.getFishes();
        foods = foodController.getFoods();
        coins = coinController.getCoins();
        snails = snailController.getSnails();
        this.gameRuleController = gameRuleController;
    }

    /*
     * (non-Javadoc)
     *
     * @see controllers.ISubController#perform()
     */
    @Override
    public void perform() {
        for (Fish fish : fishes) {
            fish.setTargetFood(GetClosestFoodFrom(fish));
            for (Food food : foods) {
                boolean eatingStatus = (Entity.calcDistBetween(fish, food) < 10);
                if (eatingStatus && fish.isHungry()) {
                    fish.hasEaten();
                    food.hasBeenEaten();
                    break;
                }
            }
            boolean isSpawningCoin = fish.isSpawningCoin();
            if (isSpawningCoin) {
                gameRuleController.handleAddCoinCommand(fish.getX(), fish.getY(), fish.getSpawnedCoinValue());
                fish.hasSpawnedCoin();
            }
        }

        for (Snail snail : snails) {
            snail.setTargetCoin(GetClosestCoinFrom(snail));
            for (Coin coin : coins) {
                boolean eatingStatus = (Entity.calcDistBetween(snail, coin) < 40);
                if (eatingStatus) {
                    snail.hasEaten();
                    coin.hasBeenEaten();
                    break;
                }
            }
        }
    }

    /**
     * Gets the closest food from.
     *
     * @param fish the fish
     * @return the food
     */
    private Food GetClosestFoodFrom(Fish fish) {
        if (foods.isEmpty()) {
            return null;
        }
        Food closestFood = null;
        for (Food checkingFood : foods) {
            if (closestFood == null) {
                closestFood = checkingFood;
            } else if (Entity.calcDistBetween(closestFood, fish) > Entity
                    .calcDistBetween(checkingFood, fish)) {
                closestFood = checkingFood;
            }
        }
        return closestFood;
    }

    /**
     * Gets the closest coin from.
     *
     * @param snail the snail
     * @return the coin
     */
    private Coin GetClosestCoinFrom(Snail snail) {
        if (coins.isEmpty()) {
            return null;
        }
        Coin closestCoin = null;
        for (Coin checkingCoin : coins) {
            if (closestCoin == null) {
                closestCoin = checkingCoin;
            } else if (Entity.calcDistBetween(closestCoin, snail) > Entity
                    .calcDistBetween(checkingCoin, snail)) {
                closestCoin = checkingCoin;
            }
        }
        return closestCoin;
    }
}

