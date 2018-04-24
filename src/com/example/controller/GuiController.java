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

    /** The add fish button. */
    private JButton buyFishButton;

    /** The pause button. */
    private JButton buyEggButton;

    private WinDialog winDialog;


    /** The game rule controller. */

    private GameRuleController gameRuleController;

    private class WinDialog extends JDialog implements ActionListener {
        public WinDialog(JFrame frame, String string, boolean b) {
            super(frame, string, b);
            setResizable(false);
            getContentPane().add(createRootPane());
            setVisible(false);
            setLocation(this.getParent().getWidth() / 3, this.getParent().getHeight() / 5);
        }

        public void invoke() {
            JPanel winPanel = new JPanel();
            winPanel.setLayout(new BorderLayout());
            winPanel.add(new JLabel("You Win!"), BorderLayout.CENTER);

            JButton finishButton = new JButton("Okay");
            finishButton.addActionListener(winDialog);
            winPanel.add(finishButton, BorderLayout.PAGE_END);
            winDialog.getContentPane().add(winPanel);
            winDialog.setSize(this.getParent().getWidth() / 2, this.getParent().getHeight() / 6);
            winDialog.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calculateReturnMessage();
            winDialog.setVisible(false);
        }

        private void calculateReturnMessage() {

        }

        public List<Fish> getReturnMessage() {
            return gameRuleController.getFishes();

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

        statusPanel = new StatusPanelView();

        winDialog = new WinDialog(this, "Win", true);

        setLayout(new BorderLayout());
        add(aquariumPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.PAGE_END);
        add(statusPanel, BorderLayout.PAGE_START);


        setVisible(true);
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
        }
    }
}

