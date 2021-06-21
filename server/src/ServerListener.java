import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {
    ServerSocket ss;

    /***
     * method that creates thread for connection between client and server
     * this solution allows multiple clients to connect to the server
     * @throws IOException
     */
    public void Listen() throws IOException{
        this.ss=new ServerSocket(8989);
        while (true) {

               Socket s = ss.accept();
            (new Thread(new ServerConnector(s))).start();


        }
    }

}
