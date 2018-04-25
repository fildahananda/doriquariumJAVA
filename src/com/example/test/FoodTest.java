package com.example.test;

import com.example.model.Food;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodTest {

    Food food = new Food(0, 20);

    @Test
    public void isOnRemoval() {
        assertFalse(food.isOnRemoval());
    }

    @Test
    public void hasBeenEaten() {
        food.hasBeenEaten();
        assertTrue(food.isOnRemoval());
    }
}