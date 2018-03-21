package engine.filesystem;

import engine.filesystem.LoadFile;

import static engine.filesystem.LoadFile.loadMapFile;

/**
 * This class holds all of the data for the loaded map in variables, and has access to them all.
 */
public class Map {

    private static int[] spawnPoint = new int[2];

    public static void loadMap(String path) {
        System.out.println("Got map: " + path);
        loadMapFile(path);
    }

    public static void setSpawnPoint(int[] sp) {
        spawnPoint = sp;
    }

    public static int[] getSpawnPoint() {
        return spawnPoint;
    }
}
