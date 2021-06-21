import java.io.IOException;

public class MainServer {
    /***
     * Main class of server
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

            ServerListener serverListener = new ServerListener();
            serverListener.Listen();



    }
}
