/* s.nr. 216163 Oscar Wulff Mandrupsen */
package ApplicationClasses;

import Exceptions.IllegalInputException;

import static Controllers.GameScreen.MAX_HEIGHT;
import static Controllers.GameScreen.MAX_WIDTH;

public class World {
    private int height;
    private int width;
    private Monkey monkey1;
    private Monkey monkey2;
    private boolean[][] canHitGrid;


    public World(int height, int width) throws IllegalInputException {
        this.height = height;
        this.width = width;
        this.monkey1 = new Monkey(calculatePositionX(1), calculatePositionX(1) + 118,
                calculatePositionY(1), calculatePositionY(1) + 92);
        this.monkey2 = new Monkey(calculatePositionX(2), calculatePositionX(2) + 118 ,
                calculatePositionY(2), calculatePositionY(2) + 92);
        canHitGrid = new boolean[MAX_HEIGHT][MAX_WIDTH];
        makeGround();
        makeWorld();
    }


    public int calculatePositionX(int x)  {
        switch (x) {
            case 1: //x-coordinates where monkey 1 is standing in the jungle map, consider how big you choose the map to be.
                if(width >= 1550) return 100;
                else if(width >= 950) return 450;
                return 716;
            case 2: //x-coordinates where monkey 2 is standing in the jungle map, consider how big you choose the map to be.
                if(width >= 1450) return MAX_WIDTH - 300;
                else if(width >= 950) return MAX_WIDTH - 515;
                return MAX_WIDTH - 644;
            case 3: //x-coordinates where monkey 1 is standing in the city map, consider how big you choose the map to be.
                if(width >= 1500) return 249;
                else if(width >= 950) return 400;
                return 650;
            case 4: //x-coordinates where monkey 2 is standing in the city map, consider how big you choose the map to be.
                if(width >= 1500) return MAX_WIDTH - 326;
                else if(width >= 950) return MAX_WIDTH - 596;
                return MAX_WIDTH - 814;
            case 5: //x-coordinates where monkey 1 is standing in the food map, consider how big you choose the map to be.
                if(width >= 1500) return 106;
                else if(width >= 1000) return 350;
                return 650;
            case 6: //x-coordinates where monkey 2 is standing in the food map, consider how big you choose the map to be.
                if(width >= 1500) return MAX_WIDTH - 172;
                else if(width >= 1000) return MAX_WIDTH - 511;
                return MAX_WIDTH - 736;
        }
        return 0;
    }

    public int calculatePositionY(int y) {
        switch (y) {
            case 1: //y-coordinates where monkey 1 is standing in the jungle map, consider how big you choose the map to be.
                if(width >= 1550) return MAX_HEIGHT - 265 - 92 - 25;
                else if(width >= 950) return MAX_HEIGHT - 384 - 92 - 25;
                return MAX_HEIGHT - 529 - 92 + 4;
            case 2: //y-coordinates where monkey 2 is standing in the jungle map, consider how big you choose the map to be.
                if(width >= 1450) return MAX_HEIGHT - 406 - 92 - 25;
                else if(width >= 950) return MAX_HEIGHT - 175 - 92 - 25;
                return MAX_HEIGHT - 304 - 92;
            case 3: //y-coordinates where monkey 1 is standing in the city map, consider how big you choose the map to be.
                if(width >= 1500) return MAX_HEIGHT - 468 - 92 + 4;
                else if(width >= 950) return MAX_HEIGHT - 340 - 92 + 4;
                return MAX_HEIGHT - 690 - 92 + 4;
            case 4: //y-coordinates where monkey 2 is standing in the city map, consider how big you choose the map to be.
                if(width >= 1500) return MAX_HEIGHT - 340 - 92 + 6;
                else if(width >= 950) return MAX_HEIGHT - 569 - 92 + 4;
                return MAX_HEIGHT - 431 - 92 + 2;
            case 5: //y-coordinates where monkey 1 is standing in the food map, consider how big you choose the map to be.
                if(width >= 1500) return MAX_HEIGHT - 207 - 92 + 8;
                else if(width >= 1000) return MAX_HEIGHT - 267 - 92 + 4;
                return MAX_HEIGHT - 330 - 92 + 6;
            case 6: //y-coordinates where monkey 2 is standing in the food map, consider how big you choose the map to be.
                if(width >= 1500) return MAX_HEIGHT - 207 - 92 - 2;
                else if(width >= 1000) return MAX_HEIGHT - 297 - 92 + 4;
                return MAX_HEIGHT - 455 - 92 + 4;
        }
        return 0;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Monkey getMonkey1() {
        return monkey1;
    }

    public Monkey getMonkey2() {
        return monkey2;
    }

    public boolean[][] getCantHitGrid() {
        return canHitGrid;
    }

    //The method inserts the floor as true values into our grid
    public void makeGround() {
        for (int i = MAX_HEIGHT - 3; i < MAX_HEIGHT; i++) {
            for (int j = 0; j < MAX_WIDTH; j++) {
                canHitGrid[i][j] = true;
            }
        }
    }

    //The method makes every pixel which is not part of the initialised game true
    public void makeWorld(){
        for (int i = 0; i < MAX_HEIGHT; i++) {
            for (int j = 0; j < MAX_WIDTH; j++) {
                if (j < (MAX_WIDTH - width) / 2) {//if-statement making every pixel true on the left side of the game
                    canHitGrid[i][j] = true;
                }
                if (j > (MAX_WIDTH - ((MAX_WIDTH - width) / 2))) {//if-statement making every pixel true on right side
                    canHitGrid[i][j] = true;
                }
            }
        }
    }

    //A method who inserts the monkeys hitboxes as true-values into our grid
    public void hitBoxMonkey(Monkey monkey, boolean[][] grid) {
        for (int i = monkey.getStart_y(); i < monkey.getEnd_y(); i++) {
            for (int k = monkey.getStart_x(); k < monkey.getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    grid[i][k] = true;
                }
            }
        }
    }
}