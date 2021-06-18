import java.io.*;
import java.net.Socket;

public class ServerConnector extends Thread implements Serializable{
    Socket s;
    ConfigLoad configLoad;
    ConfigData data;
    Leaderboard leaderboard;

    public void sendConfigData() throws IOException{
        configLoad= new ConfigLoad();
        data = new ConfigData();
        configLoad.load("server/config/remoteConfigData.txt");
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(data.toString());
        pr.flush();
    }
    public void sendLeaderBoars() throws IOException{
        leaderboard=new Leaderboard( "server/config/remoteLeaderboard.csv");
        leaderboard.load_leaderboard();
        PrintWriter pr= new PrintWriter(s.getOutputStream());
                            System.out.println(leaderboard.send_string());
        pr.println(leaderboard.send_string());
        pr.flush();

    }
    public void getlocalLeaderBoard() throws IOException{
        try {
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            FileWriter myWriter = new FileWriter("server/config/remoteLeaderboard.csv");
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



    public ServerConnector(Socket s){
        this.s=s;
    }

    @Override
    public void run(){
        try {
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String request = bf.readLine();

            switch (request) {
                case "give me ConfigData plx":
                    System.out.println("server : request accepted sending ConfigData");
                    sendConfigData();
                    break;
                case "give me Leaderboard plx":
                    System.out.println("server : request accepted sending Leaderboar");
                    sendLeaderBoars();
                    break;
                case "save my leaderboards plx":
                    System.out.println("server : request accepted downloading leaderboar");
                    getlocalLeaderBoard();
                    break;
                default:
                    System.out.println("Not recognized request");
                    break;//dobra praktyka
            }
        }
        catch(Exception e){
            e.printStackTrace();
            }
    }


}
