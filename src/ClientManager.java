import java.io.*;
import java.net.Socket;

/***
 * ClientManager is class that provides communication between client and server
 * it provides methods with requests to server
 */
public class ClientManager implements Serializable {
Socket s=new Socket("localhost", 8989);

    public ClientManager() throws IOException {
    }

    /***
     * method is returning boolean depending if client (socket) is connected to the server
     * @return
     */
    public boolean isConnected(){
        return s.isConnected();

    }

    public void askForConfigData() throws IOException {
        s = new Socket("127.0.0.1", 8989);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("give me ConfigData");
        pr.flush();

    }
    public void getConfigData() throws IOException{
        try {
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            FileWriter myWriter = new FileWriter("config/configDataServer.txt");
            String request=bf.readLine();
          // for (int i = 0; i <=(int)','/2; i++){//jestem dumny z tego rozwiązania więc prosze nie usuwać !!!_Maks
            while (!request.isEmpty()){
                myWriter.write(request+"\n");
                request = bf.readLine();
            }
            bf.close();
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void getServerLeaderBoard() throws IOException{
        try {
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            FileWriter myWriter = new FileWriter("leaderboard/test.csv");
            String request = bf.readLine();
            while (!request.isEmpty()){
                myWriter.write(request + "\n");
                request = bf.readLine();
            }
            bf.close();
            myWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public void askForLeaderboard() throws IOException {
        s = new Socket("127.0.0.1", 8989);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("give me Leaderboard");
        pr.flush();

    }
    public void SaveMyLeaderboards() throws IOException {
        s = new Socket("127.0.0.1", 8989);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("save my leaderboards");
        pr.flush();

    }
    public void sendlocalLeaderBoars(Leaderboard leaderboard) throws IOException{
        leaderboard=new Leaderboard( "leaderboard/test.csv");
        leaderboard.load_leaderboard();
        PrintWriter pr= new PrintWriter(s.getOutputStream());
        System.out.println(leaderboard.send_string());
        pr.println(leaderboard.send_string());
        pr.flush();
    }
}
