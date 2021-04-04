import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ConfigLoad configLoad  = new ConfigLoad();
        ConfigData data = new ConfigData();
        configLoad.Load("config/configData.txt");
        System.out.println(data);
    }
}
