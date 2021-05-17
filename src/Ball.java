import java.awt.*;

public class Ball {
    float x,y;
    float VelocityX,VelocityY;
    float radius;
    float scaley = 1;
    float scalex = 1;
    private final Color color;
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

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.scale(scalex, scaley);
        g2d.setColor(color);
        g2d.fillOval((int)(x-radius),(int)(y-radius),(int)(2*radius),(int)(2*radius));
    }

    //movement of ball on map
    public void movementOffBall(Map map){
        // borders for ball's position
        float BallMinX= map.minX+radius;
        float BallMinY=map.minY+radius;
        float BallMaxX= map.maxX-radius;
        float BallMaxY= map.maxY-radius;

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
        else if(y < BallMinY) {
            VelocityY = (-VelocityY); // reflection
            y = BallMinY;
        }
    }
}
