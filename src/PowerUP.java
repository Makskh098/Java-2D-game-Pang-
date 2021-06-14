import java.awt.*;

public class PowerUP extends Rectangle {

    int fall_speed;
    int temp_fall_speed;

    public PowerUP(int x, int width, int height,int fall_speed){
        super(x,-100,width,height);
        this.fall_speed = fall_speed;
    }

    public void spawn(int x, int y){

        if (this.y >= 0){ return;}
        temp_fall_speed = fall_speed;
        this.x = x;
        this.y = y;
    }

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

    public void reset_position(){
        this.y = -100;
    }

}
