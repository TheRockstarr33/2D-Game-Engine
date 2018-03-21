package engine.filesystem;

import engine.objects.Box;

import java.util.Scanner;
import java.io.*;

public class LoadFile {

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
                if(q.startsWith("box")) {
                    new Box(Integer.parseInt(inFile.nextLine()), Integer.parseInt(inFile.nextLine()));
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
