package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.model.Aquarium;
import com.example.model.Coin;

// TODO: Auto-generated Javadoc
/**
 * The Class CoinController.
 */
public class CoinController implements ISubController {

    /** The coins. */
    private List<Coin> coins;

    /** The to remove. */
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
            if (!(coin.getPosition().getY() > Aquarium.HEIGHT + 50)) {
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
     */
    public void addNewEntity(int xPos, int yPos, int coinValue) {
        Coin newCoin = new Coin(xPos, yPos, coinValue);
        coins.add(newCoin);
    }
}

