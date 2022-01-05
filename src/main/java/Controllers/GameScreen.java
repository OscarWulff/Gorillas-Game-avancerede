package Controllers;


import ApplicationClasses.Banana;
import ApplicationClasses.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

public class GameScreen {
    public Game game;
    @FXML
    public Button btnBack;
    public TextField pl1ang;
    public TextField pl1vec;
    public TextField pl2ang;
    public TextField pl2vec;
    public ImageView banana;
    public Button Button;
    public Label pl2anglabel;
    public Label pl2vellabel;


    public void goToMainScene() throws IOException {
        SceneManager.changeScene("fxml/MainScene.fxml");
    }

    Game gamer = new Game("Søren","Gucci",800,1300);

    private int playerOneAngle;
    private int playerOneVelocity;
    private int playerTwoAngle;
    private int playerTwoVelocity;

    public void pl1SetAngle(ActionEvent event) throws IOException {
        this.playerOneAngle = Integer.parseInt(pl1ang.getText());
    }


    public void pl1SetVelocity(ActionEvent event) throws IOException {
        this.playerOneVelocity = Integer.parseInt(pl1vec.getText());
    }

    public void pl2SetAngle(ActionEvent actionEvent) throws IOException{
        int playerTwoAngle = Integer.parseInt(pl2ang.getText());
    }

    public void pl2SetVelocity(ActionEvent actionEvent) throws IOException{
        int playerTwoVelocity = Integer.parseInt(pl2vec.getText());
    }

    // A grid that is false everywhere on the scene, except the buildings and monkeys where it is true.
    public void grid(int rows, int columns) {
        boolean arr[][] = new boolean[rows][columns];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = false;
            }
        }

    }

    public void touchMe(ActionEvent event) throws IOException {
        Thread thread = new Thread(this::runThread);
        thread.start();



    }

    public void runThread() {
        if (gamer.player1.getTurn()) {
            banana.setX(1);
            banana.setY(100);
            banana.setVisible(true);

            Banana banan = new Banana(playerOneVelocity, 9.82, playerOneAngle);
            int x = 1;

            while (banana.getY() <= 100) {
                banana.setX(x);
                banana.setY(100 - banan.trajectory(x));
                banana.isSmooth();
                simulateSlow();
                System.out.println(banana.getY());
                x++;
            }
            gamer.player1.setTurn(false);
            pl2ang.setVisible(true);
            pl2vec.setVisible(true);
            pl2anglabel.setVisible(true);
            pl2vellabel.setVisible(true);

        } else {
            banana.setX(1200);
            banana.setY(100);
            banana.setVisible(true);

            Banana banan = new Banana(playerTwoVelocity, 9.82, playerTwoAngle);
            int x = 1200;

            while (banana.getY() <= 100) {
                banana.setX(x);
                banana.setY(100 - banan.trajectory(x));
                banana.isSmooth();
                simulateSlow();
                System.out.println(banana.getY());
                x--;
            }
            gamer.player1.setTurn(true);

        }
        simulateSlow();
        banana.setVisible(false);
    }

    public void simulateSlow() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}






