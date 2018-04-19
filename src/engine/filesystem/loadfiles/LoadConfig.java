package engine.filesystem.loadfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class LoadConfig {

    private static int windowWidth;
    private static int windowHeight;
    private static String windowName;

    /**
     * Loads config information and sends it to the appropriate classes
     */
    public static void loadConfig() {
        try {
            Scanner inFile = new Scanner(new FileInputStream("config.cfg"));

            while(inFile.hasNextLine()) {
                String q = inFile.nextLine();
                if(q.startsWith("width=")) {
                    windowWidth = parseInt(q.replaceAll("width=", ""));
                }
                if(q.startsWith("height=")) {
                    windowHeight = parseInt(q.replaceAll("height=", ""));
                }
                if(q.startsWith("winname=")) {
                    windowName = q.replaceAll("winname=", "");
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Config not found.");
        }
    }

    public static int getWindowWidth() {
        return windowWidth;
    }

    public static int getWindowHeight() {
        return windowHeight;
    }

    public static String getWindowName() {
        return windowName;
    }
}
