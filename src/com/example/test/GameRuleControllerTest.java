package com.example.test;

import com.example.controller.*;
import org.junit.Test;

public class GameRuleControllerTest {

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

    /** The test. */
    GameRuleController tes = new GameRuleController(guppyController, piranhaController, foodController, coinController, snailController);

    /**
     * Test GameRuleController.
     */
    @Test
    public void testGameRuleController() {
      /*List<Snail> snailList = new ArrayList<>();
      assertEquals(snailList, tes.getSnails());

      List<Coin> coinList = new ArrayList<>();
      assertEquals(coinList, tes.getCoins());

      List<Food> foodList = new ArrayList<>();
      assertEquals(foodList, tes.getFoods());

      List<Piranha> piranhaList = new ArrayList<>();
      assertEquals(piranhaList, tes.getPiranhas());

      List<Guppy> guppyList = new ArrayList<>();
      assertEquals(guppyList, tes.getGuppies());*/
    }
}