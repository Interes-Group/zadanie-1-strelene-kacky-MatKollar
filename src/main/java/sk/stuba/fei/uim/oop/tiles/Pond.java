package sk.stuba.fei.uim.oop.tiles;


public class Pond {
    private final int riverSize = 6;
    private boolean[] crosshairs;

    public Pond() {
        this.crosshairs = new boolean[riverSize];
    }

    public void draw () {
        System.out.println("Pond:");
        for (int i = 0; i < riverSize; i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(this.crosshairs[i]);
        }
    }
}
