package com.example.controller;

import com.example.model.Aquarium;
import com.example.model.Coin;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CoinController.
 */
public class CoinController implements ISubController {

    /** The list of coins. */
    private List<Coin> coins;

    /** The list of coins to remove. */
    private List<Coin> toRemove;

    /**
     * Instantiates a new coin controller.
     */
    public CoinController() {
        coins = new ArrayList<>();
        toRemove = new ArrayList<>();
    }

    /**
     * Gets the coins.
     *
     * @return the coins
     */
    public List<Coin> getCoins() {
        return coins;
    }

    /*
     * (non-Javadoc)
     *
     * @see controllers.ISubController#perform()
     */
    @Override
    public void perform() {
        removeObsoleteCoins();
        for (Coin coin : coins) {
            if (!(coin.getPosition().getY() > Aquarium.HEIGHT - 30)) {
                coin.move();
            }
        }
    }

    /**
     * Removes the obsolete coins.
     */
    private void removeObsoleteCoins() {
        for (Coin coin : coins) {
            if (coin.isOnRemoval()) {
                toRemove.add(coin);
            }
        }
        if (!toRemove.isEmpty()) {
            for (Coin coin : toRemove) {
                coins.remove(coin);
            }
        }
        toRemove.clear();
    }

    /**
     * Adds the new entity.
     *
     * @param xPos the x
     * @param yPos the y
     * @param coinValue the value of the coin
     */
    public void addNewEntity(int xPos, int yPos, int coinValue) {
        Coin newCoin = new Coin(xPos, yPos, coinValue);
        coins.add(newCoin);
    }
}

