import java.util.*;

public class Game2048 {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[][] board = new int[4][4];
        boolean gameOver = false;

        // add 2 random tiles at the start
        addRandom(board, rand);
        addRandom(board, rand);

        while (!gameOver) {
            printBoard(board);
            System.out.print("Move (U/D/L/R): ");
            char move = sc.next().toUpperCase().charAt(0);

            // copy board to check if move changes board
            int[][] oldBoard = copyBoard(board);

            // move -> user input
            switch (move) {
                case 'U' -> moveUp(board);
                case 'D' -> moveDown(board);
                case 'L' -> moveLeft(board);
                case 'R' -> moveRight(board);
                default -> {
                    System.out.println("Invalid key! Use U/D/L/R");
                    continue;
                }
            }

            // if board changed, add a new random tile
            if (!Arrays.deepEquals(oldBoard, board)) {
                addRandom(board, rand);
            }

            // game is over
            gameOver = isGameOver(board);
            if (gameOver) {
                printBoard(board);
                System.out.println("Game Over! No more moves left.");
            }
        }
    }

    // add a random tile (2 or 4) in an empty position
    static void addRandom(int[][] board, Random rand) {
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) empty.add(new int[]{i, j});
            }
        }
        if (empty.isEmpty()) return;

        int[] pos = empty.get(rand.nextInt(empty.size()));
        board[pos[0]][pos[1]] = rand.nextDouble() < 0.9 ? 2 : 4; // 90% chance 2, 10% chance 4
    }

    // current board
    static void printBoard(int[][] board) {
        System.out.println("\n-------------------------");
        for (int[] row : board) {
            for (int n : row) {
                if (n == 0)
                    System.out.print("|    ");
                else
                    System.out.printf("|%4d", n);
            }
            System.out.println("|");
            System.out.println("-------------------------");
        }
    }

    // copy a board (to compare after move)
    static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[4][4];
        for (int i = 0; i < 4; i++)
            System.arraycopy(board[i], 0, newBoard[i], 0, 4);
        return newBoard;
    }

    // if game is over
    static boolean isGameOver(int[][] board) {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (board[i][j] == 0) return false;

        // check for horizontal merges
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == board[i][j + 1]) return false;

        // vertical merges
        for (int j = 0; j < 4; j++)
            for (int i = 0; i < 3; i++)
                if (board[i][j] == board[i + 1][j]) return false;

        return true;
    }

    // slide and merge a row to the left
    static int[] slideAndMergeRow(int[] row) {
        int[] newRow = new int[4];
        int idx = 0;
        // shift non-zero numbers left
        for (int n : row) if (n != 0) newRow[idx++] = n;
        // merge adjacent same numbers
        for (int i = 0; i < 3; i++) {
            if (newRow[i] != 0 && newRow[i] == newRow[i + 1]) {
                newRow[i] *= 2;
                newRow[i + 1] = 0;
            }
        }
        // compress again after merge
        int[] finalRow = new int[4];
        idx = 0;
        for (int n : newRow) if (n != 0) finalRow[idx++] = n;
        return finalRow;
    }

    // move left
    static void moveLeft(int[][] board) {
        for (int i = 0; i < 4; i++) {
            board[i] = slideAndMergeRow(board[i]);
        }
    }

    // move right
    static void moveRight(int[][] board) {
        for (int i = 0; i < 4; i++) {
            int[] reversed = new int[4];
            for (int j = 0; j < 4; j++)
                reversed[j] = board[i][3 - j]; // reverse row
            reversed = slideAndMergeRow(reversed);
            for (int j = 0; j < 4; j++)
                board[i][j] = reversed[3 - j]; // reverse back
        }
    }

    // transpose board (for up/down)
    static void transpose(int[][] board) {
        for (int i = 0; i < 4; i++)
            for (int j = i + 1; j < 4; j++) {
                int temp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = temp;
            }
    }

    // move up
    static void moveUp(int[][] board) {
        transpose(board);
        moveLeft(board);
        transpose(board);
    }

    // move down
    static void moveDown(int[][] board) {
        transpose(board);
        moveRight(board);
        transpose(board);
    }
}
