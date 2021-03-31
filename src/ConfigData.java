import java.util.ArrayList;

public class ConfigData {

//  Balls
    static double radius_of_extraLarge_ball;
    static double radius_of_large_ball = radius_of_extraLarge_ball/2;
    static double radius_of_medium_ball = radius_of_large_ball/2;
    static double radius_of_small_ball = radius_of_medium_ball/2;
    static double Max_speed_of_ball;
    static double Const_X_speed_value;
    static double Const_gravity_value;

//  Maps
    static int number_of_levels;
    static ArrayList<ConfigMap> List_of_Config_of_Maps = new ArrayList<ConfigMap>();

//  Player
    static int number_of_lives;
    static double speed_of_player;

//  Weapon
    static double width_of_ray;
    static double speed_of_ray;

}
