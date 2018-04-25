package com.example.test;

import com.example.controller.FoodController;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodControllerTest {

    FoodController foodController = new FoodController();

    @Test
    public void getFoods() {
        assertEquals(0, foodController.getFoods().size());
    }

    @Test
    public void perform() {
        foodController.addNewEntity(0, 0);
        foodController.getFoods().get(0).hasBeenEaten();


    }

    @Test
    public void addNewEntity() {
        foodController.addNewEntity(0, 0);
        assertEquals(1, foodController.getFoods().size());
    }
}