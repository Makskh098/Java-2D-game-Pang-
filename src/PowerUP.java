import java.awt.*;

/***
 * PowerUp class implements power up object in game engine
 */
public class PowerUP extends Rectangle {

    int fall_speed;
    int temp_fall_speed;


    /***
     * Constructor
     * @param x horizontal position
     * @param width width of power up
     * @param height height of power up
     * @param fall_speed fall speed of power up
     */
    public PowerUP(int x, int width, int height,int fall_speed){
        super(x,-100,width,height);
        this.fall_speed = fall_speed;
    }

    /***
     * method to spawn power up
     * @param x horizontal position
     * @param y vertical position
     */
    public void spawn(int x, int y){

        if (this.y >= 0){ return;}
        temp_fall_speed = fall_speed;
        if ((this.x = x - width) <= 0){this.x = 0;}
        else{this.x = x - width;}
        this.y = y;
    }

    /***
     * movement of power up in the game
     * @param engine Engine2 object
     */
    public void move(Engine2 engine){

        if(this.y < 0){
            return;
        }
        if(this.y + this.height > engine.height_of_frame){
            this.y = engine.height_of_frame - this.height;
            temp_fall_speed = 0;
        }else {
            this.y += temp_fall_speed;
        }

    }

    /***
     * resets position of power up
     */
    public void reset_position(){
        this.y = -100;
    }

}
