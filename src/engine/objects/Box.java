package engine.objects;

public class Box {

    public static int numOfBoxes;
    float x;
    float y;

    public Box(float x, float y) {
        this.x=x;
        this.y=y;
        //We can add more variables here if we need to, like size or how it looks
        numOfBoxes++;
    }

    /**
     * Returns the coordinates in an int array, with index 0 being the x coordinate
     * and index 1 being the y coordinate.
     *
     * @return
     */
    public float[] getCoordinates() {
        float[] a = new float[2];
        a[0] = this.x;
        a[1] = this.y;
        return a;
    }
}
