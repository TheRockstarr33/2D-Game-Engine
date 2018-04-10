package engine.filesystem;

import engine.objects.Box;

import java.util.ArrayList;

import static engine.core.Renderer.renderQuad;
import static engine.filesystem.loadfiles.LoadFile.loadBoxesFromMapFile;
import static engine.filesystem.loadfiles.LoadFile.loadMapFile;

/**
 * This class holds all of the data for the loaded map in variables, and has access to them all.
 */
public class Map {

    private static int[] spawnPoint = new int[2];
    private static ArrayList<Box> boxes;

    /**
     * Runs all the functions for a map to be loaded.
     *
     * @param path
     */
    public static void loadMap(String path) {
        System.out.println("Got map: " + path);
        loadMapFile(path);
        boxes = loadBoxesFromMapFile(path);
    }

    public static void setSpawnPoint(int[] sp) {
        spawnPoint = sp;
    }

    public static int[] getSpawnPoint() {
        return spawnPoint;
    }

    /**
     * Draws the boxes in the map
     */
    public static void drawBoxes() {
        try {
            for (int a = boxes.size(); a > 0; a--) {
                Box b = boxes.get(a-1);
                float[] i = b.getCoordinates();
                renderQuad(0.2f, 0.2f, i[0], i[1], b.getTexturePath());
            }
        } catch (Exception e) {
            renderQuad(1, 1, 1, 1, null);
        }
    }
}
