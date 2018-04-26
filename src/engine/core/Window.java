package engine.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import engine.filesystem.loadfiles.LoadConfig;
import engine.gamestates.State;
import engine.input.Input;
import engine.input.KeyboardHandler;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {

    long win;

    int windowWidth = 640;
    int windowHeight = 480;
    String windowTitle = "Game Engine";

    protected static State state = State.MAIN_MENU;

    public Window() {

        if(glfwInit() != true) {
            System.err.println("GLFW failed to initialize!");
            System.exit(1);
        }

        LoadConfig.loadConfig();

        if(LoadConfig.getWindowHeight()!=0 && LoadConfig.getWindowWidth()!=0 &&
                LoadConfig.getWindowName()!=null) {
            windowWidth = LoadConfig.getWindowWidth();
            windowHeight = LoadConfig.getWindowHeight();
            windowTitle = LoadConfig.getWindowName();
        } else {
            System.out.println("Failed to load config settings. Reverting to default.");
        }

        //Is used in input processing
        GLFWKeyCallback     keyCallback; //Necessary???

        win = glfwCreateWindow(windowWidth, windowHeight, windowTitle, 0, 0); //Width, Height, Title, Fullscreen, Monitor for window
        glfwShowWindow(win);
        glfwMakeContextCurrent(win);
        GL.createCapabilities();

        GL11.glViewport(0, 0, windowWidth, windowHeight);

        while (glfwWindowShouldClose(win) != true) {
            if(state==State.GAME) {
                glfwPollEvents();

                glfwSetKeyCallback(win, keyCallback = new KeyboardHandler());

                //ALL INPUT CODE GOES HERE
                Input.getInput();

                glfwPollEvents();

                glClearColor(0.0f, 0.0f, 0.0f, 1.0f); //Needed?
                glClear(GL_COLOR_BUFFER_BIT);

                Renderer.getRenderInfo();

                glEnd();

                glfwSwapBuffers(win);
            } else if(state==State.MAIN_MENU) {
                glfwPollEvents();

                glfwSetKeyCallback(win, keyCallback = new KeyboardHandler());

                //ALL INPUT CODE GOES HERE
                Input.getInput();

                glfwPollEvents();

                glClearColor(0.0f, 0.0f, 0.0f, 1.0f); //Needed?
                glClear(GL_COLOR_BUFFER_BIT);

                //This is where our rendering info goes
//                Renderer.getRenderInfo();
                Renderer.drawQuad(Renderer.getQuadVertexArray(1, 1, 1, 1));

                glEnd();

                glfwSwapBuffers(win);
            }
        }

        if(glfwWindowShouldClose(win) == true) {
            glfwTerminate();
        }
    }
}
