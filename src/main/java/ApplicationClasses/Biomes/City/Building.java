/* s.nr. 204197 Gideon Wade */
package ApplicationClasses.Biomes.City;

public class Building {

        private int start_x;
        private int start_y;
        private int end_x;
        private int end_y;

        public Building(int start_x, int end_x, int start_y, int end_y) { //The start-coordinates of the building.
            this.start_x = start_x;
            this.end_x = end_x;
            this.start_y = start_y;
            this.end_y = end_y;
        }
        //getter methods for all the start-coordinates.
        public int getStart_x() {
            return start_x;
        }

        public int getEnd_x() {
            return end_x;
        }

        public int getStart_y() {
            return start_y;
        }

        public int getEnd_y() {
            return end_y;
        }
    }

