import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws IOException {
        ServerListener serverListener=new ServerListener();
        serverListener.ListenClosely();


    }
}
