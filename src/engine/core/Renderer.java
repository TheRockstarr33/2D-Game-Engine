package engine.core;

import engine.objects.Box;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {

    /**
     * Returns a float array with the information about each vertex in a given quad.
     *
     * @param sizeX
     * @param sizeY
     * @param posX
     * @param posY
     * @return
     */
    public static float[] getQuadVertexArray(float sizeX, float sizeY, float posX,
                                             float posY) {
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

        float[] vertices = new float[]{
                a[0], a[1],
                b[0], b[1],
                c[0], c[1],
                d[0], d[1]
        };

        return vertices;
    }

    public static void drawQuad(float[] a) {
        try {
            glBegin(GL_QUADS);
            glVertex2f(a[0], a[1]);
            glVertex2f(a[2], a[3]);
            glVertex2f(a[4], a[5]);
            glVertex2f(a[6], a[7]);
            glEnd();
        } catch (Exception e) {
            System.out.println("Unable to draw quad, incorrect input.");
        }
    }

    /**
     * Sends all rendering info to the window.
     * TODO: Add object manager to handle the rendering of different objects
     */
    public static void getRenderInfo() {
        Box.renderBoxes();
    }
}
