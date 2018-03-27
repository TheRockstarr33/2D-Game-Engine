package engine.core;

import engine.filesystem.Map;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import javax.xml.soap.Text;
import java.io.IOException;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.glTexCoord1d;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Renderer {

    private static int vaoId = 0;
    private static int vboId = 0;

    public static void setupQuad() {
        float[] vertices = {
                -0.5f, 0.5f, 0f,
                -0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, 0.5f, 0f,
                -0.5f, 0.5f, 0f
        };

        FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
        verticesBuffer.put(vertices);
        verticesBuffer.flip();

        //Create VAO in memory
        vaoId = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vaoId);

        vboId = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboId);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, verticesBuffer, GL15.GL_STATIC_DRAW);

        GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        GL30.glBindVertexArray(0);
    }


    //Not working, for use with slick-util
//    public static Texture loadTexture(String path) {
//        Texture texture;
//        try {
//            //Add if statement for different filetypes in the future
//            texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("textures/qBlock.png"));
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error loading texture");
//            texture = null;
//        }
//        return texture;
//    }

    /**
     * Renders one untextured quad.
     *
     * Parameters are for the size of the quad and the position, starting from the
     * upper left corner.
     *
     * @param sizeX
     * @param sizeY
     * @param posX
     * @param posY
     */
    public static void renderQuad(float sizeX, float sizeY, float posX, float posY, String texPath) {
        //These float arrays each represent one vertex of the quad. The first index
        //represents the X axis, and the second represents the Y axis.


//        loadTexture(texPath).bind();

        float[] a = new float[2];
        float[] b = new float[2];
        float[] c = new float[2];
        float[] d = new float[2];

        a[0] = posX + sizeX;
        a[1] = posY;
        b[0] = posX;
        b[1] = posY;
        c[0] = posX;
        c[1] = posY - sizeY;
        d[0] = posX + sizeX;
        d[1] = posY - sizeY;

        glTexCoord2f(0, 0);
        glVertex2f(a[0], a[1]);
        glTexCoord2f(1, 0);
        glVertex2f(b[0], b[1]);
        glTexCoord2f(1, 1);
        glVertex2f(c[0], c[1]);
        glTexCoord2f(0, 1);
        glVertex2f(d[0], d[1]);

//        setupQuad();
//
//        GL30.glBindVertexArray(vaoId);
//        GL20.glEnableVertexAttribArray(0);
//
//        GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 6);
//
//        GL20.glDisableVertexAttribArray(0);
//        GL30.glBindVertexArray(0);
    }

    /**
     * Sends all rendering info to the window.
     */
    public static void getRenderInfo() {
        //THIS IS JUST FOR TESTING. Needs to be modified to send info from objects.
        Map.drawBoxes();
    }
}
