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
        this.monkey1 = new Monkey(calculatePosition(1), calculatePosition(2),
                591 - 92, 591);
        this.monkey2 = new Monkey(calculatePosition(3),
                calculatePosition(4) , 800 - 92, 800);
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
                if (j < monkey1.getStart_x()) {
                    canHitGrid[i][j] = true;
                }
                if (j > monkey2.getEnd_x()) {
                    canHitGrid[i][j] = true;
                }
            }
        }
    }

    public int calculatePosition(int x) throws IllegalInputException{
        switch (x) {
            case 1:
                return (1700 - width) / 2;
            case 2:
                return ((1700 - width) / 2) + 118;
            case 3:
                return 1700 - 118 - (1700 - width) / 2;
            case 4:
                return 1700 - (1700 - width) / 2;
        }
        throw new IllegalInputException("Only takes values from 1 to 4");
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