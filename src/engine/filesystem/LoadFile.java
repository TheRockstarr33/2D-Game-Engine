package engine.filesystem;

import engine.objects.Box;

import java.util.ArrayList;
import java.util.List;
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
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList loadBoxesFromMapFile(String filePath) {
        ArrayList output = new ArrayList();
        try {
            Scanner inFile = new Scanner(new FileInputStream(filePath));

            while(inFile.hasNextLine()) {
                String q = inFile.nextLine();
                if(q.startsWith("box")) {
                    Box a = new Box(Integer.parseInt(inFile.nextLine()),
                            Integer.parseInt(inFile.nextLine()));
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
