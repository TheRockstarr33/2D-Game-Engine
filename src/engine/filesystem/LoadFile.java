package engine.filesystem;

import java.util.Scanner;
import java.io.*;

public class LoadFile {

    private static int[] spawnPoint = new int[2];

    public static void loadMapFile(String filePath) {
        try {
            Scanner inFile = new Scanner(new FileInputStream(filePath));

            while(inFile.hasNextLine()) {
                String q = inFile.nextLine();
                if(q.startsWith("sp")) {
                    spawnPoint[0] = Integer.parseInt(inFile.nextLine());
                    spawnPoint[1] = Integer.parseInt(inFile.nextLine());
                }
                if(q.startsWith("box")) {

                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
