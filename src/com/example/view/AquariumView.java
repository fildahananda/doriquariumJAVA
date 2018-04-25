package com.example.view;

import com.example.model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class AquariumView.
 */
public class AquariumView extends JPanel {
    private List<Guppy> guppies;
    private List<Food> foods;
    private List<Coin> coins;
    private List<Snail> snails;
    private ArrayList<Graphics2D> arrayG;
    private BufferedImage imgBG = null;
    private BufferedImage imgFood = null;
    private BufferedImage imgCoin = null;
    private BufferedImage imgSnail = null;
    private BufferedImage imgSnail_left = null;
    private BufferedImage imgSnail_right = null;
    private BufferedImage imgFish = null;
    private BufferedImage imgFish1 = null;
    private BufferedImage imgFish1_R = null;
    private BufferedImage imgFish2 = null;
    private BufferedImage imgFish2_R = null;
    private BufferedImage imgFish3 = null;
    private BufferedImage imgFish3_R = null;
    private BufferedImage imgFish4 = null;
    private BufferedImage imgFish4_R = null;
    private ArrayList<BufferedImage> bgImg = new ArrayList<BufferedImage>();

    /**
     * Initialize background image.
     *
     * @param bgImg the list of background images
     */
    public void backgroundImageInit(ArrayList<BufferedImage> bgImg) {
        try {
            bgImg.add(ImageIO.read(new File("./res/img/background.jpg")));
            bgImg.add(ImageIO.read(new File("./res/img/win.png")));
            bgImg.add(ImageIO.read(new File("./res/img/lose.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Draw background image.
     *
     * @param g the 2D graphics
     */
    public void backgroundImageDraw(Graphics g) {
        Graphics2D tempG = (Graphics2D) g;
        tempG.drawImage(bgImg.get(0), 0, 5, null);

        if((Aquarium.egg<3)&&(Aquarium.money>0)) {
            arrayG = new ArrayList<Graphics2D>();
            for (int i = 0; i < foods.size(); i++) {
                arrayG.add((Graphics2D) g);
                arrayG.get(i).drawImage(imgFood, foods.get(i).getPosition().getX(), foods.get(i).getPosition().getY(), null);
            }
            for (int i = 0; i < coins.size(); i++) {
                arrayG.add((Graphics2D) g);
                arrayG.get(i).drawImage(imgCoin, coins.get(i).getPosition().getX(), coins.get(i).getPosition().getY(), null);
            }
            for (int i = 0; i < snails.size(); i++) {
                arrayG.add((Graphics2D) g);
                if (snails.get(i).isFacingRight())
                    imgSnail = imgSnail_right;
                else
                    imgSnail = imgSnail_left;
                arrayG.get(i).drawImage(imgSnail, snails.get(i).getPosition().getX(), snails.get(i).getPosition().getY(), null);
            }
            for (int i = 0; i < guppies.size(); i++) {
                arrayG.add((Graphics2D) g);
                if ((guppies.get(i).getState() == 1)&&(guppies.get(i).isFacingRight()))
                    imgFish = imgFish1;
                else if ((guppies.get(i).getState() == 1)&&(!guppies.get(i).isFacingRight()))
                    imgFish = imgFish1_R;
                else if ((guppies.get(i).getState() == 2)&&(guppies.get(i).isFacingRight()))
                    imgFish = imgFish2;
                else if ((guppies.get(i).getState() == 2)&&(!guppies.get(i).isFacingRight()))
                    imgFish = imgFish2_R;
                else if ((guppies.get(i).getState() == 3)&&(guppies.get(i).isFacingRight()))
                    imgFish = imgFish3;
                else if ((guppies.get(i).getState() == 3)&&(!guppies.get(i).isFacingRight()))
                    imgFish = imgFish3_R;
                arrayG.get(i).drawImage(imgFish, guppies.get(i).getPosition().getX(), guppies.get(i).getPosition().getY(), null);
            }

        }else if(Aquarium.egg>=3){
            tempG.drawImage(bgImg.get(1), 70, 100, null);
        }else if(Aquarium.money<=0){
            tempG.drawImage(bgImg.get(2), 75, 100, null);
        }
    }

    /**
     * Instantiates a new aquarium view.
     *
     * @param guppies the fish
     * @param foods the food
     * @param coins the coin
     * @param snails the snail
     */
    public AquariumView(List<Guppy> guppies, List<Food> foods, List<Coin> coins, List<Snail> snails) {
        this.guppies = guppies;
        this.foods = foods;
        this.coins = coins;
        this.snails = snails;

        try {
            imgFood = ImageIO.read(new File("./res/img/food.png"));
            imgCoin = ImageIO.read(new File("./res/img/coin.png"));
            imgSnail_left = ImageIO.read(new File("./res/img/snail.png"));
            imgSnail_right = ImageIO.read(new File("./res/img/snail_R.png"));
            imgFish1 = ImageIO.read(new File("./res/img/guppy_1.png"));
            imgFish2 = ImageIO.read(new File("./res/img/guppy_2.png"));
            imgFish3 = ImageIO.read(new File("./res/img/guppy_3.png"));
            imgFish4 = ImageIO.read(new File("./res/img/piranha.png"));
            imgFish1_R = ImageIO.read(new File("./res/img/guppy_1R.png"));
            imgFish2_R = ImageIO.read(new File("./res/img/guppy_2R.png"));
            imgFish3_R = ImageIO.read(new File("./res/img/guppy_3R.png"));
            imgFish4_R = ImageIO.read(new File("./res/img/piranha_R.png"));

            backgroundImageInit(bgImg);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(Aquarium.WIDTH, Aquarium.HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgBG, 0, 0, null);

        backgroundImageDraw(g);
    }
}

