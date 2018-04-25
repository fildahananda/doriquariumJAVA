package com.example.test;

import com.example.model.Coin;
import com.example.model.Snail;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnailTest {

    Snail snail = new Snail();

    @Test
    public void setTargetCoin() {
        Coin coin = new Coin(10, 0, 0);
        snail.setTargetCoin(coin);
        assertSame(coin, snail.getTargetCoin());
    }

    @Test
    public void isFacingRight() {
        assertTrue(snail.isFacingRight());
    }

    @Test
    public void isOnRemoval() {
        assertFalse(snail.isOnRemoval());
    }
}