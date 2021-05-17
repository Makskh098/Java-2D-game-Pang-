import javax.swing.*;

public class Stage extends JFrame {

    public void run_stage(int level_number, JFrame object_to_relate_position_of_window){
        setLocation(object_to_relate_position_of_window.getLocation());

        ConfigMap map_data = ConfigData.List_of_Config_of_Maps.get(level_number-1);

        setTitle("Stage - " + level_number);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(new Engine(((int)map_data.length_of_map),(int)map_data.height_of_map));

        pack();
        setVisible(true);

    }

}
