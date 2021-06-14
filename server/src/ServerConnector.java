import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnector extends Thread{
    Socket s;
    ObjectOutputStream oos;

    ConfigLoad configLoad;
    ConfigData data;



    public void sendConfigData() throws IOException{
        configLoad= new ConfigLoad();
        data = new ConfigData();
        configLoad.load("server/config/remoteConfigData.txt");
       // System.out.println(data);

        oos=new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(data);
        oos.flush();
    }



    public ServerConnector(Socket s){
        this.s=s;
    }

    @Override
    public void run(){
        try {
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String request = bf.readLine();

            switch (request) {
                case "give me ConfigData plx":
                    System.out.println("server : request accepted sending ConfigData");
                    sendConfigData();
                    break;
                case "give me ConfigMap plx":
                    System.out.println("server : request accepted sending ConfigMap");
                    break;
                case "give me Leaderboard plx":
                    System.out.println("server : request accepted sending Leaderboar");
                    break;
                case "save my leaderboards plx":
                    System.out.println("server : request accepted downloading leaderboar");
                    break;
                default:
                    System.out.println("K");
                    break;//dobra praktyka
            }
        }
        catch(Exception e){
            e.printStackTrace();
            }
    }


}
