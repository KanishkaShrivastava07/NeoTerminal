import java.util.*;

public class TicTacToe {
    public static void start() {
        Scanner scn = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Welcome to Tic Tac Toe!");
        char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int Moves = 0;
        boolean GameWon = false;
        while(Moves < 9) {
            //board
            for (int i = 0; i < 9; i += 3) {
                System.out.println(board[i] + " " + board[i + 1] + " " + board[i + 2]);
            }
            System.out.println("Enter Your Move(1-9): ");
            int Input = scn.nextInt();
            //Player
            if (board[Input - 1] != 'O' && board[Input - 1] != 'X') {
                board[Input - 1] = 'X';
                Moves++;
                //check win player
                if(CheckWinner(board,'X')){
                    System.out.println("You Won");
                    GameWon = true;
                    break;
                }
            } else {
                System.out.println("Invalid Move");
                break;
            }
            if (Moves == 9) // if equals 9 break
                break;
            //Computer
            int CompMove = rand.nextInt(9) + 1; // 1 to 9
            if (board[CompMove - 1] != 'X' && board[CompMove - 1] != 'O') {
                board[CompMove - 1] = 'O';
                Moves++;
                System.out.println("Computer Move: " + CompMove);
            }
            //check computer win
            if (CheckWinner(board, 'O')) {
                System.out.println("Computer Won!");
                GameWon = true;
                break;
            }
        }
        //draw
        if (!GameWon && Moves == 9) {
            System.out.println("It's a Draw!");
        }
    }
    static boolean CheckWinner(char[] board, char symbol) {
        // check rows
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == symbol && board[i+1] == symbol && board[i+2] == symbol)
                return true;
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[i] == symbol && board[i+3] == symbol && board[i+6] == symbol)
                return true;
        }
        // check diagonals
        if (board[0] == symbol && board[4] == symbol && board[8] == symbol) return true;
        if (board[2] == symbol && board[4] == symbol && board[6] == symbol) return true;

        return false;
    }
}
