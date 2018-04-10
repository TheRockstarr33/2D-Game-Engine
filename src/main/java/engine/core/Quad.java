package engine.core;

import static org.lwjgl.opengl.GL11.*;

public class Quad {

    public Quad(int sizeX, int sizeY, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    float sizeX;
    float sizeY;
    float posX;//X-Coordinate of upper left hand corner of quad
    float posY;//Y-Coordinate of upper left hand corner of quad

    public void drawQuad() {
        glBegin(GL_QUADS);
        glVertex2f(-0.5f, 0.5f);
        glVertex2f(0.5f, 0.5f);
        glVertex2f(0.5f, -0.5f);
        glVertex2f(-0.5f, -0.5f);
        glEnd();
    }
}
