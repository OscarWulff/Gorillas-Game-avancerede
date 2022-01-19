package ApplicationClasses;

public class Monkey {
    private int start_x;
    private int end_x;
    private int start_y;
    private int end_y;

    public Monkey(int start_x, int end_x, int start_y, int end_y) {
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

    public void setStart_x(int i){this.start_x = i;}

    public void setEnd_x (int i){ this.end_x = i;}

    public void setStart_y(int i){this.start_y = i;}

    public void setEnd_y(int end_y) {this.end_y = end_y;}

}

