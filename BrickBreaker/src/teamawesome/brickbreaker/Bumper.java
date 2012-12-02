package teamawesome.brickbreaker;

/**
 * // -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Jake Martinez, Arth Joshi
 *  @version Nov 27, 2012
 */
public class Bumper
{
    private float x;
    private float y;
    private float width;

    public Bumper(float initX, float initY, float initW)
    {
        x = initX;
        y = initY;
        width = initW;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getWidth()
    {
        return width;
    }

    public void setX(float newX)
    {
        x = newX;
    }
}
