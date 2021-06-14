import java.io.IOException;

/***
 * Main class tu run game
 */

public class Main {

    /***
     * main function to start game
     */
    public static void main(String[] args) throws IOException {



//                ConfigLoad configLoad  = new ConfigLoad();
//        ConfigData data = new ConfigData();
//        configLoad.load("config/configData.txt");
//        System.out.println(data);
//
//        Welcome_Screen welcome_sc = new Welcome_Screen();
//        welcome_sc.window();


/***
 * No i nie działa :(
 */
        try {
           // ConfigData data;


            ClientManager clientManager=new ClientManager();
            clientManager.askForConfigData();
            clientManager.getConfigData();



           // data=clientManager.localData;



            //ConfigData data = new ConfigData();
            //ConfigLoad configLoad=new ConfigLoad();
            //configLoad.load("config/configData.txt");
            Welcome_Screen welcome_sc = new Welcome_Screen();
            welcome_sc.window();
        }
        catch (Exception e){
            e.printStackTrace();
        }



//        System.out.println(data);
//


    }
}
