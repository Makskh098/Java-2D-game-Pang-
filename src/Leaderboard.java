import java.io.*;
import java.util.*;

public class Leaderboard {


    public ArrayList<Pair<String,Integer>> leader_board_list = new ArrayList<>();
    private String file_path = "leaderboard/leaderboard.csv";
    private BufferedReader reader;

    public void add_score(String name, int score){
        Pair<String,Integer> pom = new Pair(name, score);
        leader_board_list.add(pom);
    }

    public Pair<String,Integer> get_score(int index){
        sort();
        return leader_board_list.get(index);
    };

    private void sort(){
     leader_board_list.sort(Comparator.comparing(p -> -p.getElement1()));
    }

    public String get_string(){
        StringBuilder text = new StringBuilder();
        text.append("Nr:   Name:   Score:\n");
        sort();
        int i=1;
        for (Pair<String,Integer> ele: this.leader_board_list) {
            text.append(i).append(".    ").append(ele.getElement0()).append("    ").append(ele.getElement1()).append('\n');
            i += 1;
        }

        System.out.println(text.toString());

        return text.toString();
    }

    public void load_leaderboard(){

        try{
            reader = new BufferedReader(new FileReader(file_path));

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

    public void save_leaderboard(){
        try {
            FileWriter myWriter = new FileWriter("leaderboard/leaderboard.csv");
            for (Pair<String,Integer> ele:leader_board_list) {
                myWriter.write(ele.getElement0() + ',' + ele.getElement1() + '\n');
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static class Pair<K, V> {

        private final K element0;
        private final V element1;

        public Pair(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        public K getElement0() {
            return element0;
        }

        public V getElement1() {
            return element1;
        }

    }}
