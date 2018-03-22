package engine.filesystem;

import engine.objects.Box;

import java.util.ArrayList;

import static engine.filesystem.LoadFile.loadBoxesFromMapFile;
import static engine.filesystem.LoadFile.loadMapFile;

/**
 * This class holds all of the data for the loaded map in variables, and has access to them all.
 */
public class Map {

    private static int[] spawnPoint = new int[2];
    private static ArrayList boxes;

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
}
