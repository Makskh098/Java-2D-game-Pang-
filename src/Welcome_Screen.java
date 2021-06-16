import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;


public class Welcome_Screen extends JFrame implements ActionListener {
    /***
     * class of main window extends from swing Jframe and implements ActionListener
     */
    private JButton start_b, table_b, autors_b, exit_b;
    private JToggleButton localRemote_b;
    private JLabel center;
    private JScrollPane scroll;
    private JPanel box;
    private String welcome_text;
    private boolean isOnline=false;
    private Leaderboard ld = new Leaderboard( "leaderboard/leaderboard.csv");

   ConfigLoad configLoad=new ConfigLoad();;
    ClientManager clientManager;



    /***
     * Method that creates main menu window of the game
     */
    public void window(){

        setSize(400,400);
        setLocationRelativeTo(null);
        setTitle("PANG");


        // buttons
        start_b = new JButton("Start");
        table_b = new JButton("Leader Board");
        autors_b = new JButton("Credits");
        exit_b = new JButton("Exit");
        localRemote_b = new JToggleButton("Offline");


        // buttons actions
        autors_b.addActionListener(this);
        autors_b.setActionCommand("credits");

        exit_b.addActionListener(this);
        exit_b.setActionCommand("exit");

        table_b.addActionListener(this);
        table_b.setActionCommand("leaderB");

        start_b.addActionListener(this);
        start_b.setActionCommand("start");

        localRemote_b.addActionListener(this);
        localRemote_b.setActionCommand("switch");


        // buttons layout
        box = new JPanel(new GridLayout(5,1));
        box.add(start_b);
        box.add(table_b);
        box.add(autors_b);
        box.add(exit_b);
        box.add(localRemote_b);

        JPanel south = new JPanel(new GridBagLayout());
        south.add(box);

        //text
        welcome_text = "MENU" +
                "<br>" +
                "PANG";
        String text = "<html><div style='text-algin: center;'>" + welcome_text + "</div></html";


        center = new JLabel(text,SwingConstants.CENTER);
        scroll = new JScrollPane(center);

        //content
        getContentPane().add(south, BorderLayout.SOUTH);
        getContentPane().add(scroll);

        //display
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    /***
     * Implements events logic to main menu
     * @param ae ActionEvent of buttons
     */
    //events
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();




        if (action.equals("credits")) {
            JOptionPane.showMessageDialog(this, "Jan Bronowski and Maks Khachapuridze", "Credits", JOptionPane.INFORMATION_MESSAGE);
        }

        if (action.equals("exit")) {
            int check = JOptionPane.showConfirmDialog(this,"Do you want to quit the game?","Exit",JOptionPane.YES_NO_OPTION);
            if (check == 0) {
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        }

        if (action.equals("leaderB")) {
            if(isOnline) {
                try {
                    clientManager=new ClientManager();
                    clientManager.askForLeaderboard();
                    clientManager.getServerLeaderBoard();
                    ld = new Leaderboard( "leaderboard/test.csv");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                ld = new Leaderboard( "leaderboard/leaderboard.csv");
                }
            ld.load_leaderboard();
            JOptionPane.showMessageDialog(this, ld.get_string(), "leaderboard", JOptionPane.INFORMATION_MESSAGE);
        }
        if (action.equals("start")) {
            JFrame frame = new JFrame("Pang");



            frame.add(new Engine2(600,600,frame,ld,isOnline));
            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocation(this.getLocation().x,this.getLocation().y);
            frame.setLocation(this.getLocation());
            frame.setVisible(true);
        }
        if(action.equals("switch")){
            try {
                clientManager=new ClientManager();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(localRemote_b.isSelected() && clientManager.isConnected()) {
                localRemote_b.setText("Online");
                isOnline=true;
                try {
                    configLoad.load("config/configDataServer.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                localRemote_b.setText("Offline");
                isOnline=false;

                try {
                    configLoad.load("config/configData.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
