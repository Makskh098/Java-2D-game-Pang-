import java.awt.*;
/***
 * Class describes behavior of hero and it's basic parameters
 */
public class Hero extends Rectangle {
    int lives;
    float velocity;
    private final Color color;

    /***
     * Constructor Hero's Class
     * @param x horizontal position of hero
     * @param y vertical position of hero
     * @param width width of hero
     * @param height height of hero
     * @param lives number of player's lives
     * @param velocity velocity of hero
     * @param color color of hero
     */
    public Hero(float x, float y, float width, float height, int lives,float velocity,Color color){
        super((int)x,(int)y,(int)width,(int)height);
        this.lives=lives;
        this.velocity=velocity;
        this.color=color;
    }

    /***
     * Method describes how hero is moving in closed space
     * @param engine is used to get boundaries
     */
    public void movementOfHero(Engine2 engine) {
        float heroMinX = (float) 0;
        float heroMaxX = (float) (engine.width_of_frame - this.width);

        move((int) velocity);
        if (this.x > (int) heroMaxX) {
            this.x = (int) heroMaxX;
        }
        if (this.x < (int) heroMinX) {
            this.x = (int) heroMinX;
        }
    }

    /***
     * defines movement of hero
     * @param px is used to set hero's step in every frame
     */
    public void move(int px){
            this.x += px ;

        }


    }


