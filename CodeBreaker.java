import java.util.*;

public class CodeBreaker {
    public static void start(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int secretCode = rand.nextInt(100) + 1; //random number 1-100
        int attempts = 0;
        int guess = 0;

        System.out.println("I've generated a secret code between 1 and 100!");
        System.out.println("Can you break it?\n");

        while (guess != secretCode){
            System.out.println("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if(guess < secretCode){
                System.out.println("The code is HIGHER than " + guess + "!");
            } else if(guess > secretCode){
                System.out.println("The code is LOWER than " + guess + "!");
            } else {
                System.out.println("Access granted!");
                System.out.println("You broke the code in " + attempts + " attempts!");
                System.out.println("Impressive!");
            }
        }
    }
}
