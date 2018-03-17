package engine.core;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;

public class Window {

    public Window() {
        if(glfwInit() != true) {
            System.err.println("GLFW failed to initialize!");
            System.exit(1);
        }

        long win = glfwCreateWindow(640, 480, "Djent", 0, 0); //Width, Height, Title, Fullscreen, ?
        glfwShowWindow(win);

        GL.createCapabilities();

        while (glfwWindowShouldClose(win) != true) {
            glfwPollEvents();
        }

        glfwTerminate();
    }
}
