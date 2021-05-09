import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Leaderboard {


    public ArrayList<Pair<String,Integer>> leader_board_list = new ArrayList<>();
    BufferedReader reader;

    public void add_score(String name, int score){
        Pair<String,Integer> pom = new Pair(name, score);
        leader_board_list.add(pom);
    }

    public Pair<String,Integer> get_score(int index){
        sort();
        return leader_board_list.get(index);
    };

    private void sort(){
//        leader_board_list.sort((n1, n2) -> {
//            return new BigDecimal(n2.getElement1()).compareTo(new BigDecimal(n2.getElement1()));
//        });
        Collections.sort(leader_board_list, new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(final Pair<String, Integer> o1, final Pair<String, Integer> o2) {
                return new BigDecimal(o1.getElement1()).compareTo(new BigDecimal(o2.getElement1()));
            }
        });
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

    public void load_leaderboard(String file_path){

        try{
            reader = new BufferedReader(new FileReader(file_path));

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
            FileWriter myWriter = new FileWriter("filename.txt");
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
