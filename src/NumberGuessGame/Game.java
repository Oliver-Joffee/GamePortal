package NumberGuessGame;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    int guesses;
    int numToGuess;
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    int gameLow;
    int gameHigh;
    ArrayList<Integer> previousGuesses = new ArrayList<>();

    Game(int low, int high) {
        guesses = 0;
        // TODO: setup.
        System.out.println("I'm thinking of a number " + low + " to " + high);
        // when we create a game, we get a random number between low to high.
        // assign numToGuess to that random number.
        numToGuess = random.nextInt(low, high);
        gameLow = low;
        gameHigh = high;
    }

    void play() {
        // you can remove these println statements, they are just here for you to
        // understand how we call this code.
        System.out.println("begin play!");
        // gets the user guess by calling getGuess()
        int guess = -1;
        
        while (guess != numToGuess) {
            guess = getGuess();
            System.out.println("You guessed " + guess);
            if (guess < numToGuess) {
                System.out.println("greater");
            } else if (guess > numToGuess) {
                System.out.println("Lower");
            }
            //guesses = guesses + 1;
        }
        // When user guesses incorrectly, says whether the number is higher or lower.
        // When user guesses correctly, finishes the game and tells them how many
        // guesses they had.
        System.out.println("Done playing!");
        System.out.println("You got in " + guesses + " guesses");
    }

    int getGuess() {
        System.out.print("Enter a guess: ");
        String input = sc.nextLine();
    
        try {
            int guess = Integer.parseInt(input);
    
            if (guess < gameLow || guess > gameHigh) {
                System.out.println("Please choose a number between " + gameLow + " and " + gameHigh + ".");
            } else if (previousGuesses.contains(guess)) {
                System.out.println("You already guessed that number!");
            } else {
                previousGuesses.add(guess);
                guesses++;
                return guess;
            }
    
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    
        return getGuess(); // retry
    }

    int getNumGuesses() {
        return guesses;
    }
}