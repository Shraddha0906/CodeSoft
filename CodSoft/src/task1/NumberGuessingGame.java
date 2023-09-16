package task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Random random=new Random();
        int minimumRange=1;
        int maximumRange=100;
        int maxAttempts=5;
        int totalRound=0;
        int totalScore=0;
        boolean playAgain=true;
        System.out.println("Welcome To The Number Guessing Game!!");
        while (playAgain){
            totalRound++;
            int targetNumber = random.nextInt(maximumRange-minimumRange+1)+minimumRange;
            int attempts=0;
            boolean guessedCorrectly=false;
            System.out.println("Round"+totalRound);
            System.out.println("I have selected a number between "+minimumRange+" and "+maximumRange+".");
            System.out.println("Can you guess it? You have "+maxAttempts+ " attempts.");
            while (!guessedCorrectly && attempts <maxAttempts){
                System.out.println("Attempt "+(attempts+1) +" :Enter your Guess: ");
                int userGuess= scanner.nextInt();
                attempts++;
                if (userGuess <targetNumber){
                    System.out.println("Too low! Try again.");
                } else if (userGuess>targetNumber) {
                    System.out.println("Too High! Try again.");
                }else {
                    guessedCorrectly=true;
                    int roundScore = maxAttempts-attempts+1;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number "
                            +targetNumber+" correctly in "+attempts+" attempts.");
                    System.out.println();
                }
            }
      if (!guessedCorrectly){
          System.out.println("Sorry, you've used all your attempts. " +
                  "The correct number was " + targetNumber + ".");
      }
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
        System.out.println("Thanks for playing! Your final score after " + totalRound+ " rounds is: " + totalScore);
    }
}
