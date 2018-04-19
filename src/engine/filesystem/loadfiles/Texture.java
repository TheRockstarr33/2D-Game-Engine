package engine.filesystem.loadfiles;

import org.lwjgl.stb.*;
import sun.awt.image.PNGImageDecoder;

import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.stb.STBImage.stbi_load;

public class Texture {

    public static void loadTexture(String filePath) {
        int texId = 0;
        int width;
        int height;
        int nrChannels;
//        char data[] = stbi_load(filePath, width, height, nrChannels, 0);

//        PNGImageDecoder pngdecoder = new PNGImageDecoder();
    }
}
