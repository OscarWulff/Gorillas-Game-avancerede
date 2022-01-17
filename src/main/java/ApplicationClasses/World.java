package ApplicationClasses;

import Exceptions.IllegalInputException;

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
        canHitGrid = new boolean[1000][1700];
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
        for (int i = height - 3; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canHitGrid[i][j] = true;
            }
        }
    }

    public void makeWorld(){
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1700; j++) {
                if (j < (1700 - width) / 2) {
                    canHitGrid[i][j] = true;
                }
                if (j > (1700 - ((1700 - width) / 2))) {
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
                if(width >= 1450) return 1700 - 300;
                else if(width >= 1200) return 1700 - 515;
                else if(width >= 820) return 1700 - 645;
                return 1700 - 750;
        }
        throw new IllegalInputException("Only takes values from 1 to 4");
    }

    public int calculatePositionY(int y) throws IllegalInputException{
        switch (y) {
            case 1:
                if(width >= 1550) return 1000 - 265 - 92 - 25;
                else if(width >= 1200) return 1000 - 189 - 92 - 25;
                else if(width >= 900) return 1000 - 384 - 92 - 25;
                else if(width >= 720) return 1000 - 226 - 92 - 25;
                return 1000 - 501 - 92 - 25;
            case 2:
                if(width >= 1450) return 1000 - 406 - 92 - 25;
                else if(width >= 1200) return 1000 - 175 - 92 - 25;
                else if(width >= 820) return 1000 - 279 - 92 - 25;
                return 1000 - 501 - 92 - 25;
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