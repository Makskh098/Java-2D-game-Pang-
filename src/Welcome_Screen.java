import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Welcome_Screen extends JFrame implements ActionListener {
    private JButton start_b, table_b, autors_b, exit_b;
    private JLabel center;
    private JScrollPane scroll;
    private JPanel box;
    private String welcome_text;
    public void window(){

        setBounds(0, 0,400,400);
        setTitle("PANG");


        // buttons
        start_b = new JButton("Start");
        table_b = new JButton("Leader Board");
        autors_b = new JButton("Credits");
        exit_b = new JButton("Exit");


        // buttons actions
        autors_b.addActionListener(this);
        autors_b.setActionCommand("credits");

        exit_b.addActionListener(this);
        exit_b.setActionCommand("exit");

        start_b.addActionListener(this);
        start_b.setActionCommand("start");

        // buttons layout
        box = new JPanel(new GridLayout(4,1));
        box.add(start_b);
        box.add(table_b);
        box.add(autors_b);
        box.add(exit_b);

        JPanel south = new JPanel(new GridBagLayout());
        south.add(box);

        //text
        welcome_text = "MENU" +
                "<br>" +
                "Janek to dobry ziom";
        String text = "<html><div style='text-algin: center;'>" + welcome_text + "</div></html";


        center = new JLabel(text,SwingConstants.CENTER);
        scroll = new JScrollPane(center);

        //content
        getContentPane().add(south, BorderLayout.SOUTH);
        getContentPane().add(scroll);

        //display
       // this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    //events
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        if (action.equals("credits")) {
            OK_Window credits = new OK_Window("Credits", "Jan Bronowski" + "<br>" + "Maksym Khachapuridze");
            credits.createAndShowGUI();
        }

        if (action.equals("exit")) {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        if(action.equals("start"))
        {
            //Map map=new Map(0, 0,400,400);
           // map.draw();
        }

    }

}
