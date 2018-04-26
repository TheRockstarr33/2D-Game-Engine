package engine.input;

import engine.core.Window;
import engine.filesystem.Commands;
import engine.filesystem.loadfiles.LoadConfig;
import engine.gamestates.State;

import static org.lwjgl.glfw.GLFW.*;

public class Input extends Window {

    public static void getInput() {
        if(KeyboardHandler.isKeyDown(GLFW_KEY_P)) {
            Commands.getInput();
        }
        if(KeyboardHandler.isKeyDown(GLFW_KEY_Q)) {
            glfwTerminate();
        }
        if(KeyboardHandler.isKeyDown(GLFW_KEY_ESCAPE)) {
            if(Window.state==State.GAME) {
                Window.state = State.PAUSE;
            } else if(Window.state==State.PAUSE) {
                Window.state = State.GAME;
            }
        }
        if(KeyboardHandler.isKeyDown(GLFW_KEY_ENTER)) {
            if(Window.state==State.MAIN_MENU) {
                Window.state = State.GAME;
            }
        }
    }
}
