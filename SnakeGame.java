import java.util.*;

public class SnakeGame {
    // board size
    static int width = 8, height = 8;
    static int x, y;                   // snake head position
    static int fruitX, fruitY;         // fruit position
    static int score;                  // player score
    static boolean gameOver;           // game over flag
    //snake tail positon
    static ArrayList<int[]> tail = new ArrayList<>();

    public static void start() {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    //centre(snake-head)
    x = width/ 2;
    y = height/2;

    firstFruit(rand); //first place fruit
    score = 0;
    gameOver = false;

    while(!gameOver){
        draw();//display ->board
        System.out.print("Move (u=up/d=down/l=left/r=right): ");
        char move = sc.next().charAt(0);

        switch (move){
            case 'u': y--; break;
            case 'd': y++; break;
            case 'l': x--; break;
            case 'r': x++; break;
            default: System.out.println("Invalid! Use u/d/l/r"); continue;
        }

        //wall collide
        if(x < 0 || x >= width || y < 0 || y >= height){
            gameOver = true;
            System.out.println("Game over!. you hit the wall");
            break;
        }

        //check self-collision
        for (int[] part : tail){
            if(x == part[0] && y == part[1]){
                gameOver = true;
                System.out.println("Game over! you ran into yourself.");
                break;
            }
        }
        if (gameOver) break;

        //add current head to tail
        tail.add(new int[]{x, y});

        //head -> fruits
        if (x == fruitX && y == fruitY) {
            score += 10;
            //place new fruit
            firstFruit(rand);
            System.out.println("Fruit collected! Score: " + score);
        } else {
            tail.remove(0);
        }
    }
        System.out.println("Final Score: " + score);
    }

    // firstfruit at a random position not on the snake
    static void firstFruit(Random rand){
        do{
            fruitX = rand.nextInt(width);
            fruitY = rand.nextInt(height);
        } while ((fruitX == x && fruitY == y) || isOnTail(fruitX, fruitY));
    }

    //check if position is on the snake tail
    static boolean isOnTail(int fx , int fy){
        for (int[] part : tail){
        if(part[0] == fx && part[1] == fy) return true;
        }
        return false;
    }

    static void draw(){
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            if (i == y && j == x) {
                System.out.print("S"); //snake
            } else if (i == fruitY && j == fruitX) {
                System.out.print("F");//fruits
            } else {
                System.out.print("."); //empty cell
            }
        }
            System.out.println();
        }
    }

    public static void main(String[] args){
        start();
    }
}

