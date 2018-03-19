package engine.filesystem;

import java.util.Scanner;

import static engine.filesystem.Map.*;

public class Commands {

    static Scanner scanner = new Scanner(System.in);

    public static int getInput() {
        int x = 0;
        if(scanner.hasNextLine()==true) {
            String o = scanner.nextLine();

            if (o.startsWith("map ")) {
                try {
                    loadMap(o.replaceAll("map ", ""));
                } catch (Exception e) {
                    System.out.println("No such map.");
                }
            } else if (o == "exit") {
                System.exit(0);
            }
        } else {
            System.out.println("Done");
        }
        return x;
    }
}
