package ApplicationClasses;

public class World {
    private int height;
    private int width;
    private Monkey monkey1;
    private Monkey monkey2;
    private boolean[][] canHitGrid;


    public World(int height, int width) {
        this.height = height;
        this.width = width;
        this.monkey1 = new Monkey(203, 321, height - 273, height);
        this.monkey2 = new Monkey(width - 118, width, height - 282, height);

        canHitGrid = new boolean[height][width];
        makeGround();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Monkey getMonkey1() {
        return monkey1;
    }

    public Monkey getMonkey2() {
        return monkey2;
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

    public void hitBox(Player player) {
        if (!player.getTurn()) {
            for (int i = monkey1.getStart_y(); i < monkey1.getEnd_y(); i++) {
                for (int k = monkey1.getStart_x(); k < monkey1.getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < height && k < width) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
        } else {
            for (int i = monkey2.getStart_y(); i < monkey2.getEnd_y(); i++) {
                for (int k = monkey2.getStart_x(); k < monkey2.getEnd_x(); k++) {
                    if (i >= 0 && k >= 0 && i < height && k < width) {
                        canHitGrid[i][k] = true;
                    }
                }
            }
        }
    }
}

