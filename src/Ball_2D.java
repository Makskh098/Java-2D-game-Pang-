import java.awt.geom.Ellipse2D;

/***
 *Ball_2D class that extends ELLipse2D.Float by adding vertical and horizontal speeds also implements movement method
 */

public class Ball_2D extends Ellipse2D.Float{
    public float speedx;
    public float speedy;

    /***
     * Constructor
     * @param x horizontal position
     * @param y vertical position
     * @param height height of ellipse
     * @param width width of ellipse
     * @param speedx horizontal speed
     * @param speedy vertical speed
     */

    public Ball_2D(float x, float y, float height, float width,float speedx, float speedy){
        super(x,y,width,height);
        this.speedx = speedx;
        this.speedy = speedy;
    }

    /***
     * Implements movement of ball
     * @param engine engine where ball i used to get width and height of Jframe
     */
    public void movement(Engine2 engine) {
        float BallMinX = (float) 0;
        float BallMinY = this.height;
        float BallMaxX = (engine.width_of_frame - this.width);
        float BallMaxY = engine.height_of_frame - this.height;

        // changing position of ball- 1 step
        x += speedx;
        y += speedy;

        //Ball's movement inside borders of map
        // axis X
        if (x > BallMaxX) {
            speedx = (-speedx); // reflection
            x = BallMaxX;
        }  if (x < BallMinX) {
            speedx= (-speedx); // reflection
            x = BallMinX;
        }
        // axis Y
        if (y > BallMaxY) {
            speedy = (-speedy); // reflection
            y = BallMaxY;
        }  if (y < BallMinY) {
            speedy = (-speedy); // reflection
            y = BallMinY;
        }
    }

    }

