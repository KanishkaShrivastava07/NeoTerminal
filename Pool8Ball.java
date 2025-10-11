import java.util.*;

public class Pool8Ball{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Balls: 1-7 solid, 9-15 stripes, 8-ball in the end
        String[] balls = {"🔴", "🟠", "🟡", "🟢", "🔵", "🟣", "🟤",
                "🔴", "🟠", "🟡", "🟢", "🔵", "🟣", "🟤", "🎱"};

        List<String> remainingBalls = new ArrayList<>(Arrays.asList(balls));
        List<String> playerBalls = new ArrayList<>();
        List<String> computerBalls = new ArrayList<>();
        boolean playerTurn = true; // player starts first
        boolean gameOver = false;

        System.out.println("=== Welcome to 8-Ball Pool CLI ===");

        while (!gameOver && !remainingBalls.isEmpty()) {
            System.out.println("\nRemaining Balls: " + remainingBalls);
            System.out.println("Player Balls: " + playerBalls);
            System.out.println("Computer Balls: " + computerBalls);

            String pocketed;
            if (playerTurn) {
                System.out.println("\nYour Turn! Type 'p' to pocket a ball:");
                sc.next(); // wait for player input
                //random for player
                pocketed = remainingBalls.remove(rand.nextInt(remainingBalls.size()));
                System.out.println("You pocketed: " + pocketed);
                //add to list
                playerBalls.add(pocketed);
            } else {
                System.out.println("\nComputer's Turn...");
                pocketed = remainingBalls.remove(rand.nextInt(remainingBalls.size()));
                System.out.println("Computer pocketed: " + pocketed);
                computerBalls.add(pocketed);
            }

            // Check if 8-ball is pocketed
            if (pocketed.equals("🎱")) {
                gameOver = true;
                if (playerTurn) {
                    System.out.println("\nYou pocketed the 8-ball! You win! 🎉");
                } else {
                    System.out.println("\nComputer pocketed the 8-ball! Computer wins! 💻");
                }
            }

            // Switch turn for next round
            playerTurn = !playerTurn;
        }

        // Final Scores
        System.out.println("\n=== Final Scores ===");
        System.out.println("Player Balls: " + playerBalls.size());
        System.out.println("Computer Balls: " + computerBalls.size());
        System.out.println("Thanks for playing!");
    }
}
