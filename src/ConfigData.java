import java.io.Serializable;
import java.util.ArrayList;

public class ConfigData implements Serializable{
    /***
     * ConfigData, static class to store configuration data
     */

//  Overall
    static int update_rate;
//  Balls
    static double radius_of_extraLarge_ball;
    static double radius_of_large_ball; //  radius_of_extraLarge_ball/2
    static double radius_of_medium_ball; // radius_of_extraLarge_ball/4 //process in ConfigLoad.load()
    static double radius_of_small_ball; //  radius_of_extraLarge_ball/8
    static double max_speed_of_ball;
    static double const_Xball_speed_value;
    static double const_gravity_value;
    static int points_for_extralarge_ball;
    static int points_for_large_ball;
    static int points_for_medium_ball;
    static int points_for_small_ball;

//  Maps
    static int number_of_levels;
    static ArrayList<ConfigMap> List_of_Config_of_Maps = new ArrayList<>();

//  Player
    static int number_of_lives;
    static double speed_of_player;

//  Weapon
    static double width_of_ray;
    static double speed_of_ray;

//  PowerUP
    static int  width_of_powerUP;
    static int  height_of_powerUP;
    static int  fall_speed_of_powerUP;

    /***
     *
     * @return returns string version of configData object
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        res.append("update_rate=").append(update_rate).append("\n");
        res.append("radius_of_extraLarge_ball=").append(radius_of_extraLarge_ball).append("\n");
        res.append("radius_of_large_ball=").append(radius_of_large_ball).append("\n");
        res.append("radius_of_medium_ball=").append(radius_of_medium_ball).append("\n");
        res.append("radius_of_small_ball=").append(radius_of_small_ball).append("\n");
        res.append("max_speed_of_ball=").append(max_speed_of_ball).append("\n");
        res.append("const_Xball_speed_value=").append(const_Xball_speed_value).append("\n");
        res.append("const_gravity_value=").append(const_gravity_value).append("\n");
        res.append("points_for_extralarge_ball=").append(points_for_extralarge_ball).append("\n");
        res.append("points_for_large_ball=").append(points_for_large_ball).append("\n");
        res.append("points_for_medium_ball=").append(points_for_medium_ball).append("\n");
        res.append("points_for_small_ball=").append(points_for_small_ball).append("\n");
        //res.append("\n");
        res.append("number_of_levels=").append(number_of_levels).append("\n");
        for (int i = 0; i < number_of_levels; i++) {
            res.append("map").append(i+1).append("=").append(List_of_Config_of_Maps.get(i).toString()).append("\n");
        }
       // res.append("\n");
        res.append("number_of_lives=").append(number_of_lives).append("\n");
        res.append("speed_of_player=").append(speed_of_player).append("\n");
        //res.append("\n");
        res.append("width_of_ray=").append(width_of_ray).append("\n");
        res.append("speed_of_ray=").append(speed_of_ray).append("\n");
        res.append("powerUP_width=").append(width_of_powerUP).append("\n");
        res.append("powerUP_height=").append(height_of_powerUP).append("\n");
        res.append("powerUP_fall_speed=").append(fall_speed_of_powerUP).append("\n");

        return res.toString();
    }


}
