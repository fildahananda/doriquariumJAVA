package com.example.test;

import com.example.model.Coin;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinTest {

    Coin coin = new Coin(0, 0, 10);

    @Test
    public void getCoinValue() throws Exception {
        assertEquals(10, coin.getCoinValue());
    }

    @Test
    public void setCoinValue() throws Exception {
        coin.setCoinValue(20);
        assertEquals(20, coin.getCoinValue());
    }

    @Test
    public void isOnRemoval() throws Exception {
        assertFalse(coin.isOnRemoval());
    }

    @Test
    public void hasBeenEaten() throws Exception {
        coin.hasBeenEaten();
        assertTrue(coin.isOnRemoval());
    }

}