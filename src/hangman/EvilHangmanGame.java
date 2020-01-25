package hangman;

import org.junit.FixMethodOrder;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class EvilHangmanGame implements IEvilHangmanGame {

  private Set<String> myDictionary = new TreeSet<>(); // have to use treeSet or hashSet to declare;
  private int wordLength;
  @Override
  public void startGame(File dictionary, int wordLength) throws IOException, EmptyDictionaryException {
    // get dictionary from the file. not playing game.
    Scanner sc = new Scanner(dictionary);
    while(sc.hasNext()){
      myDictionary.add(sc.next());
    }
    System.out.println(myDictionary.toString());

    this.wordLength = wordLength;
    System.out.printf("word length: %s\n", wordLength);
    // handle exceptions IOException and EmptyDictionaryException

  }

  @Override
  public Set<String> makeGuess(char guess) throws GuessAlreadyMadeException {
    System.out.println(guess);
    String pattern = makePattern(guess);
    System.out.println(pattern);
    return null; // new dictionary to use.
  }
  private String makePattern (char guess) {
    StringBuilder pattern = new StringBuilder();
    for (String word : myDictionary) {
      pattern = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == guess) {
          pattern.append(guess);
        }
        else {
          pattern.append('-');
        }
      }
    }
    return pattern.toString();
  }

  @Override
  public SortedSet<Character> getGuessedLetters() {

    return null;
  }
}


