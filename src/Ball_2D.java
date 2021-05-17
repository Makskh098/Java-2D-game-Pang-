import java.awt.geom.Ellipse2D;

public class Ball_2D extends Ellipse2D.Float{
    public float speedx;
    public float speedy;

    public Ball_2D(float x, float y, float height, float width,float speedx, float speedy){
        super(x,y,width,height);
        this.speedx = speedx;
        this.speedy = speedy;
    }

    public void movement(Engine2 engine) {
        //TODO
        float BallMinX = (float) 0;
        float BallMinY = this.height;
        float BallMaxX = (float) (engine.width_of_frame - this.width);
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

