package engine.filesystem;

import engine.objects.Box;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class LoadFile {

    /**
     * Loads basic and general map data from a file. Only known constants are loaded
     * here, everything else has to be loaded on an individual basis.
     *
     * @param filePath
     */
    public static void loadMapFile(String filePath) {
        try {
            Scanner inFile = new Scanner(new FileInputStream(filePath));

            while(inFile.hasNextLine()) {
                String q = inFile.nextLine();
                if(q.startsWith("sp")) {
                    int[] sp = new int[2];
                    sp[0] = Integer.parseInt(inFile.nextLine());
                    sp[1] = Integer.parseInt(inFile.nextLine());
                    Map.setSpawnPoint(sp);
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Map not found.");
        }
    }

    /**
     * Loads any boxes from a map file and returns an ArrayList of Box objects.
     *
     * @param filePath
     * @return
     */
    public static ArrayList loadBoxesFromMapFile(String filePath) {
        ArrayList output = new ArrayList();
        try {
            Scanner inFile = new Scanner(new FileInputStream(filePath));

            while(inFile.hasNextLine()) {
                String q = inFile.nextLine();
                if(q.startsWith("box")) {
                    Box a = new Box(Float.parseFloat(inFile.nextLine()),
                            Float.parseFloat(inFile.nextLine()));
                    output.add(a);
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }
}
