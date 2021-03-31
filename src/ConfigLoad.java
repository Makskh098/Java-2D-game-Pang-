import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoad {
    public void Load() throws IOException, FileNotFoundException {
        Properties prop = new Properties();
        String propFileName = "configData.txt";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null){
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("config file '" + propFileName + "' not found");
        }





    }
}
