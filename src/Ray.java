import java.awt.*;

public class Ray extends Rectangle {
    float velocity;
    boolean shoot = false;

    public Ray(float x, float y, float width, float height, float velocity){
        super((int) x , (int) y + 1, (int) width, (int) height);
        this.velocity = velocity;

    }

    public void shoot(){shoot = true;}

    public void movementOfRay(Engine2 engine){

        if (!this.shoot){ return;}

        // move only vertical when is fired
        if (y < engine.height_of_frame  && y > 0 ){
            y -=velocity;
            return; }

        // check collision of upper frame
        if ( y < 0){
            y = engine.height_of_frame + 1; // move below frame
            this.shoot = false; // block shoot
            return;
        }

        // set horizontal position to position of hero
        x = (int) engine.hero.getX() + engine.hero.width/2 - this.width/2;
        y -= velocity; //start vertical movement

    }

    public void reset(Engine2 engine){
        y = engine.height_of_frame + 1; // move below frame
        this.shoot = false; // block shoot
    }
}
