package com.example.controller;

// TODO remove this ugliness
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.model.Aquarium;
import com.example.model.Fish;
import com.example.view.AquariumView;
import com.example.view.StatusPanelView;

// TODO: Auto-generated Javadoc
/**
 * The Class GuiController.
 */
public class GuiController extends JFrame implements ActionListener {

    /** The app width. */
    private int appWidth;

    /** The app height. */
    private int appHeight;

    /** The aquarium panel. */
    private static JPanel aquariumPanel;

    /** The control panel. */
    private static JPanel controlPanel;

    /** The status panel. */
    private static JPanel statusPanel;

    /** The buy fish button. */
    private JButton buyFishButton;

    /** The buy egg button. */
    private JButton buyEggButton;

    /** The help button. */
    private JButton controlButton;

    /** The game control dialog. */
    private GameControlDialog gameControlDialog;

    /** The game rule controller. */
    private GameRuleController gameRuleController;

    private class GameControlDialog extends JDialog implements ActionListener {
        public GameControlDialog(JFrame frame, String string, boolean b) {
            super(frame, string, b);
            setResizable(false);
            getContentPane().add(createRootPane());
            setVisible(false);
            setLocation(this.getParent().getWidth() / 4, this.getParent().getHeight() / 5);
        }

        public void invoke() {
            JPanel initPanel = new JPanel();
            initPanel.setLayout(new BorderLayout());
            initPanel.add(new JLabel("Click on the screen to buy food"), BorderLayout.CENTER);

            JButton finishButton = new JButton("Start");
            finishButton.addActionListener(gameControlDialog);
            initPanel.add(finishButton, BorderLayout.PAGE_END);
            gameControlDialog.getContentPane().add(initPanel);
            gameControlDialog.setSize(this.getParent().getWidth() / 2, this.getParent().getHeight() / 6);
            gameControlDialog.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            gameControlDialog.setVisible(false);
        }
    }

    /**
     * Instantiates a new gui controller.
     *
     * @param gameRuleController the game rule controller
     */
    public GuiController(GameRuleController gameRuleController) {
        appWidth = Aquarium.WIDTH;
        appHeight = Aquarium.HEIGHT + 100;
        setSize(appWidth, appHeight);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.gameRuleController = gameRuleController;
        aquariumPanel = new AquariumView(gameRuleController.getFishes(), gameRuleController.getFoods(), gameRuleController.getCoins(), gameRuleController.getSnails());
        aquariumPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                gameRuleController.handleAddFoodCommand(e.getX(), e.getY());
            }
        });

        controlPanel = new JPanel();
        buyFishButton = new JButton("buy fish");
        addButtonToControlPanel(buyFishButton, "Buy Fish");
        buyEggButton = new JButton("buy egg");
        addButtonToControlPanel(buyEggButton, "Buy Egg");
        controlButton = new JButton("control");
        addButtonToControlPanel(controlButton, "Help");

        statusPanel = new StatusPanelView();

        gameControlDialog= new GameControlDialog(this, "Control", true);

        setLayout(new BorderLayout());
        add(aquariumPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.PAGE_END);
        add(statusPanel, BorderLayout.PAGE_START);
        
        setVisible(true);
        gameControlDialog.invoke();
    }

    /**
     * Adds the button to control panel.
     *
     * @param button the button
     * @param label the label
     */
    private void addButtonToControlPanel(JButton button, String label) {
        button.setActionCommand(button.getText());
        button.setText(label);
        button.addActionListener(this);
        controlPanel.add(button);
    }

    /**
     * Static repaint.
     */
    public static void staticRepaint() {
        aquariumPanel.repaint();
        statusPanel.repaint();
    }

    /*
     * action handler from GUI
     *
     * @param e ActionEvent action listener param
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "buy egg") {
            gameRuleController.handleBuyEggCommand();
        } else if (e.getActionCommand() == "buy fish") {
            gameRuleController.handleBuyFishCommand();
        } else if (e.getActionCommand() == "control") {
            GameLoopController.togglePause();

            gameControlDialog.invoke();
            //gameRuleController.handleSellFishCommand(sellDialog.getReturnMessage());

            GameLoopController.togglePause();
        }
    }
}

