import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         int choice;

         do{
             System.out.println("Welcome to Neo-Terminal");
             System.out.println("\nSelect a game to play:");
             System.out.println("1. CodeBreaker");
             System.out.println("2. SpyDecoder");
             System.out.println("3. MemoryHack");
             System.out.println("4. TicTacToe");
             System.out.println("5. SnakeGame");
             System.out.println("6. Game2048");
             System.out.println("7. RockPaperScissor");
             System.out.println("8. Exit");

             System.out.print("\nEnter your choice: ");
             choice = sc.nextInt();
             System.out.println();

             switch (choice) {
                 case 1 -> {
                     System.out.println("Launching CodeBreaker ...");
                     CodeBreaker.start();
                 }
                 case 2 -> {
                     System.out.println("Launching SpyDecoder...");
                     SpyDecoder.start();
                 }
                 case 3 -> {
                     System.out.println("Launching MemoryHack...");
                     MemoryHack.start();
                 }
                 case 4 -> {
                     System.out.println("Launching TicTacToe...");
                     TicTacToe.start();
                 }
                 case 5 -> {
                     System.out.println("Launching SnakeGame...");
                     SnakeGame.start();
                 }
                 case 6 -> {
                     System.out.println("Launching Game2048...");
                     Game2048.start();
             }
                 case 7 ->{
                      System.out.println("Launching RockPaperScissor...");
                      RockPaperScissor.start();
             }  
                 case 8 -> System.out.println("Exiting NeoTerminal... Goodbye!");
                 default -> System.out.println("Invalid choice! Try again.");
             }

             if(choice != 8){
                 System.out.println("\nPress Enter to return to menu....");
                 sc.nextLine(); //consume next line
                 sc.nextLine(); // wait for user
             }
         }
         while (choice != 8);
    }
}
