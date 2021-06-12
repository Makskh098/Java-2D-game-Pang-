public class PointCounter {
    int CurrentPoints;

    public PointCounter() {
    }


    public void increasePoints(int number_of_points) {
        CurrentPoints+=number_of_points;
    }
    public void resetPoints(){
        CurrentPoints=0;
    }
    public int getCurrentPoints(){
        return CurrentPoints;
    }
}
