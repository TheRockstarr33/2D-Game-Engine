package engine.core;

import engine.filesystem.Map;
import engine.filesystem.loadfiles.LoadFile;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

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

        return vertices;
    }

    public static void initRenderer() throws Exception {
        shaderProgram = new ShaderProgram();
        shaderProgram.createVertexShader(LoadFile.loadFile("/vertex.vs"));
        shaderProgram.createFragmentShader(LoadFile.loadFile("/fragment.fs"));
        shaderProgram.link();
    }

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
//            MemoryUtil.memFree(verticesBuffer);
//        }
//    }

    /**
     * Renders one untextured quad.
     *
     * Parameters are for the size of the quad and the position, starting from the
     * upper left corner.
     */
    public static void renderQuad(String texPath, int vaoID) {
        shaderProgram.bind();

        glBindVertexArray(vaoID);
        glEnableVertexAttribArray(0);

        glDrawArrays(GL_QUADS, 0, 4);//Make sure these are what we need

        glDisableVertexAttribArray(0);
        glBindVertexArray(0);

        shaderProgram.unbind();

//        glTexCoord2f(0, 0);
//        glVertex2f(a[0], a[1]);
//        glTexCoord2f(1, 0);
//        glVertex2f(b[0], b[1]);
//        glTexCoord2f(1, 1);
//        glVertex2f(c[0], c[1]);
//        glTexCoord2f(0, 1);
//        glVertex2f(d[0], d[1]);
    }

    /**
     * Sends all rendering info to the window.
     */
    public static void getRenderInfo() {
        //THIS IS JUST FOR TESTING. Needs to be modified to send info from objects.
        Map.drawBoxes();
    }
}
