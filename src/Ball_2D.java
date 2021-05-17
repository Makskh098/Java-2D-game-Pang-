import java.awt.geom.Ellipse2D;

public class Ball_2D extends Ellipse2D.Float{
    public float speedx;
    public float speedy;

    public Ball_2D(float x, float y, float height, float width,float speedx, float speedy){
        super(x,y,width,height);
        this.speedx = speedx;
        this.speedy = speedy;
    }

    public void movement(){
        //TODO

    }

}
