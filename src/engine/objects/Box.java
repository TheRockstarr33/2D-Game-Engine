package engine.objects;

public class Box {

    public static int numOfBoxes;

    public Box(int x, int y) {
        this.x=x;
        this.y=y;
        //We can add more variables here if we need to, like size or how it looks
        numOfBoxes++;
    }

    int x;
    int y;
}
