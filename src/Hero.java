import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Hero extends Rectangle {
    int lives;
    float velocity;
    private final Color color;

    //Constructor
    public Hero(float x, float y, float width, float height, int lives,float velocity,Color color){
        super((int)x,(int)y,(int)width,(int)height);
        this.lives=lives;
        this.velocity=velocity;
        this.color=color;
    }

    public void movementOfHero(Engine2 engine) {
        float heroMinX = (float) 0;
        float heroMinY = this.height;
        float heroMaxX = (float) (engine.widht_of_frame - this.width);
        float heroMaxY = engine.height_of_frame - this.height;

        move((int) velocity);
        if (this.x > (int) heroMaxX) {
            this.x = (int) heroMaxX;
        }
        if (this.x < (int) heroMinX) {
            this.x = (int) heroMinX;
        }
    }

    public void move(int px){
            this.x += px ;

        }


    }


