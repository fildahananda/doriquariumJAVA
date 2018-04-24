package com.example.view;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.model.Aquarium;
import com.example.model.Fish;

// TODO: Auto-generated Javadoc
/**
 * The Class StatusPanelView.
 */
public class StatusPanelView extends JPanel {

    /** The money status. */
    private JLabel moneyStatus;

    /** The fish number status. */
    private JLabel eggNumberStatus;

    public StatusPanelView() {
        add(new JLabel("money : "));
        moneyStatus = new JLabel(Integer.toString(Aquarium.money));
        add(moneyStatus);
        add(new JLabel("egg : "));
        eggNumberStatus = new JLabel(Integer.toString(Aquarium.egg));
        add(eggNumberStatus);
    }

    @Override
    protected void paintComponent(Graphics g) {
        moneyStatus.setText(Integer.toString(Aquarium.money));
        eggNumberStatus.setText(Integer.toString(Aquarium.egg));
        super.paintComponent(g);
    }
}

