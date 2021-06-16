import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Scanner;

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
            configLoad = new ConfigLoad();
            configLoad.load("config/configDataServer.txt");
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
        pr.println("give me Leaderboard plx");
        pr.flush();

    }
    public void SaveMyLeaderboards() throws IOException {
        s = new Socket("127.0.0.1", 8989);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("save my leaderboards plx");
        pr.flush();

    }
    public void sendlocalLeaderBoars(Leaderboard leaderboard) throws IOException{
        leaderboard=new Leaderboard( "leaderboard/test.csv");
        leaderboard.load_leaderboard();
        PrintWriter pr= new PrintWriter(s.getOutputStream());
        System.out.println(leaderboard.send_string());
        pr.println(leaderboard.send_string());
        // System.out.println(leaderboard.send_string());
        pr.flush();

    }



}
