// TASK 1
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Maximum number of attempts per round
        int maxAttempts = 6; 

        // Number of rounds played
        int rounds = 0; 

        // User's score
        int score = 0; 

        boolean playAgain = true;
        while (playAgain) {
            rounds++;

            // Generate a random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1; 
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + rounds + ": Guess the number between 1 and 100.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    score++;
                    System.out.println("Congratulations! You guessed the correct number.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is " + score + " after " + rounds + " rounds.");
        scanner.close();
    }
}
