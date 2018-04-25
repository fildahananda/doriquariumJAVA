package com.example.test;

import com.example.controller.*;
import com.example.model.Food;
import com.example.model.Guppy;
import com.example.model.Piranha;
import com.example.model.Snail;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameRuleControllerTest {

    /** The guppy controller. */
    GuppyController guppyController = new GuppyController();

    /** The piranha controller. */
    PiranhaController piranhaController = new PiranhaController();

    /** The food controller. */
    FoodController foodController = new FoodController();

    /** The coin controller. */
    CoinController coinController = new CoinController();

    /** The snail controller. */
    SnailController snailController = new SnailController();

    /** The test. */
    GameRuleController tes = new GameRuleController(guppyController, piranhaController, foodController, coinController, snailController);

    /**
     * Test GameRuleController.
     */
    @Test
    public void testGameRuleController() {
      List<Snail> snailList = new ArrayList<>();
      assertEquals(snailList, tes.getSnails());

      CoinController c = new CoinController();
      assertEquals(c.getCoins(), tes.getCoins());

      List<Food> foodList = new ArrayList<>();
      assertEquals(foodList, tes.getFoods());

      List<Piranha> piranhaList = new ArrayList<>();
      assertEquals(piranhaList, tes.getPiranhas());

      List<Guppy> guppyList = new ArrayList<>();
      assertEquals(guppyList, tes.getGuppies());
    }
}