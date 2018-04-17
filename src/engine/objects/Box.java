package engine.objects;

import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

import static engine.core.Renderer.getQuadVertexArray;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
import static org.lwjgl.opengles.GLES20.GL_ARRAY_BUFFER;
import static org.lwjgl.opengles.GLES20.glGenBuffers;
import static org.lwjgl.opengles.GLES20.glVertexAttribPointer;
import static org.lwjgl.system.MemoryUtil.memFree;

public class Box {

    public static int numOfBoxes;
    float x;
    float y;
    int tex;
    private int vaoId = 0;
    private int vboId = 0;

    public Box(float x, float y, int tex) {
        this.x=x;
        this.y=y;
        this.tex=tex;
        //We can add more variables here if we need to, like size or how it looks
        numOfBoxes++; //Necessary???
    }

    /**
     * Returns the coordinates in an int array, with index 0 being the x coordinate
     * and index 1 being the y coordinate.
     *
     * @return
     */
    public float[] getCoordinates() {
        float[] a = new float[2];
        a[0] = this.x;
        a[1] = this.y;
        return a;
    }

    /**
     * Handles the code for rendering a box
     */
    public void renderBox() {
        float[] i = getCoordinates();
//        renderQuad(getTexturePath(), vaoId);
    }

    public void initBox() {
        float[] i = getCoordinates();
        float[] v = getQuadVertexArray(0.2f, 0.2f, i[0], i[1]);
        FloatBuffer verticesBuffer = MemoryUtil.memAllocFloat(v.length);
        verticesBuffer.put(v).flip();

        vaoId = glGenVertexArrays(); //Is the right import being used here?
        glBindVertexArray(vaoId);

        vboId = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboId);
        glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
        memFree(verticesBuffer);

        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);

        if (verticesBuffer != null) {
            MemoryUtil.memFree(verticesBuffer);
        }
    }

    /**
     * Gets the proper texture path for the type of box being displayed
     *
     * @return
     */
    public String getTexturePath() {
        if(tex==0) {
            return "textures/qBlock.png";
        }
        return null;
    }
}
