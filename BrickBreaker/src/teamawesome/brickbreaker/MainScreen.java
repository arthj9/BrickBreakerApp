package teamawesome.brickbreaker;

import sofia.graphics.RectangleShape;
import android.view.MotionEvent;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;

/**
 * // -------------------------------------------------------------------------
 * /** Write a one-sentence summary of your class here. Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Jake Martinez, Arth Joshi
 * @version Nov 27, 2012
 */
public class MainScreen
    extends ShapeScreen
{
    private BrickGrid          grid;
    private Bumper             bumper;

    private RectangleShape[][] bricks;
    private RectangleShape     bump;

    private float              rectLength; //length of a brick
    private float              rectWidth; //width of a brick
    private float              width; //width of the screen
    private float              height; //height of the screen
    private float              bumpSize; //width of the bumper
    private int                difficulty; //difficulty setting


    /**
     * initializes the screen
     */
    public void initialize()
    {
        setFields();
        grid = new BrickGrid(7, 4, difficulty); // sets the difficulty
        grid.addObserver(this);

        // --------------------LAYOUT--------------------//
        bumper = new Bumper(width/2, (14*height/15), bumpSize);
        bricks = new RectangleShape[4][7];
        bump =
            new RectangleShape(bumper.getX() - (bumpSize/2), bumper.getY(),
                bumper.getX() + (bumpSize/2), bumper.getY() + height/37);
        bump.setColor(Color.blue);
        bump.setFilled(true);
        add(bump);

        // -----------------BRICK CREATION---------------//
        for (int k = 0; k < 7; k++)
        {
            float x1 = k * rectWidth;
            float x2 = x1 + rectWidth;
            for (int j = 0; j < 3; j++)
            {
                float y1 = j * rectLength;
                float y2 = y1 + rectLength;
                bricks[j][k] = new RectangleShape(x1, y1, x2, y2);
                bricks[j][k].setColor(Color.black);
                bricks[j][k].setFilled(true);
                bricks[j][k].setFillColor(grid.getBrick(j, k).getColor());
                add(bricks[j][k]);
            }

        }
    }


    /**
     * is called when the objects this is observing call the notifyObeservers()
     * method
     */
    public void changeWasObserved()
    {
        for (int k = 0; k < grid.getWidth(); k++)
        {
            for (int j = 0; j < grid.getHeight(); j++)
            {
                if (grid.getBrick(k, j).getStrength() <= 0)
                {
// grid.getBrick(k, j);
                }
            }
        }
    }


    /**
     * is called when the screen is clicked or touched
     */
    public void onTouchDown(MotionEvent e)
    {
        if (e.getX() < (width - (bumpSize / 2)) && e.getX() > (bumpSize / 2))
        {
            int x = (int)e.getX();

            bumper.setX(x - 10);
            bump.setX(x - 10);
        }

    }


    /**
     * is called when a touch or click event moves across the screen
     */
    public void onTouchMove(MotionEvent e)
    {
        onTouchDown(e);
    }

    //-------------private methods-------DO WORK-------------

    /**
     * sets the helper field values
     */
    private void setFields()
    {

        width = getShapeView().getWidth();
        height = getShapeView().getHeight();
        rectLength = height / 12;
        rectWidth = width / 7;
        bumpSize = width / 7;
        difficulty = 4;
    }
}
