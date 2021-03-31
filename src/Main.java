import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world");
        ConfigLoad load  = new ConfigLoad();
        load.Load();
        System.out.println(ConfigData.radius_of_extraLarge_ball);
    }
}
