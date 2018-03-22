package engine.filesystem;

import engine.objects.Box;

import static engine.filesystem.LoadFile.loadBoxesFromMapFile;
import static engine.filesystem.LoadFile.loadMapFile;

/**
 * This class holds all of the data for the loaded map in variables, and has access to them all.
 */
public class Map {

    private static int[] spawnPoint = new int[2];
    private static Box[] boxes;

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

    public static Box[] getBoxes() {
        return boxes;
    }
}
