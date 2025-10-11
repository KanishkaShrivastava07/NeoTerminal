import java.util.*;

public class MemoryHack {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Memory Hack");
        System.out.println("A sequence will flash briefly. Reproduce it from memory.");
        System.out.println("Press Enter when you are ready...");
        sc.nextLine(); // wait for Enter

        int levels = 5;
        int startLength = 3;
        int displayMS = 800; // how long each sequence is visible (milliseconds)

        for (int level = 1; level <= levels; level++) {
            int length = startLength + (level - 1); // increase length each level
            String seq = generateSequence(length, rand);

            System.out.println("\nLevel " + level + " of " + levels);
            System.out.println("Memorize this sequence:");
            System.out.println(seq);

            // show for short time
            try {
                Thread.sleep(displayMS);
            } catch (InterruptedException e) {
                // ignore
            }

            // clear by printing many new lines
            for (int i = 0; i < 50; i++) System.out.println();

            System.out.print("Enter the sequence: ");
            String guess = sc.nextLine().trim();

            if (guess.equals(seq)) {
                System.out.println("Correct! Moving to the next level.");
            } else {
                System.out.println("Wrong. The correct sequence was: " + seq);
                System.out.println("Game Over. You reached level " + level + ".");
                System.out.println("Returning to menu...");
                return;
            }

            // small pause before next level
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("\nCongratulations! You completed all levels!");
        System.out.println("Returning to menu...");
    }
    //random
    private static String generateSequence(int length, Random rand) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()-_=+[]{};:<>?/|~0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = chars.charAt(rand.nextInt(chars.length())); //formula
            sb.append(c);
        }
        return sb.toString();
    }
}
