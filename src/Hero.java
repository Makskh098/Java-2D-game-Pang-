import java.awt.*;
import java.awt.event.KeyEvent;

public class Hero {
    float x,y;
    float dx,dy;
    int lives;
    float velocity;
    float width;
    private final Color color;

    //Constructor
    public Hero(float x,float y,int lives,float velocity,float width,Color color){
        this.x=x;
        this.y=y;
        this.lives=lives;
        this.velocity=velocity;
        this.width=width;
        this.color=color;
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect((int)(x),(int)(y),(int)(width),(int)(width*2));
    }
    public void movementOfHero(Map map){
        //borders for hero
        float BallMinX= map.minX+width;
        float BallMinY=map.minY+2*width;
        float BallMaxX= map.maxX-width;
        float BallMaxY= map.maxY-2*width;

        // movement by keyboard
        x+=dx;
        //y+=dy;

    }
    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_A || key==KeyEvent.VK_LEFT){
            dx=-velocity;
        }
        if(key==KeyEvent.VK_D || key==KeyEvent.VK_RIGHT){
            dx=velocity;
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
//    public void shoot(){
//    }

}
