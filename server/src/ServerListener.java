import java.io.IOException;
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
