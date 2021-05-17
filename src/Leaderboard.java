import java.io.*;
import java.util.*;

public class Leaderboard {

    /***
     * LeaderBoard class creates data structure and implements control operations to leader board of this game
     */

    public ArrayList<Pair<String,Integer>> leader_board_list = new ArrayList<>();
    private final String file_path = "leaderboard/leaderboard.csv";

    /***
     * adds score to leaderBoard
     * @param name name of player
     * @param score score of player
     */
    public void add_score(String name, int score){
        Pair<String,Integer> pom = new Pair<>(name, score);
        leader_board_list.add(pom);
    }

    /***
     *
     * @param index index of which score you want get
     * @return returns Pair<name,score> from score list
     */
    public Pair<String,Integer> get_score(int index){
        sort();
        return leader_board_list.get(index);
    }

    /***
     * method to sort the leaderBoard from highest to lowest score
     */
    private void sort(){
     leader_board_list.sort(Comparator.comparing(p -> -p.getElement1()));
    }

    /***
     * Method to present leaderBoard in format of string
     * @return returns string
     */
    public String get_string(){
        StringBuilder text = new StringBuilder();
        text.append("Nr:   Name:   Score:\n");
        sort();

        int i=1;
        for (Pair<String,Integer> ele: this.leader_board_list) {
            text.append(i).append(".    ").append(ele.getElement0()).append("    ").append(ele.getElement1()).append('\n');
            i += 1;
        }

        return text.toString();
    }

    /***
     * Method to load leaderBoard from file
     */
    public void load_leaderboard(){
        try{

            BufferedReader reader = new BufferedReader(new FileReader(file_path));

           leader_board_list.clear();
           String line = reader.readLine();
           while (line != null) {
               String[] text = line.split(",");
               add_score(text[0],Integer.parseInt(text[1]));
               line = reader.readLine();
           }
           reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /***
     * Method to save leaderboard to file
     */
    public void save_leaderboard(){
        try {
            FileWriter myWriter = new FileWriter(file_path);
            for (Pair<String,Integer> ele:leader_board_list) {
                myWriter.write(ele.getElement0() + ',' + ele.getElement1() + '\n');
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /***
     * Class which implements structure of Pair
     * @param <K> data type
     * @param <V> data type
     */
    public static class Pair<K, V> {
        private final K element0;
        private final V element1;

        /***
         * Constructor to creat new pair
         * @param element0 first element "0"
         * @param element1 second element "1"
         */

        public Pair(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        /***
         * Getter of first element
         * @return returns fist element of Pair
         */
        public K getElement0() {
            return element0;
        }

        /***
         * Getter of second element
         * @return returns second element of Pair
         */
        public V getElement1() {
            return element1;
        }

    }}
