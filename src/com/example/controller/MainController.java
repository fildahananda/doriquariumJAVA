package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


// TODO: Auto-generated Javadoc
/**
 * The Class MainController.
 */
public class MainController {

    /** The guppy controller. */
    // controller to control
    private static GuppyController guppyController;

    /** The piranha controller. */
    // controller to control
    private static PiranhaController piranhaController;

    /** The food controller. */
    private static FoodController foodController;

    /** The coin controller. */
    private static CoinController coinController;

    /** The snail controller. */
    private static SnailController snailController;

    /** The interaction controller. */
    private static InteractionController interactionController;

    /** The game loop controller. */
    private static GameLoopController gameLoopController;

    /** The game rule controller. */
    private static GameRuleController gameRuleController;

    /**
     * Instantiates a new main controller.
     */
    public MainController() {
        initializeControllers();
        initializeGui();
        runGameLoop();
    }

    /**
     * Initialize controllers.
     */
    private void initializeControllers() {
        guppyController = new GuppyController();
        guppyController.addNewEntity();
        piranhaController = new PiranhaController();
        piranhaController.addNewEntity();
        foodController = new FoodController();
        coinController = new CoinController();
        snailController = new SnailController();
        snailController.addNewEntity();
        gameRuleController = new GameRuleController(guppyController, piranhaController, foodController, coinController, snailController);
        interactionController = new InteractionController(guppyController, piranhaController, foodController, coinController, snailController, gameRuleController);
    }

    /**
     * Initialize gui.
     */
    private void initializeGui() {
        // Initialize();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new GuiController(gameRuleController);
            }
        });
    }

    /**
     * Run game loop.
     */
    private void runGameLoop() {
        List<ISubController> subControllers = new ArrayList<ISubController>();
        subControllers.add(guppyController);
        subControllers.add(piranhaController);
        subControllers.add(foodController);
        subControllers.add(coinController);
        subControllers.add(snailController);
        subControllers.add(interactionController);
        subControllers.add(gameRuleController);
        gameLoopController = new GameLoopController(subControllers);
        gameLoopController.execute();
    }
}

