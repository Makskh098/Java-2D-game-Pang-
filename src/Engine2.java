import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/***
 *  Class Engine2 implements game physics,movement of every object in game and graphic animations of those objects.Also it handles controls.
 *  Class extends JPanel and implements ActionListener and KeyListener
 */
public class Engine2 extends JPanel implements ActionListener, KeyListener {
    Timer timer;
    JFrame frame_g;
    ArrayList<Ball_2D> ball_list_small = new ArrayList<>();
    ArrayList<Ball_2D> ball_list_medium = new ArrayList<>();
    ArrayList<Ball_2D> ball_list_large = new ArrayList<>();
    ArrayList<Ball_2D> ball_list_extra_large = new ArrayList<>();
    private final Set<Integer> pressedKeys = new HashSet<>();
    Hero hero;
    int lives;
    int width_of_frame;
    int height_of_frame;
    private double scaleX = 1;
    private double scaleY = 1;
    public int level_number;
    public int current_level;
    //Ray ray;

    /***
     *  Constructor of Class Engine2
     * @param width defines width of map
     * @param height defines height of map
     */
    public Engine2(int width, int height, JFrame frame){
        frame_g = frame;
        width_of_frame = width;
        height_of_frame = height;

        level_number = ConfigData.number_of_levels;
        lives = ConfigData.number_of_lives;

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(5, this);
        timer.start();

        current_level = 0;
        load_map(0);

    }

    /***
     * Method painComponent is responsible for drawing animated graphic in game
     * @param g holds graphic object that will be modified
     */
    public void paintComponent( Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.scale(scaleX, scaleY);

        g2d.setColor(Color.MAGENTA);
        for (Ball_2D ele: ball_list_small) {
            g2d.fill(ele);
        }
        g2d.setColor(Color.BLUE);
        for (Ball_2D ele: ball_list_medium) {
            g2d.fill(ele);
        }
        g2d.setColor(Color.GREEN);
        for (Ball_2D ele: ball_list_large) {
            g2d.fill(ele);
        }
        g2d.setColor(Color.YELLOW);
        for (Ball_2D ele: ball_list_extra_large) {
            g2d.fill(ele);
        }
        g2d.setColor(Color.BLACK);
        g2d.fill(hero);
        g2d.dispose();

    }


    /***
     * Method is responsible for creating objects that will appear on map, it loads Configuration data from ConfigMap and creates individual objects
     * @param i this parameter describes which stage is currently loaded
     */
    public void load_map(int i){
        ConfigMap map = ConfigData.List_of_Config_of_Maps.get(i);
        int number_of_small_balls = (int)(map.number_of_balls* map.percent_of_small_balls);
        int number_of_medium_balls = (int)(map.number_of_balls* map.percent_of_medium_balls);
        int number_of_large_balls = (int)(map.number_of_balls* map.percent_of_large_balls);
        int number_of_extraLarge_balls = (int)(map.number_of_balls* map.percent_of_extraLarge_balls);
        hero = new Hero((float) (width_of_frame/2 - 30/2), height_of_frame -30,30,30,lives, 0 ,Color.BLUE);


        ball_list_small.clear();
        for (int j = 0; j < number_of_small_balls; j++) {
            ball_list_small.add(new Ball_2D((float)(width_of_frame*j /number_of_small_balls),10,(float)ConfigData.radius_of_small_ball,(float) ConfigData.radius_of_small_ball,(float) ConfigData.const_Xball_speed_value,(float) ConfigData.const_Xball_speed_value));
        }
        ball_list_medium.clear();
        for (int j = 0; j < number_of_medium_balls; j++) {
            ball_list_medium.add(new Ball_2D((float)(width_of_frame*j /number_of_medium_balls),10,(float)ConfigData.radius_of_medium_ball,(float) ConfigData.radius_of_medium_ball,(float) ConfigData.const_Xball_speed_value,(float) ConfigData.const_Xball_speed_value));
        }
        ball_list_large.clear();
        for (int j = 0; j < number_of_large_balls; j++) {
            ball_list_large.add(new Ball_2D((float)(width_of_frame*j /number_of_large_balls),10,(float)ConfigData.radius_of_large_ball,(float) ConfigData.radius_of_large_ball,(float) ConfigData.const_Xball_speed_value,(float) ConfigData.const_Xball_speed_value));
        }
        ball_list_extra_large.clear();
        for (int j = 0; j < number_of_extraLarge_balls; j++) {
            ball_list_extra_large.add(new Ball_2D((float)(width_of_frame*j /number_of_extraLarge_balls),10,(float)ConfigData.radius_of_extraLarge_ball,(float) ConfigData.radius_of_extraLarge_ball,(float) ConfigData.const_Xball_speed_value,(float) ConfigData.const_Xball_speed_value));
        }

        frame_g.setTitle("Level-" + (current_level+1) + " " + "Lives-" + lives + " " + "p-stop/play");
    }

    /***
     * Method collision detects if any of ball on the map intersects with certain object
     * @param hitbox holds object that will be checked if intersects with balls
     * @return boolean if true then it means any of ball intersects with object
     */
    public boolean collision(Rectangle hitbox){
        boolean result;
        for (Ball_2D ele: ball_list_small) {
            result = ele.intersects(hitbox);
            if (result) {return true;}
        }
        for (Ball_2D ele: ball_list_medium) {
            result = ele.intersects(hitbox);
            if (result) {return true;}
        }
        for (Ball_2D ele: ball_list_large) {
            result = ele.intersects(hitbox);
            if (result) {return true;}
        }
        for (Ball_2D ele: ball_list_extra_large) {
            result = ele.intersects(hitbox);
            if (result) {return true;}
        }
        return false;
    }

    public void gameOver(){
        repaint();
        frame_g.setTitle("Level-" + (current_level+1) + " " + "Lives-" + lives);
        JOptionPane.showMessageDialog(this, "Game Over", "", JOptionPane.INFORMATION_MESSAGE);
        frame_g.dispatchEvent(new WindowEvent(frame_g, WindowEvent.WINDOW_CLOSING));
    }

    /***
     * Method calculates positions of objects in game every tact of timer
     * @param e actionEvent for example step of timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        hero.movementOfHero(this);

        for (Ball_2D ele: ball_list_small) {
            ele.movement(this);
        }
        for (Ball_2D ele: ball_list_medium) {
            ele.movement(this);
        }
        for (Ball_2D ele: ball_list_large) {
            ele.movement(this);
        }
        for (Ball_2D ele: ball_list_extra_large) {
            ele.movement(this);
        }
        scaleX = (float)this.getWidth()/width_of_frame;
        scaleY = (float)this.getHeight()/height_of_frame;

        //collision with ball
        if(collision(hero)){
            timer.stop();
            lives -= 1;
            if (lives != 0){
                load_map(current_level);
            }
            else{
                gameOver();
            }
        }
        repaint();
    }


    /***
     * implements functionality of event of key listener
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /***
     * implements functionality of handled event of key listener
     * @param e Key Event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
            hero.velocity = (float) -ConfigData.speed_of_player;
            pressedKeys.add(key);
            }

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            hero.velocity = (float) ConfigData.speed_of_player ;
            pressedKeys.add(key);
            }

        if(key==KeyEvent.VK_P && timer.isRunning()){
            timer.stop();
            }else if(key==KeyEvent.VK_P && !timer.isRunning()){
            timer.start();
        }
        }


    /***
     * implements functionality of handled event of key listener
     * @param e Key Event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT ){
            if (pressedKeys.size() > 1){
                pressedKeys.clear();
                return; }
            hero.velocity = 0;
            pressedKeys.remove(key);

        }


    }


}
