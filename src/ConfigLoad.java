import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/***
 * class to load config data from file
 */

public class ConfigLoad {
    InputStream inputStream;

    /***
     * load data from config file to ConfigData object
     * @param file_name file path
     * @throws IOException throw exception if something went wrong while reading config file
     */

    public void load(String file_name) throws IOException{
        try {
            Properties prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(file_name);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("config file '" + file_name + "' not found");
            }

            //Load data to ConfigData
            //Overall
            ConfigData.update_rate = Integer.parseInt( prop.getProperty("update_rate"));
            //Balls
            ConfigData.radius_of_extraLarge_ball = Double.parseDouble( prop.getProperty("radius_of_extraLarge_ball"));
            ConfigData.radius_of_large_ball = ConfigData.radius_of_extraLarge_ball/2;
            ConfigData.radius_of_medium_ball = ConfigData.radius_of_extraLarge_ball/4;
            ConfigData.radius_of_small_ball = ConfigData.radius_of_extraLarge_ball/8;
            ConfigData.max_speed_of_ball = Double.parseDouble( prop.getProperty("max_speed_of_ball"));
            ConfigData.const_Xball_speed_value = Double.parseDouble( prop.getProperty("const_Xball_speed_value"));
            ConfigData.const_gravity_value = Double.parseDouble( prop.getProperty("const_gravity_value"));
            ConfigData.points_for_extralarge_ball = Integer.parseInt(prop.getProperty("points_for_extralarge_ball"));
            ConfigData.points_for_large_ball = Integer.parseInt(prop.getProperty("points_for_large_ball"));
            ConfigData.points_for_medium_ball = Integer.parseInt(prop.getProperty("points_for_medium_ball"));
            ConfigData.points_for_small_ball = Integer.parseInt(prop.getProperty("points_for_small_ball"));

            // Maps
            ConfigData.number_of_levels = Integer.parseInt( prop.getProperty("number_of_levels") );
            for (int i = 1; i <= ConfigData.number_of_levels ; i++) {

                String map_data_string = prop.getProperty("map" + i);
                Map<String,String> dict_of_map_data = new Gson().fromJson(map_data_string,new TypeToken<HashMap<String , String>>() {}.getType());

                double map_len = Double.parseDouble(dict_of_map_data.get("length_of_map"));
                double map_height = Double.parseDouble(dict_of_map_data.get("height_of_map"));
                int num_of_balls = Integer.parseInt(dict_of_map_data.get("number_of_balls"));
                float percent_of_s_balls = Float.parseFloat(dict_of_map_data.get("percent_of_small_balls"));
                float percent_of_m_balls = Float.parseFloat(dict_of_map_data.get("percent_of_medium_balls"));
                float percent_of_l_balls = Float.parseFloat(dict_of_map_data.get("percent_of_large_balls"));
                float percent_of_xl_balls = Float.parseFloat(dict_of_map_data.get("percent_of_extraLarge_balls"));

                if (percent_of_s_balls + percent_of_m_balls + percent_of_l_balls + percent_of_xl_balls != 1.0){
                    throw new Exception("percent of balls don't sum to 100%");
                }

                ConfigData.List_of_Config_of_Maps.add(new ConfigMap(map_len,map_height,num_of_balls,percent_of_s_balls,percent_of_m_balls,percent_of_l_balls,percent_of_xl_balls));

            }

            // Player
            ConfigData.number_of_lives = Integer.parseInt(prop.getProperty("number_of_lives"));
            ConfigData.speed_of_player = Double.parseDouble(prop.getProperty("speed_of_player"));

            // Weapon
            ConfigData.width_of_ray = Double.parseDouble(prop.getProperty("width_of_ray"));
            ConfigData.speed_of_ray = Double.parseDouble(prop.getProperty("speed_of_ray"));


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
    }

    public void loadFromString(String file_name) throws IOException{
        try {
            Properties prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(file_name);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("config file '" + file_name + "' not found");
            }

            //Load data to ConfigData
            //Overall
            ConfigData.update_rate = Integer.parseInt( prop.getProperty("update_rate"));
            //Balls
            ConfigData.radius_of_extraLarge_ball = Double.parseDouble( prop.getProperty("radius_of_extraLarge_ball"));
            ConfigData.radius_of_large_ball = ConfigData.radius_of_extraLarge_ball/2;
            ConfigData.radius_of_medium_ball = ConfigData.radius_of_extraLarge_ball/4;
            ConfigData.radius_of_small_ball = ConfigData.radius_of_extraLarge_ball/8;
            ConfigData.max_speed_of_ball = Double.parseDouble( prop.getProperty("max_speed_of_ball"));
            ConfigData.const_Xball_speed_value = Double.parseDouble( prop.getProperty("const_Xball_speed_value"));
            ConfigData.const_gravity_value = Double.parseDouble( prop.getProperty("const_gravity_value"));
            ConfigData.points_for_extralarge_ball = Integer.parseInt(prop.getProperty("points_for_extralarge_ball"));
            ConfigData.points_for_large_ball = Integer.parseInt(prop.getProperty("points_for_large_ball"));
            ConfigData.points_for_medium_ball = Integer.parseInt(prop.getProperty("points_for_medium_ball"));
            ConfigData.points_for_small_ball = Integer.parseInt(prop.getProperty("points_for_small_ball"));

            // Maps
            ConfigData.number_of_levels = Integer.parseInt( prop.getProperty("number_of_levels") );
            for (int i = 1; i <= ConfigData.number_of_levels ; i++) {

                String map_data_string = prop.getProperty("map" + i);
                Map<String,String> dict_of_map_data = new Gson().fromJson(map_data_string,new TypeToken<HashMap<String , String>>() {}.getType());

                double map_len = Double.parseDouble(dict_of_map_data.get("length_of_map"));
                double map_height = Double.parseDouble(dict_of_map_data.get("height_of_map"));
                int num_of_balls = Integer.parseInt(dict_of_map_data.get("number_of_balls"));
                float percent_of_s_balls = Float.parseFloat(dict_of_map_data.get("percent_of_small_balls"));
                float percent_of_m_balls = Float.parseFloat(dict_of_map_data.get("percent_of_medium_balls"));
                float percent_of_l_balls = Float.parseFloat(dict_of_map_data.get("percent_of_large_balls"));
                float percent_of_xl_balls = Float.parseFloat(dict_of_map_data.get("percent_of_extraLarge_balls"));

                if (percent_of_s_balls + percent_of_m_balls + percent_of_l_balls + percent_of_xl_balls != 1.0){
                    throw new Exception("percent of balls don't sum to 100%");
                }

                ConfigData.List_of_Config_of_Maps.add(new ConfigMap(map_len,map_height,num_of_balls,percent_of_s_balls,percent_of_m_balls,percent_of_l_balls,percent_of_xl_balls));

            }

            // Player
            ConfigData.number_of_lives = Integer.parseInt(prop.getProperty("number_of_lives"));
            ConfigData.speed_of_player = Double.parseDouble(prop.getProperty("speed_of_player"));

            // Weapon
            ConfigData.width_of_ray = Double.parseDouble(prop.getProperty("width_of_ray"));
            ConfigData.speed_of_ray = Double.parseDouble(prop.getProperty("speed_of_ray"));


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
    }
}
