import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    //Give information about game to user
    static void openingMessage() {
        System.out.println("Guess only one character in each turn!");
        System.out.println("Guess alphabetic letters (and other characters(Spaces, punctuations etc. (if needed)) coz I'm still thinking how to fix it (=");
        System.out.println("10 wrong guesses mean you lost.");
        System.out.println("Good luck!");
        threeSecDots();
    }

    //this is only waiting dots..
    static void threeSecDots() {
        for(int i=0;i<3;i++){
            System.out.print('.');
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }

    public static void main (String[] args) throws IOException {

        //opening message
        openingMessage();

        //for testing
        //String testMovie = "matrixxx";

        //new game initializing
        Game game = new Game();

        String theMovie = game.hiddenMovieName();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isGuessed = false;
        int[] guessedIndexes = new int[theMovie.length()];
        int[] winIndexes = new int[theMovie.length()];
        String wrongLetter = "";
        int wrongLetterCounter = 0;

        for(int i = 0; i < guessedIndexes.length; i++) {
            guessedIndexes[i] = 0;
        }

        for(int i = 0; i < winIndexes.length; i++) {
            winIndexes[i] = 1;
        }


        while(!isGuessed) {
            System.out.print("You are guessing: ");
            for(int i = 0; i < theMovie.length(); i++) {
                if(guessedIndexes[i] == 1) {
                    System.out.print(theMovie.charAt(i));
                }
                else System.out.print("_");
            }

            System.out.println("");
            System.out.println("You have guessed (" + wrongLetterCounter + ") wrong letters: " + wrongLetter);
            System.out.print("Guess a letter: ");
            String playerGuess = br.readLine();
            System.out.println("");

            if(theMovie.contains(playerGuess)) {
                for(int i = 0; i < theMovie.length(); i++) {
                    char c = theMovie.charAt(i);

                    if(c == playerGuess.charAt(0)) {
                        guessedIndexes[i] = 1;
                    }
                }
            }

            if(!theMovie.contains(playerGuess)) {
                wrongLetter += playerGuess + " ";
                wrongLetterCounter = wrongLetterCounter + 1;
            }

            if(wrongLetterCounter == 10) {
                System.out.println("You have guessed (" + wrongLetterCounter + ") wrong letters: " + wrongLetter);
                System.out.println("You have not guessed the Movie. You lose.");
                isGuessed = true;
            }


            if (Arrays.equals(guessedIndexes, winIndexes)) {
                System.out.println("You win!");
                System.out.println("You have guessed \"" + theMovie + "\" correctly!");
                isGuessed = true;
            }
        }
    }
}