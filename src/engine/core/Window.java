package engine.core;

import static engine.filesystem.Commands.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import engine.input.KeyboardHandler;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;

public class Window {

    long win;

    public Window() {

        if(glfwInit() != true) {
            System.err.println("GLFW failed to initialize!");
            System.exit(1);
        }

        //Is used in input processing
        GLFWKeyCallback     keyCallback; //Necessary???

        win = glfwCreateWindow(640, 480, "Djent", 0, 0); //Width, Height, Title, Fullscreen, Monitor for window
        glfwShowWindow(win);
        glfwMakeContextCurrent(win);
        GL.createCapabilities();

        while (glfwWindowShouldClose(win) != true) {

            glfwPollEvents();

            glfwSetKeyCallback(win, keyCallback = new KeyboardHandler());

                //ALL INPUT CODE GOES HERE
                update();

                glfwPollEvents();

                glClear(GL_COLOR_BUFFER_BIT);

                //This code is deprecated, must be changed later. it is being used now just for testing purposes.
                glBegin(GL_QUADS);

                Renderer.getRenderInfo();

                glEnd();

                glfwSwapBuffers(win);
        }

        if(glfwWindowShouldClose(win) == true) {
            glfwTerminate();
        }
    }

    public void update() {
        if(KeyboardHandler.isKeyDown(GLFW_KEY_P)) {
            getInput();
        }
    }
}
