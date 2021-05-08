import javax.swing.*;
import java.awt.*;

public class Welcome_Screen extends JFrame {
    private JButton start_b, table_b, autors_b, exit_b;
    private JLabel center;
    private JScrollPane scroll;
    private JPanel box;
    private String welcome_text;
    public void window(){

        setTitle("PANG");

        start_b = new JButton("Start");
        table_b = new JButton("Leader Board");
        autors_b = new JButton("Autors");
        exit_b = new JButton("Exit");

        box = new JPanel(new GridLayout(4,1));
        box.add(start_b);
        box.add(table_b);
        box.add(autors_b);
        box.add(exit_b);



        JPanel south = new JPanel(new GridBagLayout());
        south.add(box);

        welcome_text = "MENU" +
                "<br>" +
                "max to dobry ziom";
        String text = "<html><div style='text-algin: center;'>" + welcome_text + "</div></html";


        center = new JLabel(text,SwingConstants.CENTER);

        scroll = new JScrollPane(center);

        getContentPane().add(south, BorderLayout.SOUTH);
        getContentPane().add(scroll);


        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);





    }
}
