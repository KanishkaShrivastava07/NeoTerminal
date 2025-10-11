import java.util.*;

public class RockPaperScissor{
    public static void start() {
     Scanner sc = new Scanner(System.in);
     Random rand = new Random();

     int userScore = 0;
     int computerScore = 0;
     int ties = 0;

     System.out.println("Welcome to Rock-Paper-Scissors!");
     System.out.println("Enter R for Rock, P for Paper, S for Scissors, Q to Quit.");

     while (true) {
         System.out.print("\nYour move (R/P/S/Q): ");
         String userInput = sc.next().toUpperCase();

         if (userInput.equals("Q")) {
             System.out.println("\nGame Over!");
             System.out.println("Scoreboard: ");
             System.out.println("You: " + userScore + " | Computer: " + computerScore + " | Ties: " + ties);
             break;
         }

         if (!userInput.equals("R") && !userInput.equals("P") && !userInput.equals("S")) {
             System.out.println("Invalid input! Use R, P, S or Q.");
             continue;
         }

         //computer random move
         int compMove = rand.nextInt(3);
         String computerChoice = switch (compMove) {
             case 0 -> "R";
             case 1 -> "P";
             default -> "S";
         };

         System.out.println("Computer chose: " + computerChoice);

         if (userInput.equals(computerChoice)) {
             System.out.println("Its a tie!");
             ties++;
         } else if ((userInput.equals("R") && computerChoice.equals("S")) ||
                 (userInput.equals("P") && computerChoice.equals("R")) ||
                 (userInput.equals("S") && computerChoice.equals("P"))) {
             System.out.println("You win this round!");
             userScore++;
         } else {
             System.out.println("Computer wins this round!");
             computerScore++;
         }

         System.out.println("Scoreboard: You: " + userScore + " | Computer: " + computerScore + " | Ties: " + ties);
     }
    }
}
