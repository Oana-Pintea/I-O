public class TimeResult {
    int min;
    int sec;

    public TimeResult(int min, int sec){
        this.min = min;
        this.sec = sec;
    }
    @Override
    public String toString() {
        return min + ":" + sec;
    }
}
