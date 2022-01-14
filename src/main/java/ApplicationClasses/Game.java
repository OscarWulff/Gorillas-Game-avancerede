package ApplicationClasses;

import Exceptions.IllegalInputException;

public class Game {
    private Player player1;
    private Player player2;
    private World world;
    private Jungle jungle;


    public Game(String player1Name, String player2Name, int height, int length) throws IllegalInputException {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        world = new World(height, length);
        jungle = new Jungle(height, length);
    }

    public Player getPlayer1(){
        return this.player1;
    }

    public Player getPlayer2(){
        return this.player2;
    }

    public World getWorld() {
        return world;
    }

    public Jungle getJungle() {
        return jungle;
    }
}