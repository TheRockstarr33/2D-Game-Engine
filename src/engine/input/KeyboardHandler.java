package engine.input;

import org.lwjgl.glfw.GLFWKeyCallback;
import static org.lwjgl.glfw.GLFW.*;

public class KeyboardHandler extends GLFWKeyCallback {

    public static boolean[] keys = new boolean[65536];

    /**
     * Extending
     *
     * @param window
     * @param key
     * @param scancode
     * @param action
     * @param mods
     */
    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        keys[key] = action != GLFW_RELEASE;
    }

    /**
     * Checks to see if a key has been pressed
     *
     * @param keyCode
     * @return
     */
    public static boolean isKeyDown(int keyCode) {
        return keys[keyCode];
    }
}
