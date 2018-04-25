package com.example.controller;

import com.example.model.*;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractionController.
 */
public class InteractionController implements ISubController {

    /** The guppies. */
    private List<Guppy> guppies;

    /** The piranhas. */
    private List<Piranha> piranhas;

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
     * @param guppyController the fish controller
     * @param foodController the food controller
     * @param coinController the coin controller
     * @param snailController the snail controller
     * @param piranhaController the piranha controller
     * @param gameRuleController the game rule controller
     */
    public InteractionController(GuppyController guppyController, PiranhaController piranhaController, FoodController foodController, CoinController coinController, SnailController snailController, GameRuleController gameRuleController) {
        guppies = guppyController.getGuppies();
        piranhas = piranhaController.getPiranhas();
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
        for (Guppy guppy : guppies) {
            guppy.setTargetFood(GetClosestFoodFrom(guppy));
            for (Food food : foods) {
                boolean eatingStatus = (Entity.calcDistBetween(guppy, food) < 10);
                if (eatingStatus && guppy.isHungry()) {
                    guppy.hasEaten();
                    food.hasBeenEaten();
                    break;
                }
            }
            boolean isSpawningCoin = guppy.isSpawningCoin();
            if (isSpawningCoin) {
                gameRuleController.handleAddCoinCommand(guppy.getPosition().getX(), guppy.getPosition().getY(), guppy.getSpawnedCoinValue());
                guppy.hasSpawnedCoin();
            }
        }

        for (Piranha piranha : piranhas) {
            piranha.setTargetGuppy(GetClosestFoodFrom(piranha));
            for (Guppy guppy : guppies) {
                boolean eatingStatus = (Entity.calcDistBetween(piranha, guppy) < 10);
                if (eatingStatus && piranha.isHungry()) {
                    piranha.hasEaten();
                    gameRuleController.handleAddCoinCommand(piranha.getPosition().getX(), piranha.getPosition().getY(), 200 * (guppy.getState() + 1));
                    guppy.hasBeenEaten();
                    break;
                }
            }
        }

        for (Snail snail : snails) {
            snail.setTargetCoin(GetClosestCoinFrom(snail));
            for (Coin coin : coins) {
                boolean eatingStatus = (Entity.calcDistBetween(snail, coin) < 30);
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
     * @param guppy the guppy
     * @return the food
     */
    private Food GetClosestFoodFrom(Guppy guppy) {
        if (foods.isEmpty()) {
            return null;
        }
        Food closestFood = null;
        for (Food checkingFood : foods) {
            if (closestFood == null) {
                closestFood = checkingFood;
            } else if (Entity.calcDistBetween(closestFood, guppy) > Entity
                    .calcDistBetween(checkingFood, guppy)) {
                closestFood = checkingFood;
            }
        }
        return closestFood;
    }

    /**
     * Gets the closest guppy from.
     *
     * @param piranha the piranha
     * @return the guppy
     */
    private Guppy GetClosestFoodFrom(Piranha piranha) {
        if (guppies.isEmpty()) {
            return null;
        }
        Guppy closestGuppy = null;
        for (Guppy checkingGuppy : guppies) {
            if (closestGuppy == null) {
                closestGuppy = checkingGuppy;
            } else if (Entity.calcDistBetween(closestGuppy, piranha) > Entity
                    .calcDistBetween(checkingGuppy, piranha)) {
                closestGuppy = checkingGuppy;
            }
        }
        return closestGuppy;
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

