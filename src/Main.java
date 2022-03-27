import java.awt.desktop.AboutHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.*;

public class Main {


    static List<Athlete> readCSV() throws Exception
    {
        List<Athlete> atleti = new ArrayList<>();
        Scanner sc = new Scanner(new File("athlets.csv"));

        sc.useDelimiter(System.getProperty("line.separator"));
        String s = sc.next();


        sc.useDelimiter("," + "|" + System.getProperty("line.separator"));

        while (sc.hasNext())
        {
            int number = sc.nextInt();
            String name = sc.next();
            String country = sc.next();
            String timeString = sc.next();

            String [] parts  = timeString.split(":");
            int min = Integer.parseInt(parts[0]);
            int sec = Integer.parseInt(parts[1]);
            TimeResult time = new TimeResult(min,sec);

            String [] shootings = new String[3];
            for(int i=0; i<3; i++)
            {
                shootings[i] = sc.next();
            }
            Athlete athlete = new Athlete(number, name, country, time, shootings);
            atleti.add(athlete);
        }
        sc.close();
        return atleti;

    }

    public static void main(String[] args) {

        List<Athlete> atleti = null;

        try{
            atleti = readCSV();
        }
        catch (FileNotFoundException ex1)
        {
            System.out.println("Fisierul nu a fost gasit");
        }
        catch (IOException ex2)
        {
            System.out.println("Eroare de acces/citire din fisier");
            System.out.println(ex2.getMessage());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        for(Athlete at : atleti){
            System.out.println(at);
        }


        for (Athlete at: atleti){
            System.out.println(at.calculateTimeInSeconds());
        }

        Collections.sort(atleti);

        String []titles = {"Winner", "Runner-up", "Third place"};

        for(int i=0; i<atleti.size(); i++){
            System.out.println(titles[i] + ": " + atleti.get(i));
        }
    }


}

