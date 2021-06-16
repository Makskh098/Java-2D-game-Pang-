import java.io.IOException;

/***
 * Main class tu run game
 */

public class Main {

    /***
     * main function to start game
     */
    public static void main(String[] args) throws IOException {


        try {

//            ClientManager clientManager=new ClientManager();
//            clientManager.askForConfigData();
//            clientManager.getConfigData();


            ConfigData data = new ConfigData();
            ConfigLoad configLoad=new ConfigLoad();
            configLoad.load("config/configData.txt");
            Welcome_Screen welcome_sc = new Welcome_Screen();
            welcome_sc.window();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
