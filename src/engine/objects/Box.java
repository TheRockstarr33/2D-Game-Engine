package engine.objects;

import engine.core.Renderer;

import java.util.Map;

public class Box {

    //This stores the idNumber of each box, in addition to the rendering data for
    //each. It is just used for rendering, and for individual coordinates each box
    //must be accessed individually.
    private static Map<Integer, float[]> boxCoords; //Does the array work???
    float x;
    float y;
    int texId;
    int idNumber;           //TODO: Bug-test id system

    public Box(float x, float y, int texid) {
        this.x=x;
        this.y=y;
        this.texId=texid;

        idNumber = boxCoords.size()+1;

//        float[] a = {x, y};
        boxCoords.put(boxCoords.size()+1, Renderer.getQuadVertexArray(1,
                1, x, y));
//        a = null;
        //We can add more variables here if we need to, like size or how it looks
    }

    public static void renderBoxes() {
        int a = 0;
        try {
            a = boxCoords.size();
        } catch (Exception e) {
//            System.out.println("");
        }
        while(a>0) {
            Renderer.drawQuad(boxCoords.get(a));
            a--;
        }
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

    /**
     * Gets the proper texture path for the type of box being displayed
     *
     * @return
     */
    public String getTexturePath() {
        if(texId==0) {
            return "textures/qBlock.png";
        }
        return null;
    }

    /**
     * Used to safe-delete a box, needed to organize the boxes appropriately
     */
    public void deleteBox() {
        boxCoords.remove(idNumber);
    }
}
