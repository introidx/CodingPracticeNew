package design_pattern.p5_tik_tak_toe.model;

public class Pair<I extends Number, I1 extends Number> {
    Integer i;
    Integer j;

    public Pair(Integer i, Integer j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}