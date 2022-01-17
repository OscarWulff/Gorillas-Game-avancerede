package ApplicationClasses;

public class Food{

    private int start_x;
    private int start_y;
    private int end_x;
    private int end_y;

    public Food(int start_x, int end_x, int start_y, int end_y) {
        this.start_x = start_x;
        this.end_x = end_x;
        this.start_y = start_y;
        this.end_y = end_y;
    }

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
    public void setStart_x(int x) {
        start_x = x;
    }

    public void setEnd_x(int x) {
        end_x = x;
    }

    public void setStart_y(int y) {
        start_y = y;
    }

    public void setEnd_y(int y) {
        end_y = y;
    }
}