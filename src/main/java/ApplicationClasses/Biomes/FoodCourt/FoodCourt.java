package ApplicationClasses.Biomes.FoodCourt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Controllers.GameScreen.maxHeight;
import static Controllers.GameScreen.maxWidth;

public class FoodCourt {

    private Map<String, Food> food;
    private int width;
    private int height;

    public static boolean[][] canHitGrid;

    // construct a foodcourt
    public FoodCourt(int height, int width){ //In this method I initialize the foodcourt map with food
        food = new HashMap<>(); // an empty hashmap and the height and width are declared

        this.height = maxHeight;
        this.width = maxWidth;

        //defining all the food coordinates and adding them to the hashmap
        food.put("burger", new Food(4, 281, 1000 - 207 + 25, 1000));
        food.put("fries", new Food(273, 488, 1000 - 267 + 25, 1000));
        food.put("donut", new Food(488, 688, 1000 - 200 + 25, 1000));
        food.put("cupNoodle", new Food(665, 886, 1000 - 330 + 25, 1000));
        food.put("cola",new Food(889, 1104, 1000 - 455 + 25, 1000));
        food.put("kfc",new Food(1104, 1360, 1000 - 297 + 25, 1000));
        food.put("sushi1",new Food(1322, 1502, 1000 - 72 + 25, 1000));
        food.put("sushi2", new Food(1502, 1697, 1000 - 207 + 25, 1000));

        // making a new grid, that is set to the max size, and is filled with false boolean values
        canHitGrid = new boolean[1000][1700];

    }

    public boolean[][] getCanHitGrid() {
        return canHitGrid;
    }

    public void makeGround() { // if the banana hits the ground it stops and explode
        for (int i = height - 3; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canHitGrid[i][j] = true;
            }
        }
    }


    /* in hitBoxFood() all the for- loops int his method creates a hitbox for each food
     * this is done by getting their x and y values  */

    public void hitBoxFood() { //This method sets the grid to true for every piece of food in the foodcourt map
        for (int i = food.get("burger").getStart_y(); i < food.get("burger").getEnd_y(); i++) { //First piece of food start y and end y coordinates
            for (int k = food.get("burger").getStart_x(); k < food.get("burger").getEnd_x(); k++) { //First piece of food start x and end x coordinates
                if (i >= 0 && k >= 0 && i < height && k < width) { //An if-statement that narrow it down to only burgers pixels
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = food.get("fries").getStart_y(); i < food.get("fries").getEnd_y(); i++) { //Does the same as the piece of food above
            for (int k = food.get("fries").getStart_x(); k < food.get("fries").getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        } //Does this all the way down, until all pieces of food are defined
        for (int i = food.get("cupNoodle").getStart_y(); i < food.get("cupNoodle").getEnd_y(); i++) {
            for (int k = food.get("cupNoodle").getStart_x(); k < food.get("cupNoodle").getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = food.get("donut").getStart_y(); i < food.get("donut").getEnd_y(); i++) {
            for (int k = food.get("donut").getStart_x(); k < food.get("donut").getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = food.get("cola").getStart_y(); i < food.get("cola").getEnd_y(); i++) {
            for (int k = food.get("cola").getStart_x(); k < food.get("cola").getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = food.get("kfc").getStart_y(); i < food.get("kfc").getEnd_y(); i++) {
            for (int k = food.get("kfc").getStart_x(); k < food.get("kfc").getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = food.get("sushi1").getStart_y(); i < food.get("sushi1").getEnd_y(); i++) {
            for (int k = food.get("sushi1").getStart_x(); k < food.get("sushi1").getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = food.get("sushi2").getStart_y(); i < food.get("sushi2").getEnd_y(); i++) {
            for (int k = food.get("sushi2").getStart_x(); k < food.get("sushi2").getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
    }
}

