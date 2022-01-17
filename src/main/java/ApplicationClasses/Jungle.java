package ApplicationClasses;

public class Jungle {
    private int width;
    private int height;
    private Tree tree1;
    private Tree tree2;
    private Tree tree3;
    private Tree tree4;
    private Tree tree5;
    private Tree tree6;
    private Tree tree7;
    private Tree tree8;
    private boolean[][] canHitGrid;

    public Jungle(int height, int width) {
        this.height = 1000;
        this.width = 1700;

        this.tree1 = new Tree(8, 237, 1000 - 265, 1000); // height - 281 + 25 hele vejen ned.
        this.tree2 = new Tree(206, 399, 1000 - 189, 1000);
        this.tree3 = new Tree(400, 595, 1000 - 384, 1000);
        this.tree4 = new Tree(570, 799, 1000 - 226, 1000);
        this.tree5 = new Tree(726, 1003, 1000 - 501, 1000);
        this.tree6 = new Tree(992, 1150, 1000 - 279, 1000);
        this.tree7 = new Tree(1154, 1338, 1000 - 184, 1000);
        this.tree8 = new Tree(1297, 1728, 1000 - 406, 1000);

        canHitGrid = new boolean[1000][1700];
        makeGround();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Tree getTree1() {
        return tree1;
    }

    public Tree getTree2() {
        return tree2;
    }

    public Tree getTree3() {
        return tree3;
    }

    public Tree getTree4() {
        return tree4;
    }

    public Tree getTree5() {
        return tree5;
    }

    public Tree getTree6() {
        return tree6;
    }

    public Tree getTree7() {
        return tree7;
    }

    public Tree getTree8() {
        return tree8;
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
        for (int i = tree1.getStart_y(); i < tree1.getEnd_y(); i++) {
            for (int k = tree1.getStart_x(); k < tree1.getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = tree2.getStart_y(); i < tree2.getEnd_y(); i++) {
            for (int k = tree2.getStart_x(); k < tree2.getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = tree3.getStart_y(); i < tree3.getEnd_y(); i++) {
            for (int k = tree3.getStart_x(); k < tree3.getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = tree4.getStart_y(); i < tree4.getEnd_y(); i++) {
            for (int k = tree4.getStart_x(); k < tree4.getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = tree5.getStart_y(); i < tree5.getEnd_y(); i++) {
            for (int k = tree5.getStart_x(); k < tree5.getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = tree6.getStart_y(); i < tree6.getEnd_y(); i++) {
            for (int k = tree6.getStart_x(); k < tree6.getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = tree7.getStart_y(); i < tree7.getEnd_y(); i++) {
            for (int k = tree7.getStart_x(); k < tree7.getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
        for (int i = tree8.getStart_y(); i < tree8.getEnd_y(); i++) {
            for (int k = tree8.getStart_x(); k < tree8.getEnd_x(); k++) {
                if (i >= 0 && k >= 0 && i < height && k < width) {
                    canHitGrid[i][k] = true;
                }
            }
        }
    }
}