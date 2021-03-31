import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigLoad {
    InputStream inputStream;

    public void Load() throws IOException{
        try {
            Properties prop = new Properties();
            String propFileName = "config/configData.txt";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("config file '" + propFileName + "' not found");
            }


            //Load data to ConfigData

            ConfigData.radius_of_extraLarge_ball = Double.parseDouble( prop.getProperty("radius") );
            ConfigData.number_of_levels = Integer.parseInt( prop.getProperty("number_of_levels") );
//            for (int i = 0; i < ConfigData.number_of_levels ; i++) {
//
//
//                ConfigData.List_of_Config_of_Maps.add(new ConfigMap())
//
//            } // TO DO wczytywanie dalsze





        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
    }
}
