package hangman;

import java.io.File;
import java.io.IOException;
import java.util.EventListener;
import java.util.Scanner;

public class EvilHangman {
    // need to handle IOException and EmptyDictionaryException later.
    public static void main(String[] args) throws IOException, EmptyDictionaryException, GuessAlreadyMadeException {
        // args[1] = string dictionary.txt
        // args[2] = wordLength
        // args[3] = number of guesses possible.
        File dictionary = new File(args[0]);
        int wordLength = Integer.parseInt(args[1]);
        EvilHangmanGame game = new EvilHangmanGame();
        game.startGame(dictionary, wordLength);
        // make a loop to get guesses.
        /*
        while ( ) {
            Scanner scan = Scanner(System.in);
            char c = scan.nextLine();
            game.makeGuesses(c);

         */

        System.out.print("Make a guess: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        input = input.toLowerCase();

        // check if it's a char or blank.
        if (input.length() > 1 || input.isBlank()) {
            System.out.println("Invalid input");
            return;
        }
        char c = input.charAt(0);
        if (c < 'a' || c > 'z') {
            System.out.println("Invalid input");
            return;
        }
        game.makeGuess(c);
    }

}
