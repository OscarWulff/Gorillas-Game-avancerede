package ApplicationClasses;

import java.util.ArrayList;

public class Jungle {
    private int width;
    private int height;

    private ArrayList<Tree> trees;

    private boolean[][] canHitGrid;

    public Jungle(int height, int width) {
        trees = new ArrayList<>();
        this.height = 1000;
        this.width = 1700;

        trees.add(new Tree(8, 237, 1000 - 265, 1000)); // height - 281 + 25 hele vejen ned.
        trees.add(new Tree(206, 399, 1000 - 189, 1000));
        trees.add(new Tree(400, 595, 1000 - 384, 1000));
        trees.add(new Tree(570, 799, 1000 - 226, 1000));
        trees.add(new Tree(726, 1003, 1000 - 501, 1000));
        trees.add(new Tree(992, 1150, 1000 - 279, 1000));
        trees.add(new Tree(1154, 1338, 1000 - 175, 1000));
        trees.add(new Tree(1297, 1728, 1000 - 406, 1000));

        canHitGrid = new boolean[1000][1700];
        makeGround();
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


    public void hitBoxtrees() {
        for (int i = trees.get(0).getStart_y(); i < trees.get(0).getEnd_y(); i++) {
            for (int k = trees.get(0).getStart_x(); k < trees.get(0).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(1).getStart_y(); i < trees.get(1).getEnd_y(); i++) {
            for (int k = trees.get(1).getStart_x(); k < trees.get(1).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(2).getStart_y(); i < trees.get(2).getEnd_y(); i++) {
            for (int k = trees.get(2).getStart_x(); k < trees.get(2).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(3).getStart_y(); i < trees.get(3).getEnd_y(); i++) {
            for (int k = trees.get(3).getStart_x(); k < trees.get(3).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(4).getStart_y(); i < trees.get(4).getEnd_y(); i++) {
            for (int k = trees.get(4).getStart_x(); k < trees.get(4).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(5).getStart_y(); i < trees.get(5).getEnd_y(); i++) {
            for (int k = trees.get(5).getStart_x(); k < trees.get(5).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(6).getStart_y(); i < trees.get(6).getEnd_y(); i++) {
            for (int k = trees.get(6).getStart_x(); k < trees.get(6).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = trees.get(7).getStart_y(); i < trees.get(7).getEnd_y(); i++) {
            for (int k = trees.get(7).getStart_x(); k < trees.get(7).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
    }
}