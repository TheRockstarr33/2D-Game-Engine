package engine.core;

import engine.filesystem.Map;

import static org.lwjgl.opengl.GL11.glVertex2f;

public class Renderer {

    public static void getRenderInfo() {
        glVertex2f(-0.5f, 0.5f);
        glVertex2f(0.5f, 0.5f);
        glVertex2f(0.5f, -0.5f);
        glVertex2f(-0.5f, -0.5f);
    }

    public void newQuad(int sizeX, int sizeY, int posX, int posY) {


    }
}
