package teamawesome.brickbreaker;

import sofia.graphics.Color;

/**
 * // -------------------------------------------------------------------------
/**
 *  This class represents a Brick object to be used in the Brick Breaker app
 *
 *  @author Jake Martinez, Arth Joshi
 *  @version Nov 27, 2012
 */
public class Brick extends sofia.util.Observable
{
    private int strength;

    /**
     * creates a new Brick object
     * @param s represents the strength of the brick
     */
    public Brick(int s)
    {
        strength = s;
    }

    /**
     * decreases the strength of the brick by 1
     */
    public void isHit()
    {
        strength--;
        notifyObservers();
    }

    /**
     * gets the strength of the brick
     * @return strength
     */
    public int getStrength()
    {
        return strength;
    }

    public Color getColor()
    {
        switch (strength)
        {
            case 1: return Color.lightSalmon;
            case 2: return Color.red;
            case 3: return Color.darkRed;
            case 4: return Color.maroon;
        }
        return null;
    }
}
