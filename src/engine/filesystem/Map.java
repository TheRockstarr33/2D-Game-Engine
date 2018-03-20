package engine.filesystem;

import engine.filesystem.LoadFile;

import static engine.filesystem.LoadFile.loadMapFile;

public class Map {

    public static void loadMap(String path) {
        System.out.println("Got map: " + path);
        loadMapFile(path);
    }
}
