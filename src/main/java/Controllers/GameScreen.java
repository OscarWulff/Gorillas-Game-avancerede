package Controllers;


import ApplicationClasses.*;
import ApplicationClasses.Biomes.Jungle.*;
import ApplicationClasses.Biomes.FoodCourt.*;
import ApplicationClasses.Biomes.City.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.Random;

import java.io.IOException;
import java.util.*;


public class GameScreen {
    private static Game game;
    @FXML
    public Button btnBack; public TextField pl1ang; public TextField pl1vec;
    public TextField pl2ang; public TextField pl2vec; public ImageView bananaImg;
    public Label pl2AngLabel; public Label pl2VelLabel; public Label pl1AngLabel;
    public Label pl1VelLabel; public Label nameLabel1; public Label nameLabel2;
    public Button pl1start; public Button pl2start;
    public Label pl2NameLabel; public Label pl1NameLabel; public Label whoWantsLabel;
    public Button throwButton;
    public ImageView monkeyOneImg; public ImageView monkeyTwoImg;
    public Label score1; public Label score2;
    public ImageView poof1;
    public ImageView poof2;
    public ImageView explosion;
    public ImageView barLeft; public ImageView barLower;
    public ImageView barUpper; public ImageView barRight;

    public ImageView health100_pl1; public ImageView health100_pl2; public ImageView health75_pl1; public ImageView health50_pl1; public ImageView health25_pl1;
    public ImageView health0_pl1; public ImageView health75_pl2; public ImageView health50_pl2; public ImageView health25_pl2; public ImageView health0_pl2;

    public ImageView Tre1; public ImageView Tre2; public ImageView Tre3; public ImageView Tre4;
    public ImageView Tre5; public ImageView Tre6; public ImageView Tre7; public ImageView Tre8;

    public ImageView building1; public ImageView building2; public ImageView building3; public ImageView building4;
    public ImageView building5; public ImageView building6; public ImageView building7; public ImageView building8;

    public ImageView food1; public ImageView food2; public ImageView food3; public ImageView food4;
    public ImageView food5; public ImageView food6; public ImageView food7; public ImageView food8;

    public Label luftLabel;
    public Label minutes;
    public Label seconds;
    public ImageView pauseButton; public ImageView playButton;

    private Player player1; private Player player2;
    private World world;
    private Jungle jungle;
    private City city;
    private FoodCourt foodCourt;
    private ArrayList<Tree> trees;
    private ArrayList<Building> buildings;
    private Map<String, Food> food;

    public boolean canHitGrid_world[][];
    public boolean canHitGrid_jungle[][];
    public boolean canHitGrid_city[][];
    public boolean canHitGrid_foodCourt[][];

    private int playerOneAngle; private int playerOneVelocity;
    private int playerTwoAngle; private int playerTwoVelocity;

    private List<Integer> list = new ArrayList<>();
    private int[] bananaArr;
    private int point1 = 0;
    private int point2 = 0;
    private Monkey monkey1;
    private Monkey monkey2;

    private boolean flag;
    private int pl1_hits = 0;
    private int pl2_hits = 0;
    private static int airResistance;
    public Timer timer;
    public TimeAdder timeAdder;
    public boolean stop = false;
    private int fluctuatingVelocity;
    private static int savedWind = MainScene.modstand;
    public static final int maxHeight = 1000;
    public static final int maxWidth = 1700;
    public int currentTime;


    public void timer(int time) {
        timer = new Timer();
        timeAdder = new TimeAdder(time);
        timer.schedule(timeAdder, 1000, 1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setTimer();
            }
        }, 1000, 1000);
    }

    public void setTimer() {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                if(timeAdder.getTime() < 10) {
                    seconds.setText(String.valueOf("0" + timeAdder.getTime()));
                } else if(timeAdder.getTime() < 60) {
                    seconds.setText(String.valueOf(timeAdder.getTime()));
                } else {
                    if(timeAdder.getTime()/60 < 10) {
                        minutes.setText(String.valueOf("0" + timeAdder.getTime()/60));
                    } else {
                        minutes.setText(String.valueOf(timeAdder.getTime()/60));
                    }
                    if(timeAdder.getTime()%60 < 10) {
                        seconds.setText(String.valueOf("0" + timeAdder.getTime()%60));
                    } else {
                        seconds.setText(String.valueOf(timeAdder.getTime()%60));
                    }
                }
            }
        });
    }


    public void goToMainScene() throws IOException {
        SceneManager.changeScene("fxml/MainScene.fxml");
    }

    public static void setGame(Game game) {
        GameScreen.game = game;
    }

    public static void setAirresistance(int airResistance){
        GameScreen.airResistance = airResistance;
    }

    /* if this method is called by pressing a button in the gamescreen, player 1 starts */
    public void pl1Start(ActionEvent actionEvent) {
        initGameValues();
        player1.setTurn(true);
        player2.setTurn(false);
        makeBoardVisible();
    }
    /* if this method is called by pressing a button in the gamescreen, player 2 starts */
    public void pl2Start(ActionEvent actionEvent) {
        initGameValues();
        player1.setTurn(false);
        player2.setTurn(true);
        makeBoardVisible();
        MainScene.modstand *= -1;
    }

    /* initGameValues() initializes game values eg. assigning the variables with their desired values  */

    public void initGameValues(){
        direction();
        this.player1 = game.getPlayer1();
        this.player2 = game.getPlayer2();
        this.world = game.getWorld();
        this.monkey1 = world.getMonkey1();
        this.monkey2 = world.getMonkey2();
        this.canHitGrid_world = world.getCantHitGrid();

        poof1.setLayoutX(monkey1.getStart_x() - 50);
        poof1.setLayoutY(monkey1.getStart_y() - 50);

        poof2.setLayoutX(monkey2.getStart_x() - 50);
        poof2.setLayoutY(monkey2.getStart_y() - 50);

        this.jungle = game.getJungle();
        this.trees = jungle.Trees();
        this.canHitGrid_jungle = jungle.getCantHitGrid();
        jungle.hitBoxtrees();


        nameLabel1.setText(player1.getName());
        nameLabel2.setText(player2.getName());
        monkeyOneImg.setLayoutX(monkey1.getStart_x());
        monkeyOneImg.setLayoutY(monkey1.getStart_y());
        monkeyTwoImg.setLayoutX(monkey2.getStart_x());
        monkeyTwoImg.setLayoutY(monkey2.getStart_y());
        barLeft.setLayoutX((int)((maxWidth - world.getWidth()) / 2));
        barLeft.setLayoutY(0);
        barLeft.setFitHeight(world.getHeight());
        barLeft.isSmooth();
        barLower.setLayoutX(monkey1.getStart_x());
        barLower.setLayoutY(1000);
        barLower.setFitWidth(world.getWidth());
        barRight.setLayoutX((int)(maxWidth - ((maxWidth - world.getWidth()) / 2)));
        barRight.setLayoutY(0);
        monkeyOneImg.setVisible(true);
        monkeyTwoImg.setVisible(true);
        Tre1.setVisible(true); Tre2.setVisible(true); Tre3.setVisible(true); Tre4.setVisible(true);
        Tre5.setVisible(true); Tre6.setVisible(true); Tre7.setVisible(true); Tre8.setVisible(true);
        timer(0);
    }

    /* makes all elements of the gamescreen visible. The if/else statement is checking which player goes first,
       and displaying their respectable elements */
    public void makeBoardVisible() {
        luftLabel.setVisible(true);
        whoWantsLabel.setVisible(false);
        pl1start.setVisible(false);
        pl2start.setVisible(false);
        throwButton.setVisible(true);
        pl1NameLabel.setVisible(true);
        pl2NameLabel.setVisible(true);
        nameLabel1.setVisible(true);
        nameLabel2.setVisible(true);
        health100_pl1.setVisible(true);
        health100_pl2.setVisible(true);
        if (player1.getTurn()){
            pl1AngLabel.setVisible(true);
            pl1VelLabel.setVisible(true);
            pl1ang.setVisible(true);
            pl1vec.setVisible(true);
        } else {
            pl2AngLabel.setVisible(true);
            pl2VelLabel.setVisible(true);
            pl2ang.setVisible(true);
            pl2vec.setVisible(true);
        }
    }

    /* this method sets the healthbars to the correct health, eg. which case is being displayed, depending on how many times each monkey
    * has been hit. */
    public void setHeart() {
        if(!player1.getTurn()) {
            pl1_hits++;
            switch (pl1_hits) {
                case 1:
                    health100_pl2.setVisible(false);
                    health75_pl2.setVisible(true);
                    break;
                case 2:
                    health75_pl2.setVisible(false);
                    health50_pl2.setVisible(true);
                    break;
                case 3:
                    health50_pl2.setVisible(false);
                    health25_pl2.setVisible(true);
                    break;
                case 4:
                    health25_pl2.setVisible(false);
                    health0_pl2.setVisible(true);
                    point();
                    simulateSlow(1000);
                    health0_pl2.setVisible(false);
                    health100_pl2.setVisible(true);
                    pl1_hits = 0;
                    break;
            }
        } else if(player1.getTurn()) {
            pl2_hits++;
            switch (pl2_hits) {
                case 1:
                    health100_pl1.setVisible(false);
                    health75_pl1.setVisible(true);
                    break;
                case 2:
                    health75_pl1.setVisible(false);
                    health50_pl1.setVisible(true);
                    break;
                case 3:
                    health50_pl1.setVisible(false);
                    health25_pl1.setVisible(true);
                    break;
                case 4:
                    health25_pl1.setVisible(false);
                    health0_pl1.setVisible(true);
                    point();
                    simulateSlow(1000);
                    health0_pl1.setVisible(false);
                    health100_pl1.setVisible(true);
                    pl2_hits = 0;
                    break;
            }
        }

        /*  */
        if ((point1 == 1 && point2 == 0) || (point1 == 0 && point2 == 1)){
            Tre1.setVisible(false); Tre2.setVisible(false); Tre3.setVisible(false); Tre4.setVisible(false);
            Tre5.setVisible(false); Tre6.setVisible(false); Tre7.setVisible(false); Tre8.setVisible(false);

            building1.setVisible(true); building2.setVisible(true); building3.setVisible(true); building4.setVisible(true);
            building5.setVisible(true); building6.setVisible(true); building7.setVisible(true); building8.setVisible(true);

            this.city = game.getCity();
            this.buildings = city.buildings();
            this.canHitGrid_city = city.getCantHitGrid();
            city.hitBoxbuildings();
        } else if ((point1 == 1 && point2 == 1) || (point1 == 2 && point2 == 0) || (point1 == 0 && point2 == 2)){
            building1.setVisible(false); building2.setVisible(false); building3.setVisible(false); building4.setVisible(false);
            building5.setVisible(false); building6.setVisible(false); building7.setVisible(false); building8.setVisible(false);

            food1.setVisible(true); food2.setVisible(true); food3.setVisible(true); food4.setVisible(true);
            food5.setVisible(true); food6.setVisible(true); food7.setVisible(true); food8.setVisible(true);

            this.foodCourt = game.getfoodCourt();
            this.food = foodCourt.food();
            this.canHitGrid_foodCourt = foodCourt.getCantHitGrid();
            foodCourt.hitBoxFood();
        }
    }

    /* this actionevent executes when the throw button is pressed
     * firstly the randomAdder() generates a random number
     * secondly direction is executed, which displays and arrow and windspeed on the gamescreen.
     * then the banana is set to visible and the throwbutton is set to invisible.
     * The angle and velocity is then assigned to the variables depending on which turn it is.
     * the thread is then run and MainScene.modstand is restored to its original value
     *  */

    public void doThrow(ActionEvent event) throws IOException {
        randomAdder();
        direction();
        bananaImg.setVisible(true);
        throwButton.setVisible(false);
        if (player1.getTurn()) {
            this.playerOneAngle = Integer.parseInt(pl1ang.getText());
            this.playerOneVelocity = Integer.parseInt(pl1vec.getText());
        } else {
            this.playerTwoAngle = Integer.parseInt(pl2ang.getText());
            this.playerTwoVelocity = Integer.parseInt(pl2vec.getText());
        }
        Thread thread = new Thread(this::runThread);
        thread.start();
        MainScene.modstand = savedWind;

    }

    public void runThread() {
        world.hitBox(player1);
        list = new ArrayList<>();
        if (player1.getTurn()) {
            Banana banana = new Banana(playerOneVelocity, 9.82, playerOneAngle);
            list = makeCurve(banana);
            for (int i = 0; i < list.size(); i++) {
                bananaImg.setLayoutY(monkey1.getStart_y() - monkeyOneImg.getFitHeight() - list.get(i));
                bananaImg.setLayoutX(monkey1.getEnd_x() + i);
                explosion.setLayoutX(bananaImg.getLayoutX() - (explosion.getFitWidth()/2));
                explosion.setLayoutY(bananaImg.getLayoutY() - (explosion.getFitHeight()/2));
                bananaImg.isSmooth();
                simulateSlow(-1);
                bananaHit(monkeyTwoImg);
                if(stop) {
                    break;
                }
                while (!pauseButton.isVisible()) {
                }
            }
            simulateSlow(200);
            player1.setTurn(false);

        } else {
            Banana banana = new Banana(playerTwoVelocity, 9.82, playerTwoAngle);
            list = makeCurve(banana);
            for (int i = 0; i < list.size(); i++) {
                bananaImg.setLayoutY(monkey2.getStart_y() - monkeyTwoImg.getFitHeight() - (list.get(i)));
                bananaImg.setLayoutX(monkey2.getStart_x() - i);
                explosion.setLayoutX(bananaImg.getLayoutX() - (explosion.getFitWidth()/2));
                explosion.setLayoutY(bananaImg.getLayoutY() - (explosion.getFitHeight()/2));
                bananaImg.isSmooth();
                simulateSlow(-1);
                bananaHit(monkeyOneImg);
                if(stop) {
                    break;
                }
                while (!pauseButton.isVisible()) {
                }
            }
            simulateSlow(200);
            player1.setTurn(true);
        }
        if(flag) setHeart();
        switchVisibility();
        restart();
        simulateSlow(0);
        bananaImg.setVisible(false);
    }

    /* direction() is used to display the direction of the wind
     * this is done with an if/else if statement if MainScene.modstand
     * is lesser than 0 and luftflag is true then the arrow will turn right, otherwise
     * it will turn left - this all depends on luftflag which is assigned af boolean value in
     * MainScene*/

    public void direction(){
        if (MainScene.modstand < 0 && MainScene.luftFlag){
            luftLabel.setText("\u2192 " + Math.abs(MainScene.modstand) + " m/s");
        } else if(MainScene.luftFlag) {
            luftLabel.setText("\u2190" + Math.abs(MainScene.modstand) + " m/s");
        }
    }

    /* restart() restarts the position of the banana, as well as resetting the
     * visibility of the elements to the original */
    public void restart() {
        if(player1.getTurn()) {
            bananaImg.setLayoutX(monkey1.getEnd_x());
        } else {
            bananaImg.setLayoutX(world.getWidth() - monkeyTwoImg.getFitWidth());
        }
        monkeyOneImg.setVisible(true);
        monkeyTwoImg.setVisible(true);
        poof1.setVisible(false);
        poof2.setVisible(false);
        bananaImg.setVisible(true);
        explosion.setVisible(false);
        throwButton.setVisible(true);
    }

    /* randomAdder() generates a number between -5 and 5 */
    public void randomAdder(){
        Random adder = new Random();
        int spanMax = 5;
        int spanMin = -5;
        this.fluctuatingVelocity = adder.nextInt(spanMax - spanMin) + spanMin;
    }

    /* makecurve generates the values of the curve, so they can be used to update the location of the banana
     * line 390 makes the wind go the correct direction for both players and line 391 makes the wind
     * fluctuate (see RandomAdder() line 381) */

    public List<Integer> makeCurve(Banana banana) {
        MainScene.modstand *= -1;
        MainScene.modstand += fluctuatingVelocity;
        int x = 0;
        while (banana.trajectory(x) > - 1000
                && (x < (monkey2.getStart_x() - monkey1.getStart_x()) + (bananaImg.getFitWidth() / 2))) {
            this.list.add(banana.trajectory(x));
            x++;
        }
        return this.list;
    }

    /* simulateSlow() is a method that can be called for slowing down the code */
    public void simulateSlow(int x) {
        try {
            Thread.sleep(x + 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* the bananaHit method checks if the banana hit a monkey or building/Tree/Food
     * this is done with boolean grids. If the banana hits, the monkey will disappear
     * for a couple of milliseconds and an explosion and a poof will appear instead.
     * This counts for both players, depending on the if/else staments. If none of the
     * statements are true noHit() wil get executed. */

    public void bananaHit(ImageView monkey) {
        explosion.setVisible(false);
        flag = false;
        stop = false;
        STOP:
        for (int j = (int) bananaImg.getLayoutY(); j < (int) bananaImg.getLayoutY() + bananaImg.getFitHeight(); j++) {
            for (int k = (int) bananaImg.getLayoutX(); k < (int) bananaImg.getLayoutX() + bananaImg.getFitWidth(); k++) {
                if (player1.getTurn() && j >= 0 && k >= monkey1.getEnd_x() && j <
                        1000 && k < maxWidth) {
                    if(canHitGrid_world[j][k] || bananaExplosion(j, k) || canHitGrid_jungle[j][k] || FoodCourt.canHitGrid[j][k]) {
                        bananaImg.setVisible(false);
                        explosion.setVisible(true);
                        if (bananaImg.getLayoutX() > monkey2.getStart_x() - bananaImg.getFitWidth() &&
                                bananaImg.getLayoutX() < monkey2.getEnd_x() + bananaImg.getFitWidth() &&
                                bananaImg.getLayoutY() > monkey2.getStart_y() - bananaImg.getFitWidth() &&
                                bananaImg.getLayoutY() < monkey2.getEnd_y() + bananaImg.getFitWidth()) {
                            monkey.setVisible(false);
                            poof2.setVisible(true);
                            flag = true;
                        }
                        stop = true;
                        break STOP;
                    } else{
                        noHit();
                    }
                } else if (!player1.getTurn() && j >= 0 && k >= 0 && j <
                        1000 && k < (monkey2.getStart_x())) {
                    if(canHitGrid_world[j][k] || bananaExplosion(j, k) || canHitGrid_jungle[j][k]) {
                        bananaImg.setVisible(false);
                        explosion.setVisible(true);
                        if (bananaImg.getLayoutX() < monkey1.getEnd_x() + bananaImg.getFitWidth() &&
                                bananaImg.getLayoutX() > monkey1.getStart_x() - bananaImg.getFitWidth() &&
                                bananaImg.getLayoutY() > monkey1.getStart_y() - bananaImg.getFitWidth() &&
                                bananaImg.getLayoutY() < monkey1.getEnd_y() + bananaImg.getFitWidth()){
                            monkey.setVisible(false);
                            poof1.setVisible(true);
                            flag = true;
                        }
                        stop = true;
                        break STOP;
                    } else{
                        noHit();
                    }
                }
            }
        }
    }
    /* if the banana is not hitting anything the explosion will stil happen*/
    public void noHit(){
        if (bananaImg.getLayoutY() >= 1000 - 1
                || bananaImg.getLayoutX() < monkey1.getStart_x()
                || bananaImg.getLayoutX() > monkey2.getEnd_x()) {
            explosion.setVisible(true);
        }
    }

    public boolean bananaExplosion(int y, int x) {
        if((x + (maxWidth / 10)) < maxWidth && (x - (maxWidth / 10)) > 0) {
            return y > 1000 - 3 && ((canHitGrid_jungle[y][(x - (maxWidth / 10))]) ||
                    (canHitGrid_jungle[y][(x + (maxWidth / 10))]));
        }
        return false;
    }

    /* switchVisibility() switches the visibilty of the action-boxes of each player */

    public void switchVisibility() {
        pl1ang.setVisible(!pl1ang.isVisible());
        pl1vec.setVisible(!pl1vec.isVisible());
        pl1AngLabel.setVisible(!pl1AngLabel.isVisible());
        pl1VelLabel.setVisible(!pl1VelLabel.isVisible());

        pl2ang.setVisible(!pl2ang.isVisible());
        pl2vec.setVisible(!pl2vec.isVisible());
        pl2AngLabel.setVisible(!pl2AngLabel.isVisible());
        pl2VelLabel.setVisible(!pl2VelLabel.isVisible());
    }

    /* the point() method adds a point to a players score and updates the label on the gamescreen
    if the method is run */
    public void point(){
        if (!player1.getTurn()){
            this.point1++;
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    score1.setText(String.valueOf(point1));
                }
            });
        } else {
            this.point2++;
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    score2.setText(String.valueOf(point2));
                }
            });
        }
    }

    public void pauseButtonClicked(MouseEvent mouseEvent) { //actionevent når pausebutton er klikket
        pauseButton.setVisible(false);
        playButton.setVisible(true);
        currentTime = timeAdder.getTime(); //gemmer tiden i variablen currentTime
        timer.cancel(); //stopper tiden
    }

    public void playButtonClicked(MouseEvent mouseEvent) { //actioevent når playbutton er klikket
        playButton.setVisible(false);
        pauseButton.setVisible(true);
        timer(currentTime); //opretter tiden ved start for currentTime
    }
}