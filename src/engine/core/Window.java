package engine.core;

import static engine.filesystem.Commands.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import engine.filesystem.loadfiles.LoadConfig;
import engine.input.KeyboardHandler;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {

    long win;

    int windowWidth = 640;
    int windowHeight = 480;
    String windowTitle = "Game Engine";

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

//        try {
//            Renderer.initRenderer();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        GL11.glViewport(0, 0, windowWidth, windowHeight);

        while (glfwWindowShouldClose(win) != true) {


            glfwPollEvents();

            glfwSetKeyCallback(win, keyCallback = new KeyboardHandler());

                //ALL INPUT CODE GOES HERE
                update();

                glfwPollEvents();

                glClearColor(0.0f, 0.0f, 0.0f, 1.0f); //Needed?
                glClear(GL_COLOR_BUFFER_BIT);

                //This code is deprecated, must be changed later. it is being used now just for testing purposes.
//                glBegin(GL_QUADS);

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
        if(KeyboardHandler.isKeyDown(GLFW_KEY_Q)) {
            glfwTerminate();
        }
    }
}
