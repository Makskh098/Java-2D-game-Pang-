public class ConfigMap {
    double length_of_map;
    double height_of_map;
    int number_of_balls;
    double position_of_player;
    float percent_of_small_balls;
    float percent_of_medium_balls;
    float percent_of_large_balls;
    float percent_of_extraLarge_balls;

    ConfigMap(double length_of_map, double height_of_map, int number_of_balls, float percent_of_small_balls, float percent_of_medium_balls, float percent_of_large_balls, float percent_of_extraLarge_balls){
        this.length_of_map = length_of_map;
        this.height_of_map = height_of_map;
        this.number_of_balls = number_of_balls;
        this.percent_of_small_balls = percent_of_small_balls;
        this.percent_of_medium_balls = percent_of_medium_balls;
        this.percent_of_large_balls = percent_of_large_balls;
        this.percent_of_extraLarge_balls = percent_of_extraLarge_balls;
        this.position_of_player = length_of_map/2;

    }

    @Override
    public String toString() {
        return "{" +
                "length_of_map=" + length_of_map +
                ", height_of_map=" + height_of_map +
                ", number_of_balls=" + number_of_balls +
                ", position_of_player=" + position_of_player +
                ", percent_of_small_balls=" + percent_of_small_balls +
                ", percent_of_medium_balls=" + percent_of_medium_balls +
                ", percent_of_large_balls=" + percent_of_large_balls +
                ", percent_of_extraLarge_balls=" + percent_of_extraLarge_balls +
                '}';
    }
}
