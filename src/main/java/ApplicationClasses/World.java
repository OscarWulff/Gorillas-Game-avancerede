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
        this.monkey2 = new Monkey(calculatePositionX(2),
                calculatePositionX(2)+118 , calculatePositionY(2), calculatePositionY(2) + 92);
        canHitGrid = new boolean[maxHeight][maxWidth];
        makeGround();
        makeWorld();
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

    public void makeGround() {
        for (int i = maxHeight - 3; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                canHitGrid[i][j] = true;
            }
        }
    }

    public void makeWorld(){
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                if (j < (maxWidth - width) / 2) {
                    canHitGrid[i][j] = true;
                }
                if (j > (maxWidth - ((maxWidth - width) / 2))) {
                    canHitGrid[i][j] = true;
                }
            }
        }
    }

    public int calculatePositionX(int x) throws IllegalInputException{
        switch (x) {
            case 1:
                if(width >= 1550) return 100;
                else if(width >= 1200) return 250;
                else if(width >= 900) return 450;
                else if(width >= 720) return 585;
                return 590;
            case 2:
                if(width >= 1450) return maxWidth - 300;
                else if(width >= 1200) return maxWidth - 515;
                else if(width >= 820) return maxWidth - 645;
                return maxWidth - 750;
        }
        throw new IllegalInputException("Only takes values from 1 to 4");
    }

    public int calculatePositionY(int y) throws IllegalInputException{
        switch (y) {
            case 1:
                if(width >= 1550) return maxHeight - 265 - 92 - 25;
                else if(width >= 1200) return maxHeight - 189 - 92 - 25;
                else if(width >= 900) return maxHeight - 384 - 92 - 25;
                return maxHeight - 226 - 92 - 25;
            case 2:
                if(width >= 1450) return maxHeight - 406 - 92 - 25;
                else if(width >= 1200) return maxHeight - 175 - 92 - 25;
                else if(width >= 820) return maxHeight - 279 - 92 - 25;
                return maxHeight - 501 - 92 - 25;
        }
        throw new IllegalInputException("Only takes values from 1 to 2");
    }

    public void hitBox(Player player) {
        if (!player.getTurn()) {
            whichMonkey(monkey1);
        } else {
            whichMonkey(monkey2);
        }
    }

    public void whichMonkey(Monkey monkey) {
        for (int i = monkey.getStart_y(); i < monkey.getEnd_y(); i++) {
            for (int k = monkey.getStart_x(); k < monkey.getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
    }
}