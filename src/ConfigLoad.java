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





        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
    }
}
