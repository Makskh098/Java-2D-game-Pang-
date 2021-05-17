import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Engine2 extends JPanel implements ActionListener, KeyListener {
    Timer timer;
    ArrayList<Ball_2D> ball_list = new ArrayList<>();
    Hero hero;
    int widht_of_frame;
    int height_of_frame;
    private double scalex = 1;
    private double scaley = 1;
    //Ray ray;



    public Engine2(int widht, int height){
        timer = new Timer(5, this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer.start();
        widht_of_frame = widht;
        height_of_frame = height;
        load_map(1);

    }


    public void paint( Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.scale(scalex, scaley);

        g2d.fill(hero);
    }



    public void load_map(int i){
        hero = new Hero((float) (widht_of_frame/2.0 - 30/2), height_of_frame -30,30,30,ConfigData.number_of_lives, 0 ,Color.BLUE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hero.movementOfHero(this);
        scalex = (float)this.getWidth()/widht_of_frame;
        scaley = (float)this.getHeight()/height_of_frame;
        repaint();
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
            hero.velocity = (float) -ConfigData.speed_of_player;
            }

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            hero.velocity = (float) ConfigData.speed_of_player ;
            }
        }


        @Override
        public void keyReleased(KeyEvent e) {
        hero.velocity = 0;
        }


}
