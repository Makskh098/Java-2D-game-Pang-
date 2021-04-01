import java.util.ArrayList;

public class ConfigData {

//  Balls
    static double radius_of_extraLarge_ball;
    static double radius_of_large_ball = radius_of_extraLarge_ball/2;
    static double radius_of_medium_ball = radius_of_large_ball/2;
    static double radius_of_small_ball = radius_of_medium_ball/2;
    static double max_speed_of_ball;
    static double const_Xball_speed_value;
    static double const_gravity_value;

//  Maps
    static int number_of_levels;
    static ArrayList<ConfigMap> List_of_Config_of_Maps = new ArrayList<>();

//  Player
    static int number_of_lives;
    static double speed_of_player;

//  Weapon
    static double width_of_ray;
    static double speed_of_ray;

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        res.append("radius_of_extraLarge_ball=").append(radius_of_extraLarge_ball).append("\n");
        res.append("max_speed_of_ball=").append(max_speed_of_ball).append("\n");
        res.append("const_Xball_speed_value=").append(const_Xball_speed_value).append("\n");
        res.append("const_gravity_value=").append(const_gravity_value).append("\n");
        res.append("\n");
        res.append("number_of_levels=").append(number_of_levels).append("\n");
        for (int i = 0; i < number_of_levels; i++) {
            res.append("map").append(i+1).append("=").append(List_of_Config_of_Maps.get(i).toString()).append("\n");
        }
        res.append("\n");
        res.append("number_of_lives=").append(number_of_lives).append("\n");
        res.append("speed_of_player=").append(speed_of_player).append("\n");
        res.append("\n");
        res.append("width_of_ray=").append(width_of_ray).append("\n");
        res.append("speed_of_ray=").append(speed_of_ray).append("\n");

        return res.toString();
    }

}
