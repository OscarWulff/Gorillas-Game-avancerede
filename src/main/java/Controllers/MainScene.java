package Controllers;

import ApplicationClasses.Banana;
import ApplicationClasses.Game;
import Exceptions.IllegalInputException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;
import java.util.Random;


public class MainScene {
    @FXML
    public Button btnChange;
    @FXML
    public TextField length;
    @FXML
    public TextField height;
    public TextField playerID1;
    public TextField playerID2;
    public Button luftKnap;


    private int length_i;
    private int height_i;
    public String playerOneName;
    public String playerTwoName;
    private Game game;
    private boolean luftFlag = false;
    public static int modstand = 0;

    public void goToGameScreen() throws IOException, IllegalInputException {
        /*
        this.length_i = 800;
        this.height_i = 800;
        this.playerOneName = "Pafi";
        this.playerTwoName = "Søren";
        */

        this.length_i = Integer.parseInt(length.getText());
        this.height_i = Integer.parseInt(height.getText());
        this.playerOneName = playerID1.getText();
        this.playerTwoName = playerID2.getText();


        if (height_i > 0) {
            this.game = new Game(playerOneName, playerTwoName,
                    height_i, length_i);
        } else {
            throw new IllegalInputException("Height must be between 0 and 800, " +
                    "and length between 0 and 1300");
        }
        GameScreen.setGame(game);
        SceneManager.changeScene("fxml/GameScreen.fxml");
    }

    public void switchAirSpeed(ActionEvent actionEvent) {

        if(!luftFlag){
            luftKnap.setText("Yes");
            luftFlag = true;
            airResistance();
            System.out.println(modstand);

        } else if (luftFlag) {
            luftKnap.setText("No");
            luftFlag = false;
        }

    }

    public void airResistance(){

        Random rand = new Random();
        int spanMax = 30;
        int spanMin = -30;

        this.modstand = rand.nextInt(spanMax - spanMin) + spanMin;
        GameScreen.setAirresistance(modstand);
    }





}