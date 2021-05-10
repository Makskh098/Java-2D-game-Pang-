import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
public class Engine extends JPanel{

    private final DrawCanvas canvas;
    private int canvasWidth;
    private int canvasHeight;

    Map map;
    Ball ball,ball1;

    //Constructor
    //Test Canvasa
    public Engine(int Width,int Height){

        canvasWidth=Width;
        canvasHeight=Height;

        //initiate parameetrs for test
        int radius=50;
        int x=canvasWidth/2;
        int y=0;
        int velocityX=1;
        int velocityY=-4;
        // init map
        map=new Map(0,0,canvasWidth,canvasHeight,Color.GRAY,Color.BLACK);
        //init ball
        ball = new Ball(x,y, velocityX,velocityY,radius,Color.YELLOW);
        ball1 = new Ball(x+canvasWidth/4,y, velocityX,velocityY,radius,Color.RED);

        canvas = new DrawCanvas();
        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);

        // Handling window resize test
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component)e.getSource();
                Dimension dim = c.getSize();
                canvasWidth = dim.width;
                canvasHeight = dim.height;
                map.set(0, 0, canvasWidth, canvasHeight);
            }
        });

        gameStart();

    }
//Start game
    //TODO zrobic podwojne bufforowanie;
    public void gameStart(){
        Thread gameThread = new Thread(() -> {
            while (true){
                gameUpdate();
                repaint();
                try {
                    Thread.sleep(1000 / ConfigData.update_rate);
                } catch (InterruptedException ignored) {}

            }
        });
        gameThread.start();
    }
    public  void gameUpdate(){
        ball.movementOffBall(map);
        ball1.movementOffBall(map);
    }


class DrawCanvas extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        map.draw(g);
        ball.draw(g);
        ball1.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(canvasWidth, canvasHeight));
    }
}
}
