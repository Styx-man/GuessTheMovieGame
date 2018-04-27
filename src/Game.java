import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main (String[] args) throws Exception {

        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> movieList = new ArrayList<String>();
        int randomNumber;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            //movieList.add(line);
        }

        //System.out.println(movieList);
    }
}
