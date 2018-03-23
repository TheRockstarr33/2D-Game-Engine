package engine.core;

import engine.filesystem.Map;
import engine.objects.Box;

import static engine.filesystem.Map.*;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Renderer {

    /**
     * Renders one untextured quad.
     *
     * Parameters are for the size of the quad and the position, starting from the
     * upper left corner.
     *
     * @param sizeX
     * @param sizeY
     * @param posX
     * @param posY
     */
    public static void renderQuad(float sizeX, float sizeY, float posX, float posY) {
        //These float arrays each represent one vertex of the quad. The first index
        //represents the X axis, and the second represents the Y axis.
        float[] a = new float[2];
        float[] b = new float[2];
        float[] c = new float[2];
        float[] d = new float[2];

        a[0] = posX + sizeX;
        a[1] = posY;
        b[0] = posX;
        b[1] = posY;
        c[0] = posX;
        c[1] = posY - sizeY;
        d[0] = posX + sizeX;
        d[1] = posY - sizeY;

        glVertex2f(a[0], a[1]);
        glVertex2f(b[0], b[1]);
        glVertex2f(c[0], c[1]);
        glVertex2f(d[0], d[1]);
    }

    /**
     * Sends all rendering info to the window.
     */
    public static void getRenderInfo() {
        //THIS IS JUST FOR TESTING. Needs to be modified to send info from objects.
        Map.drawBoxes();
    }
}
