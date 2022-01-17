package ApplicationClasses.Biomes.Food;
import ApplicationClasses.Biomes.Food.Food;

import java.util.Map;

import static Controllers.GameScreen.maxHeight;
import static Controllers.GameScreen.maxWidth;

public class FoodCourt {
    private Map<String, Food> food;
    private int width;
    private int height;

    private boolean[][] canHitGrid;

    public FoodCourt(int height, int width){
        this.height = maxHeight;
        this.width = maxWidth;
        food.put("burger", new Food(4, 281, maxHeight - 207 + 25, maxHeight));
        food.put("fries", new Food(273, 488, maxHeight - 267 + 25, maxHeight));
        food.put("donut", new Food(488, 688, maxHeight - 200 + 25, maxHeight));
        food.put("cupNoodle", new Food(665, 886, maxHeight - 330 + 25, maxHeight));
        food.put("cola",new Food(889, 1104, maxHeight - 455 + 25, maxHeight));
        food.put("kfc",new Food(1104, 1360, maxHeight - 297 + 25, maxHeight));
        food.put("sushi1",new Food(1322, 1502, maxHeight - 72 + 25, maxHeight));
        food.put("sushi2", new Food(1502, 1697, maxHeight - 207 + 25, maxHeight));

        canHitGrid = new boolean[maxHeight][maxWidth];
        makeGround();

    }

    public void makeGround() {
        for (int i = maxHeight - 3; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                canHitGrid[i][j] = true;
            }
        }
    }


    public void hitBoxFood() {
        for (int i = food.get("burger").getStart_y(); i < food.get("burger").getEnd_y(); i++) {
            for (int k = food.get("burger").getStart_x(); k < food.get("burger").getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = food.get("fries").getStart_y(); i < food.get("fries").getEnd_y(); i++) {
            for (int k = food.get("fries").getStart_x(); k < food.get("fries").getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
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
        for (int i = food.get("kfc").getStart_y(); i <food.get("kfc").getEnd_y(); i++) {
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


