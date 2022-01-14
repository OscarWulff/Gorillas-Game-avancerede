package Controllers;


import ApplicationClasses.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    public Label luftLabel;
    public Label minutes;
    public Label seconds;
    public ImageView pauseButton;
    public ImageView playButton;


    private Player player1; private Player player2;
    private World world;
    private int playerOneAngle; private int playerOneVelocity;
    private int playerTwoAngle; private int playerTwoVelocity;

    private Jungle jungle;

    private List<Integer> list = new ArrayList<>();
    public boolean canHitGrid_world[][];
    public boolean canHitGrid_jungle[][];
    private int[] bananaArr;
    private int point1 = 0;
    private int point2 = 0;
    private Monkey monkey1;
    private Monkey monkey2;
    private Tree tree1;
    private Tree tree2;
    private Tree tree3;
    private Tree tree4;
    private Tree tree5;
    private Tree tree6;
    private Tree tree7;
    private Tree tree8;
    private boolean flag;
    private int pl1_hits = 0;
    private int pl2_hits = 0;
    private static int airResistance;
    public Timer timer;
    public TimeAdder timeAdder;
    public boolean stop = false;

    public void timer() {
        timer = new Timer();
        timeAdder = new TimeAdder();
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

    public void pl1Start(ActionEvent actionEvent) {
        initGameValues();
        player1.setTurn(true);
        player2.setTurn(false);
        makeBoardVisible();
    }

    public void pl2Start(ActionEvent actionEvent) {
        initGameValues();
        player1.setTurn(false);
        player2.setTurn(true);
        makeBoardVisible();
        MainScene.modstand *= -1;
    }

    public void initGameValues(){
        direction();
        this.player1 = game.getPlayer1();
        this.player2 = game.getPlayer2();
        this.world = game.getWorld();
        this.monkey1 = world.getMonkey1();
        this.monkey2 = world.getMonkey2();
        this.canHitGrid_world = world.getCantHitGrid();

        poof1.setLayoutX(monkey1.getStart_x());
        poof1.setLayoutY(monkey1.getStart_y());

        poof2.setLayoutX(monkey2.getStart_x());
        poof2.setLayoutY(monkey2.getStart_y());

        this.jungle = game.getJungle();
        this.tree1 = jungle.getTree1();
        this.tree2 = jungle.getTree2();
        this.tree3 = jungle.getTree3();
        this.tree4 = jungle.getTree4();
        this.tree5 = jungle.getTree5();
        this.tree6 = jungle.getTree6();
        this.tree7 = jungle.getTree7();
        this.tree8 = jungle.getTree8();

        this.canHitGrid_jungle = jungle.getCantHitGrid();
        nameLabel1.setText(player1.getName());
        nameLabel2.setText(player2.getName());
        monkeyOneImg.setLayoutX(monkey1.getStart_x());
        monkeyOneImg.setLayoutY(monkey1.getStart_y());
        monkeyTwoImg.setLayoutX(monkey2.getStart_x());
        monkeyTwoImg.setLayoutY(monkey2.getStart_y());
        barLeft.setLayoutX(monkey1.getStart_x());
        barLeft.setLayoutY(0);
        barLeft.setFitHeight(world.getHeight());
        barLeft.isSmooth();
        barLower.setLayoutX(monkey1.getStart_x());
        barLower.setLayoutY(1000);
        barLower.setFitWidth(world.getWidth());
        barRight.setLayoutX(monkey2.getEnd_x());
        barRight.setLayoutY(0);
        monkeyOneImg.setVisible(true);
        monkeyTwoImg.setVisible(true);
        Tre1.setVisible(true); Tre2.setVisible(true); Tre3.setVisible(true); Tre4.setVisible(true);
        Tre5.setVisible(true); Tre6.setVisible(true); Tre7.setVisible(true); Tre8.setVisible(true);
        timer();
    }

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
    }

    public void doThrow(ActionEvent event) throws IOException {
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
    }

    public void runThread() {
        world.hitBox(player1);
        jungle.hitBoxtrees();
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
                makeBanana();
                simulateSlow(-1);
                bananaHit(monkeyTwoImg);
                if(stop) {
                    break;
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
                makeBanana();
                simulateSlow(-1);
                bananaHit(monkeyOneImg);
                if(stop) {
                    break;
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

    public void direction(){
        if (MainScene.modstand < 0 && MainScene.luftFlag){
            luftLabel.setText("\u2192 " + Math.abs(MainScene.modstand) + " m/s");
        } else if(MainScene.luftFlag) {
            luftLabel.setText("\u2190" + Math.abs(MainScene.modstand) + " m/s");
        }
    }

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

    public List<Integer> makeCurve(Banana banana) {
        MainScene.modstand *= -1;
        int x = 0;
        while (banana.trajectory(x) > - 1000
                && (x < (monkey2.getStart_x() - monkey1.getStart_x()) + (bananaImg.getFitWidth() / 2))) {
            this.list.add(banana.trajectory(x));
            x++;
        }
        return this.list;
    }

    public void makeBanana() {
        bananaArr = new int[4];
        bananaArr[0] = (int) bananaImg.getFitHeight();
        bananaArr[1] = (int) bananaImg.getFitWidth();
        bananaArr[2] = (int) bananaImg.getLayoutX();
        bananaArr[3] = (int) bananaImg.getLayoutY();
    }

    public void simulateSlow(int x) {
        try {
            Thread.sleep(x + 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void bananaHit(ImageView monkey) {
        explosion.setVisible(false);
        flag = false;
        stop = false;
        STOP:
        for (int j = (int) bananaImg.getLayoutY(); j < (int) bananaImg.getLayoutY() + bananaArr[0]; j++) {
            for (int k = (int) bananaImg.getLayoutX(); k < (int) bananaImg.getLayoutX() + bananaArr[1]; k++) {
                if (player1.getTurn() && j >= 0 && k >= monkey1.getEnd_x() && j <
                        1000 && k < 1700) {
                    if(canHitGrid_world[j][k] || bananaExplosion(j, k) || canHitGrid_jungle[j][k]) {
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

    public void noHit(){
        if (bananaImg.getLayoutY() >= 1000 - 1
                || bananaImg.getLayoutX() < monkey1.getStart_x()
                || bananaImg.getLayoutX() > monkey2.getEnd_x()) {
            explosion.setVisible(true);
        }
    }

    public boolean bananaExplosion(int y, int x) {
        if((x + (1700 / 10)) < 1700 && (x - (1700 / 10)) > 0) {
            return y > 1000 - 3 && ((canHitGrid_jungle[y][(x - (1700 / 10))]) ||
                    (canHitGrid_jungle[y][(x + (1700 / 10))]));
        }
        return false;
    }

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

    public void pauseButtonClicked(MouseEvent mouseEvent) {
        Platform.enterNestedEventLoop(pauseButton);
    }

    public void playButtonClicked(MouseEvent mouseEvent) {
        Platform.exitNestedEventLoop(playButton, null);
    }
}