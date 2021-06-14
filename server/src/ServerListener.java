import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {
    ServerSocket ss;

    public void ListenClosely() throws IOException{
        this.ss=new ServerSocket(8989);
        while (true) {

               Socket s = ss.accept();
            (new Thread(new ServerConnector(s))).start();


        }
    }

}
