package ApplicationClasses;

import ApplicationClasses.Biomes.Jungle.Jungle;
import ApplicationClasses.Biomes.City.City;
import ApplicationClasses.Biomes.FoodCourt.FoodCourt;

import Exceptions.IllegalInputException;

public class Game {
    private Player player1;
    private Player player2;
    private World world;
    private Jungle jungle;
    private City city;
    private FoodCourt foodCourt;


    public Game(String player1Name, String player2Name, int height, int length) throws IllegalInputException { // Initializing the Game with the players and maps.
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        world = new World(height, length);
        jungle = new Jungle();
        city = new City();
        foodCourt = new FoodCourt();
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

    public City getCity() { return city; }

    public FoodCourt getfoodCourt() { return foodCourt; }
}