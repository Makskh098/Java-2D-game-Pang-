import java.io.*;
import java.net.Socket;

/***
 * This class contains methods that provides server
 */
public class ServerConnector extends Thread implements Serializable{
    Socket s;
    ConfigLoad configLoad;
    ConfigData data;
    Leaderboard leaderboard;

    /***
     * method sends outputStream with String data to client
     * @throws IOException
     */
    public void sendConfigData() throws IOException{
        configLoad= new ConfigLoad();
        data = new ConfigData();
        configLoad.load("server/config/remoteConfigData.txt");
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(data.toString());
        pr.flush();
    }
    /***
     * method sends outputStream with String data to client
     * @throws IOException
     */
    public void sendLeaderBoars() throws IOException{
        leaderboard=new Leaderboard( "server/config/remoteLeaderboard.csv");
        leaderboard.load_leaderboard();
        PrintWriter pr= new PrintWriter(s.getOutputStream());
        pr.println(leaderboard.send_string());
        pr.flush();

    }

    /***
     * method is getting leaderboards csv data from client and saves it on server.
     */
    public void getlocalLeaderBoard(){
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

    /***
     * Override of method from Thread that is listening requests from client
     */
    @Override
    public void run(){
        try {
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String request = bf.readLine();

            switch (request) {
                case "give me ConfigData":
                    System.out.println("server : request accepted sending ConfigData");
                    sendConfigData();
                    break;
                case "give me Leaderboard":
                    System.out.println("server : request accepted sending Leaderboar");
                    sendLeaderBoars();
                    break;
                case "save my leaderboards":
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
