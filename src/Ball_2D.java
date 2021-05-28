import java.awt.geom.Ellipse2D;

/***
 *Ball_2D class that extends ELLipse2D.Float by adding vertical and horizontal speeds also implements movement method
 */

public class Ball_2D extends Ellipse2D.Float{
    public float speedx;
    public float speedy;
    public double ball_dy;
    double gravity = -0.05;
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
        this.ball_dy = 0;
    }

    public Ball_2D(float x, float y, float height, float width,float speedx, float speedy, int ball_dy){
        super(x,y,width,height);
        this.speedx = speedx;
        this.speedy = speedy;
        this.ball_dy = ball_dy;
    }

    /***
     * Implements movement of ball
     * @param engine engine where ball i used to get width and height of Jframe
     */
    public void movement(Engine2 engine) {
        float BallMinX = (float) 0;
        float BallMinY = 10;
        float BallMaxX = engine.width_of_frame - this.width;
        float BallMaxY = engine.height_of_frame - this.height;

        // changing position of ball- 1 step
        x += speedx;

        // gravity element
        ball_dy -= gravity;
        y += ball_dy;


        //Ball's movement inside borders of map
        // axis X
        if (x > BallMaxX) {
            speedx = (-speedx); // reflection
            x = BallMaxX;
        }

        if (x < BallMinX) {
            speedx= (-speedx); // reflection
            x = BallMinX;
        }

        // axis Y
        if (y > BallMaxY) {
            ball_dy *= -1; // reflection
            y = BallMaxY;
        }

        if (y < BallMinY) {
             // reflection
            y = BallMinY;
        }
    }

    }

