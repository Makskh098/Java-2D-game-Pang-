import java.io.*;
import java.net.Socket;

public class ClientManager implements Serializable {
Socket s;
ObjectInputStream ois;
ConfigLoad configLoad;
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
    public void getConfigData() throws IOException{
       // ois = new ObjectInputStream(s.getInputStream());
        //localData=(ConfigData)ois.readObject();
        try {
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            FileWriter myWriter = new FileWriter("config/configDataServer.txt");
            String request=bf.readLine();
            for (int i = 0; i <=(int)','/2; i++){
                System.out.println("("+request+")");
                myWriter.write(request+"\n");
                request = bf.readLine();
                System.out.println("ss");
            }
            bf.close();
            myWriter.close();
            configLoad = new ConfigLoad();
            configLoad.load("config/configDataServer.txt");


        }
        catch (IOException e) {
            e.printStackTrace();
        }

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
