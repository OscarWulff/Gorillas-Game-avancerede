package ApplicationClasses.Biomes.Jungle;

import java.util.ArrayList;

import static Controllers.GameScreen.maxHeight;
import static Controllers.GameScreen.maxWidth;

public class Jungle {
    private int width;
    private int height;

    private ArrayList<Tree> trees;

    private boolean[][] canHitGrid;

    public Jungle() { //In this method I initialize the Jungle map with the Trees.
        trees = new ArrayList<>(); //An empty arraylist and the height and width are declared.
        this.height = height;
        this.width = width;

        //Defining all the trees coordinates and adding all the trees to the arraylist:
        trees.add(new Tree(8, 237, maxHeight - 265, maxHeight));
        trees.add(new Tree(206, 399, maxHeight - 189, maxHeight));
        trees.add(new Tree(400, 595, maxHeight - 384, maxHeight));
        trees.add(new Tree(570, 799, maxHeight - 226, maxHeight));
        trees.add(new Tree(726, 1003, maxHeight - 501, maxHeight));
        trees.add(new Tree(992, 1150, maxHeight - 279, maxHeight));
        trees.add(new Tree(1154, 1338, maxHeight - 175, maxHeight));
        trees.add(new Tree(1297, 1728, maxHeight - 406, maxHeight));

        //Making a new grid for the map, that is set to max size, and is filled with a false boolean on every pixel.
        canHitGrid = new boolean[maxHeight][maxWidth];
        makeGround(); //calling the makeground method, so the banana won't fly through the ground of the map.
        hitBoxtrees(); //calling the hitboxtrees method, so the banana can't hit the buildings aswell.
        makeWorld(); //If you choose the world to be smaller it will limit the hitboxes to the left and right bar u choose.
    }

    public boolean[][] getCanHitGrid() {
        return canHitGrid;
    }

    public void makeWorld(){ //Makes the world and so you can choose the world to be smaller.
        for (int i = 0; i < maxHeight; i++) { //Takes every pixel in the height.
            for (int j = 0; j < maxWidth; j++) { //takes every pixel in the max width.
                if (j < (maxWidth - width) / 2) {
                    canHitGrid[i][j] = true; //limits the width of the left side of the world consider what you choose the width to be.
                }
                if (j > (maxWidth - ((maxWidth - width) / 2))) { //limits the width of the right side of the world consider what you choose the width to be.
                    canHitGrid[i][j] = true;
                }
            }
        }
    }

    public void makeGround() { //If the banana hits the ground it stops and explodes.
        for (int i = maxHeight - 3; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                canHitGrid[i][j] = true;
            }
        }
    }


    public void hitBoxtrees() { //This method sets the grid to true for every tree in the jungle map.
        for (int i = trees.get(0).getStart_y(); i < trees.get(0).getEnd_y(); i++) { //First trees start y and end y coordinates.
            for (int k = trees.get(0).getStart_x(); k < trees.get(0).getEnd_x(); k++) { //First trees start x and end x coordinates.
                if (i >= 0 && k >= 0 && i < maxHeight && k < maxWidth) { //An if-statement that narrow it down to only tree 1's pixels.
                    canHitGrid[i][k] = true; //Here it sets tree 1's pixels to be true in the grid.
                }
            }
        }
        for (int i = trees.get(1).getStart_y(); i < trees.get(1).getEnd_y(); i++) { //Does the same as above for the next tree.
            for (int k = trees.get(1).getStart_x(); k < trees.get(1).getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < maxHeight && k < maxWidth) {
                    canHitGrid[i][k] = true;
                }
            }
        } //Does this the all the way down, until all trees are defined.
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