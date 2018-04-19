package engine.filesystem.loadfiles;

import engine.filesystem.Map;
import engine.objects.Box;
import org.apache.commons.io.FileUtils;

import java.util.ArrayList;
import java.util.List;
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
                    float v1 = Float.parseFloat(inFile.nextLine());
                    float v2 = Float.parseFloat(inFile.nextLine());
                    int v3 = Integer.parseInt(inFile.nextLine());

                    Box a = new Box(v1, v2, v3);

                    output.add(a);
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Map " + filePath + " not found");
        }
        return output;
    }
}
