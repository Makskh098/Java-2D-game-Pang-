import javax.swing.*;
import java.awt.*;
import java.util.Formatter;

public class Ball {
    float x,y;
    float VelocityX,VelocityY;
    float radius;
    private Color color;
    private static final Color DEFAULT_COLOR = Color.RED;
    //Constructor
    public Ball(float x,float y,float velocityX,float velocityY,float radius,Color color){
        this.x=x;
        this.y=y;
        this.VelocityX=velocityX;
        this.VelocityY=velocityY;
        this.radius=radius;
        this.color=color;
    }
    //Draw
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)(x-radius),(int)(y-radius),(int)(2*radius),(int)(2*radius));
    }

    //movement of ball on map
    public void movementOffBall(Map map){
        // borders for ball's position
        float BallMinX= map.minX+radius;
        float BallMinY=map.minY+radius;
        float BallMaxX= map.maxX+radius;
        float BallMaxY= map.maxY+radius;

        // changing position of ball- 1 step
        x +=VelocityX;
        y +=VelocityY;

        //Ball's movement inside borders of map
        // axis X
        if(x > BallMaxX){
            VelocityX=(-VelocityX); // reflection
            x=BallMaxX;
        }
        else if(x < BallMinX){
            VelocityX=(-VelocityX); // reflection
            x=BallMinX;
        }
        // axis Y
        if(y > BallMaxY){
            VelocityY=(-VelocityY); // reflection
            y=BallMaxY;
        }
        else if(y < BallMinY){
            VelocityY=(-VelocityY); // reflection
            y=BallMinY;
        }
    }
}
