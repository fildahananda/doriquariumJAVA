package com.example.test;

import com.example.controller.CoinController;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinControllerTest {

    CoinController coinController = new CoinController();

    @Test
    public void getCoins() throws Exception {
        assertEquals(0, coinController.getCoins().size());
    }

    @Test
    public void addNewEntity() throws Exception {
        coinController.addNewEntity(0, 0, 10);
        assertEquals(1, coinController.getCoins().size());
    }

}