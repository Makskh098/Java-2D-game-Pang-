import javax.swing.*;
import java.awt.*;

public class Map {
        int minX,maxX,minY,maxY;
        private Color color_background;
        private Color color_border;
        private static final Color DEFAULT_COLOR_FILLED= Color.BLACK;
        private static final Color DEFAULT_COLOR_BORDER= Color.BLUE;

        //Constructors
        public Map(int x, int y, int width, int height,Color color_background,Color color_border){
            minX=x;
            minY=y;
            maxX=width+x-1;
            maxY=height+y-1;
            this.color_background=color_background;
            this.color_border=color_border;
        }
        public  Map(int x, int y, int width, int height){
            this(x,y,width,height,DEFAULT_COLOR_FILLED,DEFAULT_COLOR_BORDER);
        }

        public void draw(Graphics g){
            g.setColor(color_background);
            g.fillRect(minX,minY,maxX-minX-1,maxY-minY-1);
        }
        //dodano na test
    public void set(int x, int y, int width, int height) {
        minX = x;
        minY = y;
        maxX = x + width - 1;
        maxY = y + height - 1;
    }
}
