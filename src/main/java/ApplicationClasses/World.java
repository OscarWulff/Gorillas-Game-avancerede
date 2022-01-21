package ApplicationClasses;

import Exceptions.IllegalInputException;

import static Controllers.GameScreen.maxHeight;
import static Controllers.GameScreen.maxWidth;

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
        canHitGrid = new boolean[maxHeight][maxWidth];
        makeGround();
        makeWorld();
    }

    //The method inserts the floor as true values into our grid
    public void makeGround() {
        for (int i = maxHeight - 3; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                canHitGrid[i][j] = true;
            }
        }
    }
    //The method makes every pixel which is not part of the initialised game true
    public void makeWorld(){
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                if (j < (maxWidth - width) / 2) {//if-statement making every pixel true on the left side of the game
                    canHitGrid[i][j] = true;
                }
                if (j > (maxWidth - ((maxWidth - width) / 2))) {//if-statement making every pixel true on right side
                    canHitGrid[i][j] = true;
                }
            }
        }
    }

    public int calculatePositionX(int x)  {
        switch (x) {
            case 1: //x-coordinates where monkey 1 is standing in the jungle map, consider how big you choose the map to be.
                if(width >= 1550) return 100;
                else if(width >= 950) return 450;
                return 716;
            case 2: //x-coordinates where monkey 2 is standing in the jungle map, consider how big you choose the map to be.
                if(width >= 1450) return maxWidth - 300;
                else if(width >= 950) return maxWidth - 515;
                return maxWidth - 644;
            case 3: //x-coordinates where monkey 1 is standing in the city map, consider how big you choose the map to be.
                if(width >= 1500) return 249;
                else if(width >= 950) return 400;
                return 650;
            case 4: //x-coordinates where monkey 2 is standing in the city map, consider how big you choose the map to be.
                if(width >= 1500) return maxWidth - 326;
                else if(width >= 950) return maxWidth - 596;
                return maxWidth - 814;
            case 5: //x-coordinates where monkey 1 is standing in the food map, consider how big you choose the map to be.
                if(width >= 1500) return 106;
                else if(width >= 1000) return 350;
                return 650;
            case 6: //x-coordinates where monkey 2 is standing in the food map, consider how big you choose the map to be.
                if(width >= 1500) return maxWidth - 172;
                else if(width >= 1000) return maxWidth - 511;
                return maxWidth - 736;
        }
        return 0;
    }

    public int calculatePositionY(int y) {
        switch (y) {
            case 1: //y-coordinates where monkey 1 is standing in the jungle map, consider how big you choose the map to be.
                if(width >= 1550) return maxHeight - 265 - 92 - 25;
                else if(width >= 950) return maxHeight - 384 - 92 - 25;
                return maxHeight - 529 - 92 + 4;
            case 2: //y-coordinates where monkey 2 is standing in the jungle map, consider how big you choose the map to be.
                if(width >= 1450) return maxHeight - 406 - 92 - 25;
                else if(width >= 950) return maxHeight - 175 - 92 - 25;
                return maxHeight - 304 - 92;
            case 3: //y-coordinates where monkey 1 is standing in the city map, consider how big you choose the map to be.
                if(width >= 1500) return maxHeight - 468 - 92 + 4;
                else if(width >= 950) return maxHeight - 340 - 92 + 4;
                return maxHeight - 690 - 92 + 4;
            case 4: //y-coordinates where monkey 2 is standing in the city map, consider how big you choose the map to be.
                if(width >= 1500) return maxHeight - 340 - 92 + 6;
                else if(width >= 950) return maxHeight - 569 - 92 + 4;
                return maxHeight - 431 - 92 + 2;
            case 5: //y-coordinates where monkey 1 is standing in the food map, consider how big you choose the map to be.
                if(width >= 1500) return maxHeight - 207 - 92 + 8;
                else if(width >= 1000) return maxHeight - 267 - 92 + 4;
                return maxHeight - 330 - 92 + 6;
            case 6: //y-coordinates where monkey 2 is standing in the food map, consider how big you choose the map to be.
                if(width >= 1500) return maxHeight - 207 - 92 - 2;
                else if(width >= 1000) return maxHeight - 297 - 92 + 4;
                return maxHeight - 455 - 92 + 4;
        }
        return 0;
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

}