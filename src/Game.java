import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public String hiddenMovieName() throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> movieList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            movieList.add(line);
        }

        int size = movieList.size();
        int randomNumber = (int) (Math.random() * size);

        String luckyMovie = movieList.get(randomNumber);

        return luckyMovie;
    }
}