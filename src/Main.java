import java.io.IOException;

/***
 * Main class tu run game
 */

public class Main {

    /***
     * main function to start game
     */
    public static void main(String[] args) throws IOException {

//        ConfigLoad configLoad  = new ConfigLoad();
//        ConfigData data = new ConfigData();
//        configLoad.load("config/configData.txt");
//        System.out.println(data);
//
//        Welcome_Screen welcome_sc = new Welcome_Screen();
//        welcome_sc.window();

        /***
         * TEST clienta
         */
        ClientManager clientManager=new ClientManager();
        clientManager.askForConfigData();
        clientManager.askForConfigMap();
        clientManager.SaveMyLeaderboards();

    }
}
