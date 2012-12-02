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
public class BrickGrid extends sofia.util.Observable
{
    private Brick[][] grid;

    public BrickGrid(int width, int height, int difficulty)
    {
        grid = new Brick[height][width];

        for (int k = 0; k < grid.length; k++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                grid[k][j] = new Brick(difficulty);
                grid[k][j].addObserver(this);
            }
        }
    }

    public Brick getBrick(int x, int y)
    {
        return grid[x][y];
    }

    public int getWidth()
    {
        return grid.length;
    }

    public int getHeight()
    {
        return grid[0].length;
    }

    public void changeWasObserved()
    {
        for (int k = 0; k < grid.length; k++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[k][j].getStrength() <= 0)
                {
                    grid[k][j] = null;
                }
            }
        }
    }


}
