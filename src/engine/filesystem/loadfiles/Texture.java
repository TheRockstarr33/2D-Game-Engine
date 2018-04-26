package engine.filesystem.loadfiles;

import de.matthiasmann.twl.utils.PNGDecoder;

import java.io.*;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;
import static org.lwjgl.opengles.GLES20.GL_RGB;
import static org.lwjgl.opengles.GLES20.glTexImage2D;
import static org.lwjgl.stb.STBImage.*;

public class Texture {

    public static int loadTexture(String filePath, int width, int height) {
//        int tID = texid;
        int tID = glGenTextures();
//        int[] texId = {tID};
        int w = width;
        int[] widthArray = {width};
        int h = height;
        int[] heightArray = {height};
        int[] nrChannels = {16}; //Change these variables in the future

//        ByteBuffer imageBuffer;
//        try{
//            imageBuffer = ioResourceToByteBuffer(filePath, 8*1024);
//        } catch (IOException e) {
//            System.out.println("Could not load texture. ");
//        }

        glBindTexture(GL_TEXTURE_2D, tID);

        //Set the texture parameters
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);



        /***************/
        FileInputStream in = null;
        ByteBuffer buffer = null;
        try {
            in = new FileInputStream(filePath);

        if(in != null) {
            PNGDecoder decoder = new PNGDecoder(in);

            //create a byte buffer big enough to store RGBA values
            buffer = ByteBuffer.allocateDirect(4 * decoder.getWidth() * decoder.getHeight());

            //decode
            decoder.decode(buffer, decoder.getWidth() * 4, PNGDecoder.Format.RGBA);

            //flip the buffer so its ready to read
            buffer.flip();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }


        /****************/

        //Load and generate the textures
//        ByteBuffer data = stbi_load(filePath, widthArray, heightArray, nrChannels, 4);

        try {
            if (buffer != null) {
                glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, w, h, 0, GL_RGB, GL_UNSIGNED_BYTE, buffer);

                glGenerateMipmap(GL_TEXTURE_2D);
            } else {
                System.out.println("Failed to load texture " + filePath);
            }
        } catch (Exception e) {

        }
//        stbi_image_free(data);


        return tID;
    }
}
