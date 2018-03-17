package engine.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;

public class Window {

    public Window() {
        if(glfwInit() != true) {
            System.err.println("GLFW failed to initialize!");
            System.exit(1);
        }

        long win = glfwCreateWindow(640, 480, "Djent", 0, 0); //Width, Height, Title, Fullscreen, Monitor for window
        glfwShowWindow(win);

        glfwMakeContextCurrent(win);

        GL.createCapabilities();

        while (glfwWindowShouldClose(win) != true) {
            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT);

            //This code is deprecated, must be changed later. it is being used now just for testing purposes.
            glBegin(GL_QUADS);

            glVertex2f(-0.5f, 0.5f);
            glVertex2f(0.5f, 0.5f);
            glVertex2f(0.5f, -0.5f);
            glVertex2f(-0.5f, -0.5f);
            glEnd();

            glfwSwapBuffers(win);
        }

        glfwTerminate();
    }
}
