package com.example.controller;

import java.util.List;

import com.example.model.Aquarium;
import com.example.model.Fish;
import com.example.model.Food;
import com.example.model.Coin;
import com.example.model.MovingObject;

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

    /** The game rule controller. */

    private GameRuleController gameRuleController;

    /**
     * Instantiates a new interaction controller.
     *
     * @param fishController the fish controller
     * @param foodController the food controller
     * @param coinController the coin controller
     */
    public InteractionController(FishController fishController, FoodController foodController, CoinController coinController, GameRuleController gameRuleController) {
        fishes = fishController.getFishes();
        foods = foodController.getFoods();
        coins = coinController.getCoins();
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
                boolean eatingStatus = (MovingObject.calcDistBetween(fish, food) < 10);
                if (eatingStatus && fish.isHungry()) {
                    fish.hasEaten();
                    food.hasBeenEaten();
                    break;
                }
            }
            boolean isSpawningCoin = fish.isSpawningCoin();
            if (isSpawningCoin) {
                gameRuleController.handleAddCoinCommand(fish.getX(), fish.getY(), fish.getSpawndCoinValue());
                fish.hasSpawnedCoin();
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
            } else if (MovingObject.calcDistBetween(closestFood, fish) > MovingObject
                    .calcDistBetween(checkingFood, fish)) {
                closestFood = checkingFood;
            }
        }
        return closestFood;
    }
}

