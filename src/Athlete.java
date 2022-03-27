import java.util.Arrays;

public class Athlete implements Comparable<Athlete> {
    private int number;
    private String name;
    private String country;
    private TimeResult time;
    private String [] shootings; //3 shootings


    public Athlete(int number, String name, String country, TimeResult time, String[] shootings) {
        this.number = number;
        this.name = name;
        this.country = country;
        this.time = time;
        this.shootings = shootings;
    }

    @Override
    public int compareTo(Athlete at) {

        return calculateTimeInSeconds() - at.calculateTimeInSeconds();
    }

    @Override
    public String toString() {
        String s =  number + " "
                + name + " "
                + country + " "
                + time + " ";

        for(String shoot: shootings){
            s = s + shoot + " ";
        }
        return s;
    }

    public int calculateTimeInSeconds() {
        int sec = 0;
        sec = time.min * 60;
        sec = sec + time.sec;


        for(String shoot : shootings) {
            for (int i = 0; i < shoot.length(); i++) {
                if (shoot.charAt(i) == 'o')
                    sec = sec + 10;
            }
        }

        return sec;
    }
}
