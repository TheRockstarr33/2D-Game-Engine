package engine.core;

import engine.filesystem.Map;
import engine.filesystem.loadfiles.LoadFile;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengles.GLES20.*;
import static org.lwjgl.opengles.GLES30.glGenVertexArrays;
import static org.lwjgl.system.MemoryUtil.memFree;

public class Renderer {

    private static int vaoId = 0;
    private static int vboId = 0;
    static ShaderProgram shaderProgram;

//    public static void setupQuad() {
//        float[] vertices = {
//                -0.5f, 0.5f, 0f,
//                -0.5f, -0.5f, 0f,
//                0.5f, -0.5f, 0f,
//                0.5f, -0.5f, 0f,
//                0.5f, 0.5f, 0f,
//                -0.5f, 0.5f, 0f
//        };
//
//        FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
//        verticesBuffer.put(vertices);
//        verticesBuffer.flip();
//
//        //Create VAO in memory
//        vaoId = GL30.glGenVertexArrays();
//        GL30.glBindVertexArray(vaoId);
//
//        vboId = GL15.glGenBuffers();
//        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboId);
//        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, verticesBuffer, GL15.GL_STATIC_DRAW);
//
//        GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
//
//        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
//
//        GL30.glBindVertexArray(0);
//    }

    /**
     * Returns a float array with the information about each vertex in a given quad.
     *
     * @param sizeX
     * @param sizeY
     * @param posX
     * @param posY
     * @return
     */
    public static float[] getQuadVertexArray(float sizeX, float sizeY, float posX,
                                             float posY) {
        //These float arrays each represent one vertex of the quad. The first index
        //represents the X axis, and the second represents the Y axis.
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

        float[] vertices = new float[]{
                a[0], a[1],
                b[0], b[1],
                c[0], c[1],
                d[0], d[1]
        };

//        float[] vertices = new float[]{
//                // "B" triangle
//                a[0], a[1],
//                b[0], b[1],
//                c[0], c[1],
//                // "D" triangle
//                a[0], a[1],
//                c[0], c[1],
//                d[0], d[1]
//        };

        return vertices;
    }

//    public static void initRenderer() throws Exception {
//        shaderProgram = new ShaderProgram();
//        //Depends on OS and location, change in the future
//        String vShader = LoadFile.loadFile("./vertex.vs");
//        String fShader = LoadFile.loadFile("./fragment.fs");
//
//        String fShader = LoadFile.loadFile("/home/davidr/2D Game Engine/2D-Game-Engine/fragment.fs");
//        if(vShader != null) {
//            shaderProgram.createVertexShader(vShader);
//        }
//        if(fShader != null) {
//            shaderProgram.createFragmentShader(fShader);
//        }
//        shaderProgram.link();
//
//        float[] vertexArray = {
//                -0.5f, 0.5f, 0f,
//                -0.5f, -0.5f, 0f,
//                0.5f, -0.5f, 0f,
//                0.5f, -0.5f, 0f,
//                0.5f, 0.5f, 0f,
//                -0.5f, 0.5f, 0f
//        };
//
//        FloatBuffer verticesBuffer = MemoryUtil.memAllocFloat(vertexArray.length);
//        verticesBuffer.put(vertexArray).flip();
//
//        vaoId = glGenVertexArrays(); //Is the right import being used here?
//        glBindVertexArray(vaoId);
//
//        vboId = glGenBuffers();
//        glBindBuffer(GL_ARRAY_BUFFER, vboId);
//        glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
//        memFree(verticesBuffer);
//
//        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
//
//        glBindBuffer(GL_ARRAY_BUFFER, 0);
//        glBindVertexArray(0);
//
//        if (verticesBuffer != null) {
//            memFree(verticesBuffer);
//        }
//    }

//    public static void initQuad(float[] vertexArray) {
//        FloatBuffer verticesBuffer = MemoryUtil.memAllocFloat(vertexArray.length);
//        verticesBuffer.put(vertexArray).flip();
//
//        vaoId = glGenVertexArrays(); //Is the right import being used here?
//        glBindVertexArray(vaoId);
//
//        vboId = glGenBuffers();
//        glBindBuffer(GL_ARRAY_BUFFER, vboId);
//        glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
//        memFree(verticesBuffer);
//
//        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
//
//        glBindBuffer(GL_ARRAY_BUFFER, 0);
//        glBindVertexArray(0);
//
//        if (verticesBuffer != null) {
//            memFree(verticesBuffer);
//        }
//    }

    /**
     * Renders one untextured quad.
     *
     * Parameters are for the size of the quad and the position, starting from the
     * upper left corner.
     */
//    public static void renderQuad(String texPath) {

//        glDrawArrays(GL11.GL_QUADS, 0, 4); //Make sure these are what we need


//        glTexCoord2f(0, 0);
//        glVertex2f(a[0], a[1]);
//        glTexCoord2f(1, 0);
//        glVertex2f(b[0], b[1]);
//        glTexCoord2f(1, 1);
//        glVertex2f(c[0], c[1]);
//        glTexCoord2f(0, 1);
//        glVertex2f(d[0], d[1]);
//    }

//    public static void render(int vaoID) {
//        shaderProgram.bind();
//
//        glBindVertexArray(vaoId);
//        glEnableVertexAttribArray(0);
//
//        glDrawArrays(GL11.GL_QUADS, 0, 4);
//
//        renderQuad(""); //Just for testing right now
//
//        glDisableVertexAttribArray(0);
//        glBindVertexArray(0);
//
//        shaderProgram.unbind();
//    }

    /**
     * Sends all rendering info to the window.
     * TODO: Remove this code, replace with more efficient system
     */
    public static void getRenderInfo() {
        //THIS IS JUST FOR TESTING. Needs to be modified to send info from objects.
//        render();
        Map.drawBoxes();



    }
}
