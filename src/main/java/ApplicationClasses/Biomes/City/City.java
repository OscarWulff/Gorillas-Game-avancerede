/* s.nr. 204197 Gideon Wade */
package ApplicationClasses.Biomes.City;

import java.util.ArrayList;

import static Controllers.GameScreen.MAX_HEIGHT;
import static Controllers.GameScreen.MAX_WIDTH;

public class City {
        private int width;
        private int height;

        private ArrayList<Building> buildings;

        private boolean[][] canHitGrid;

        public City(int height, int width) { //In this method I initialize the City map with the buildings
            buildings = new ArrayList<>(); //An empty arraylist and the height and width are declared
            this.height = height;
            this.width = width;

            //Defining all the buildings coordinates and adding all the buildings to the arraylist:
            buildings.add(new Building(9, 230, MAX_HEIGHT - 310 + 25, MAX_HEIGHT));
            buildings.add(new Building(230, 388, MAX_HEIGHT - 468 + 25, MAX_HEIGHT));
            buildings.add(new Building(388, 609, MAX_HEIGHT - 340 + 25, MAX_HEIGHT));
            buildings.add(new Building(604, 833, MAX_HEIGHT - 690 + 25, MAX_HEIGHT));
            buildings.add(new Building(833, 1002, MAX_HEIGHT - 431 + 25, MAX_HEIGHT));
            buildings.add(new Building(1000, 1248, MAX_HEIGHT - 569 + 25, MAX_HEIGHT));
            buildings.add(new Building(1243, 1505, MAX_HEIGHT - 340 + 25, MAX_HEIGHT));
            buildings.add(new Building(1505, 1700, MAX_HEIGHT - 501 + 25, MAX_HEIGHT));

            //Making a new grid for the map, that is set to max size, and is filled with a false boolean on every pixel.
            canHitGrid = new boolean[MAX_HEIGHT][MAX_WIDTH];
            hitBoxbuildings(); //calling the hitboxbuildings method, so the banana can't hit the buildings aswell.
        }

        public boolean[][] getCanHitGrid() {
            return canHitGrid;
        }


        public void hitBoxbuildings() { //This method sets the grid to true for every building in the city map.
            for (int i = buildings.get(0).getStart_y(); i < buildings.get(0).getEnd_y(); i++) { //First building start y and end y coordinates.
                for (int k = buildings.get(0).getStart_x(); k < buildings.get(0).getEnd_x(); k++) { //First buildings start x and end x coordinates.
                    if (i >= 0 && k >= 0 && i < MAX_HEIGHT && k < MAX_WIDTH) { //An if-statement that narrow it down to only building 1's pixels.
                        canHitGrid[i][k] = true; //Here it sets building 1's pixels to be true in the grid.
                    }
                }
            }
            for (int i = buildings.get(1).getStart_y(); i < buildings.get(1).getEnd_y(); i++) { //Does the same as above for the next building.
                for (int k = buildings.get(1).getStart_x(); k < buildings.get(1).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < MAX_HEIGHT && k < MAX_WIDTH) {
                        canHitGrid[i][k] = true;
                    }
                }
            } //Does this the all the way down, until all buildings are defined.
            for (int i = buildings.get(2).getStart_y(); i < buildings.get(2).getEnd_y(); i++) {
                for (int k = buildings.get(2).getStart_x(); k < buildings.get(2).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < MAX_HEIGHT && k < MAX_WIDTH) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(3).getStart_y(); i < buildings.get(3).getEnd_y(); i++) {
                for (int k = buildings.get(3).getStart_x(); k < buildings.get(3).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < MAX_HEIGHT && k < MAX_WIDTH) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(4).getStart_y(); i < buildings.get(4).getEnd_y(); i++) {
                for (int k = buildings.get(4).getStart_x(); k < buildings.get(4).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < MAX_HEIGHT && k < MAX_WIDTH) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(5).getStart_y(); i < buildings.get(5).getEnd_y(); i++) {
                for (int k = buildings.get(5).getStart_x(); k < buildings.get(5).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < MAX_HEIGHT && k < MAX_WIDTH) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(6).getStart_y(); i < buildings.get(6).getEnd_y(); i++) {
                for (int k = buildings.get(6).getStart_x(); k < buildings.get(6).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < MAX_HEIGHT && k < MAX_WIDTH) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(7).getStart_y(); i < buildings.get(7).getEnd_y(); i++) {
                for (int k = buildings.get(7).getStart_x(); k < buildings.get(7).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < MAX_HEIGHT && k < MAX_WIDTH) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
        }
    }

