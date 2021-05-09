import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
public class Engine extends JPanel{

    private static final int UPDATE_RATE = 30;// powinno byc z Configa
    private DrawCanvas canvas;
    private int canvasWidth;
    private int canvasHeight;

    Map map;
    Ball ball;

    //Constructor
    //Test Canvasa
    public Engine(int Width,int Height){

        canvasWidth=Width;
        canvasHeight=Height;

        //initiate parameetrs for test
        Random rand = new Random();
        int radius=200;
        int x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
        int y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
        int velocityX=5;
        int velocityY=5;
        // init map
        map=new Map(0,0,canvasWidth,canvasHeight,Color.GRAY,Color.BLUE);
        //init ball
        ball = new Ball(x,y, velocityX,velocityY,radius,Color.YELLOW);

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
        Thread gameThread = new Thread(){
            public void run(){
                while (true){
                    gameUpdate();
                    repaint();
                    try {
                        Thread.sleep(1000 / UPDATE_RATE);
                    } catch (InterruptedException ex) {}

                }
            }
        };
        gameThread.start();
    }
    public  void gameUpdate(){
        ball.movementOffBall(map);
    }


class DrawCanvas extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        map.draw(g);
        ball.draw(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 12));

    }

    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(canvasWidth, canvasHeight));
    }
}
}
