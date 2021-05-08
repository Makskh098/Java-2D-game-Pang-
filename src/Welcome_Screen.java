import javax.swing.*;

public class Welcome_Screen {
    public void window(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);
    }
}
