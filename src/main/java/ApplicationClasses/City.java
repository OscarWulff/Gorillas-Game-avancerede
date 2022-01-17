package ApplicationClasses;

import java.util.ArrayList;

public class City {
        private int width;
        private int height;

        private ArrayList<Building> buildings;

        private boolean[][] canHitGrid;

        public City(int height, int width) {
            buildings = new ArrayList<>();
            this.height = 1000;
            this.width = 1700;

            buildings.add(new Building(9, 230, 1000 - 310 + 25, 1000));
            buildings.add(new Building(230, 388, 1000 - 468 + 25, 1000));
            buildings.add(new Building(388, 609, 1000 - 340 + 25, 1000));
            buildings.add(new Building(604, 833, 1000 - 690 + 25, 1000));
            buildings.add(new Building(833, 1002, 1000 - 431 + 25, 1000));
            buildings.add(new Building(1000, 1248, 1000 - 569 + 25, 1000));
            buildings.add(new Building(1243, 1505, 1000 - 340 + 25, 1000));
            buildings.add(new Building(1505, 1700, 1000 - 501 + 25, 1000));

            canHitGrid = new boolean[1000][1700];
            makeGround();
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public ArrayList<Building> buildings() {
            return buildings;
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
            for (int i = buildings.get(0).getStart_y(); i < buildings.get(0).getEnd_y(); i++) {
                for (int k = buildings.get(0).getStart_x(); k < buildings.get(0).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < height && k < width) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(1).getStart_y(); i < buildings.get(1).getEnd_y(); i++) {
                for (int k = buildings.get(1).getStart_x(); k < buildings.get(1).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < height && k < width) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(2).getStart_y(); i < buildings.get(2).getEnd_y(); i++) {
                for (int k = buildings.get(2).getStart_x(); k < buildings.get(2).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < height && k < width) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(3).getStart_y(); i < buildings.get(3).getEnd_y(); i++) {
                for (int k = buildings.get(3).getStart_x(); k < buildings.get(3).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < height && k < width) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(4).getStart_y(); i < buildings.get(4).getEnd_y(); i++) {
                for (int k = buildings.get(4).getStart_x(); k < buildings.get(4).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < height && k < width) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(5).getStart_y(); i < buildings.get(5).getEnd_y(); i++) {
                for (int k = buildings.get(5).getStart_x(); k < buildings.get(5).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < height && k < width) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(6).getStart_y(); i < buildings.get(6).getEnd_y(); i++) {
                for (int k = buildings.get(6).getStart_x(); k < buildings.get(6).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < height && k < width) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
            for (int i = buildings.get(7).getStart_y(); i < buildings.get(7).getEnd_y(); i++) {
                for (int k = buildings.get(7).getStart_x(); k < buildings.get(7).getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < height && k < width) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
        }
    }

