package ApplicationClasses.Biomes.Jungle;

import java.util.ArrayList;

import static Controllers.GameScreen.maxHeight;
import static Controllers.GameScreen.maxWidth;

public class Jungle {
    private int width;
    private int height;

    private ArrayList<Tree> trees;

    private boolean[][] canHitGrid;

    public Jungle(int height, int width) { //In this method I initialize the Jungle map with the Trees
        trees = new ArrayList<>();
        this.height = height;
        this.width = width;

        trees.add(new Tree(8, 237, maxHeight - 265, maxHeight)); // height - 281 + 25 hele vejen ned.
        trees.add(new Tree(206, 399, maxHeight - 189, maxHeight));
        trees.add(new Tree(400, 595, maxHeight - 384, maxHeight));
        trees.add(new Tree(570, 799, maxHeight - 226, maxHeight));
        trees.add(new Tree(726, 1003, maxHeight - 501, maxHeight));
        trees.add(new Tree(992, 1150, maxHeight - 279, maxHeight));
        trees.add(new Tree(1154, 1338, maxHeight - 175, maxHeight));
        trees.add(new Tree(1297, 1728, maxHeight - 406, maxHeight));


        canHitGrid = new boolean[maxHeight][maxWidth];
        hitBoxtrees();
        makeGround();
        hitBoxtrees();
        makeWorld();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<Tree> Trees() {
        return trees;
    }

    public boolean[][] getCanHitGrid() {
        return canHitGrid;
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

    public void makeGround() {
        for (int i = maxHeight - 3; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                canHitGrid[i][j] = true;
            }
        }
    }


    public void hitBoxtrees() {
        for (int i = trees.get(0).getStart_y(); i < trees.get(0).getEnd_y(); i++) {
            for (int k = trees.get(0).getStart_x(); k < trees.get(0).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < maxHeight && k < maxWidth) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(1).getStart_y(); i < trees.get(1).getEnd_y(); i++) {
            for (int k = trees.get(1).getStart_x(); k < trees.get(1).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < maxHeight && k < maxWidth) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(2).getStart_y(); i < trees.get(2).getEnd_y(); i++) {
            for (int k = trees.get(2).getStart_x(); k < trees.get(2).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < maxHeight && k < maxWidth) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(3).getStart_y(); i < trees.get(3).getEnd_y(); i++) {
            for (int k = trees.get(3).getStart_x(); k < trees.get(3).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < maxHeight && k < maxWidth) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(4).getStart_y(); i < trees.get(4).getEnd_y(); i++) {
            for (int k = trees.get(4).getStart_x(); k < trees.get(4).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < maxHeight && k < maxWidth) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(5).getStart_y(); i < trees.get(5).getEnd_y(); i++) {
            for (int k = trees.get(5).getStart_x(); k < trees.get(5).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < maxHeight && k < maxWidth) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(6).getStart_y(); i < trees.get(6).getEnd_y(); i++) {
            for (int k = trees.get(6).getStart_x(); k < trees.get(6).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < maxHeight && k < maxWidth) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(7).getStart_y(); i < trees.get(7).getEnd_y(); i++) {
            for (int k = trees.get(7).getStart_x(); k < trees.get(7).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < maxHeight && k < maxWidth) {
                    canHitGrid[i][k] = true;
                }
            }
        }
    }
}