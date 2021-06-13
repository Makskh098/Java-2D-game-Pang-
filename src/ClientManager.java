import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientManager {
Socket s;
    public ClientManager() throws IOException {
//        s = new Socket("localhost", 8989);
//        PrintWriter pr = new PrintWriter(s.getOutputStream());
//        pr.println("give me ConfigData plx");
//        System.out.println("wysłano");
//        pr.flush();

    }
    public void askForConfigData() throws IOException {
        s = new Socket("127.0.0.1", 8989);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("give me ConfigData plx");
        pr.flush();

    }
    public void askForConfigMap() throws IOException {
        s = new Socket("127.0.0.1", 8989);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("give me ConfigMap plx");
        pr.flush();

    }
    public void askForLeaderboard() throws IOException {
        s = new Socket("127.0.0.1", 8989);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("give me Leaderboard plx");
        pr.flush();

    }
    public void SaveMyLeaderboards() throws IOException {
        s = new Socket("127.0.0.1", 8989);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("save my leaderboards plx");
        pr.flush();

    }

}
