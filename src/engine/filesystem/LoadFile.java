package engine.filesystem;

import java.util.Scanner;
import java.io.*;

public class LoadFile {

    private static int[] spawnPoint = new int[2];

    public static String[] loadMapFile(String filePath) {
        try {
            Scanner inFile = new Scanner(new FileInputStream(filePath));

            while(inFile.hasNextLine()) {
                String q = inFile.nextLine();
                if(q.startsWith("sp")) {
                    spawnPoint = q.replace("sp ", "");
                }
            }

            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return a;
    }
}
