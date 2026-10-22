
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalRoundsWon = 0;
        int totalAttempts = 0;
        String playAgain;

        System.out.println("================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("================================");

        do {
            int number = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Enter a whole number.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter a number between 1 and 100.");
                    continue;
                }

                attempts++;
                totalAttempts++;

                if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else if (guess > number) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! You won!");
                    System.out.println("Attempts used: " + attempts);

                    guessedCorrectly = true;
                    totalRoundsWon++;
                    break;
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\nOut of attempts!");
                System.out.println("The correct number was: " + number);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n================================");
        System.out.println("           GAME SUMMARY");
        System.out.println("================================");
        System.out.println("Rounds won: " + totalRoundsWon);
        System.out.println("Total valid guesses: " + totalAttempts);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}
