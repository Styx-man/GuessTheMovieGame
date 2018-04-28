import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main (String[] args) throws IOException {

        // start reading the user's input
        // search for it in the title.

        String testMovie = "maatrix";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isGuessed = false;
        int guessedIndexes[] = new int[testMovie.length()];

        for(int i = 0; i < guessedIndexes.length; i++) {
            guessedIndexes[i] = 0;
        }

        while(!isGuessed) {
            for(int i = 0; i < testMovie.length(); i++) {
                if(guessedIndexes[i] == 1) System.out.print(testMovie.charAt(i));
                else System.out.print("_");
            }

            System.out.println("");
            System.out.println("Try it!");
            String playerGuess = br.readLine();

            if(testMovie.contains(playerGuess)) {
                for(int i = 0; i < testMovie.length(); i++) {
                    char c = testMovie.charAt(i);

                    if(c == playerGuess.charAt(0)) guessedIndexes[i] = 1;
                }
            }
        }
    }
}