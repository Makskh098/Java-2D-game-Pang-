import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class OK_Window extends JFrame implements ActionListener{

    public String title;
    public String text;


    OK_Window(String title, String text){
        this.title = title;
        this.text = text;
    }

    public void window() {
        setTitle(title);

        //Ok button
        JPanel box_buttons = new JPanel(new GridLayout(1, 1));

        JButton ok_b = new JButton("Ok");
        ok_b.addActionListener(this);
        ok_b.setActionCommand("click");
        setBounds(0,0,200,200);

        box_buttons.add(ok_b);

        JPanel south = new JPanel(new GridBagLayout());
        south.add(box_buttons);


        //text
        JLabel text_to_write = new JLabel("<html><div style='text-algin: center;'>" + text +  "</div></html" , SwingConstants.CENTER);
        JScrollPane scroll = new JScrollPane(text_to_write);


        //content
        getContentPane().add(south, BorderLayout.SOUTH);
        getContentPane().add(scroll);

    }

    // event
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("click")) {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

    public void createAndShowGUI() {
        window();

       // this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


    }
}
