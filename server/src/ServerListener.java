import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {
    ServerSocket ss;
    public ServerListener() throws IOException{
    }

    public void ListenClosely() throws IOException{
        this.ss=new ServerSocket(8989);
        while (true) {
            Socket s = ss.accept();

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String request = bf.readLine();

            switch (request) {
                case "give me ConfigData plx":
                    System.out.println("server : request accepted sending ConfigData");
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
    }




}
