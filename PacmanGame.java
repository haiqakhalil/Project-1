import java.util.Scanner;
import java.util.Random;

class Food {
    private int row;
    private int col;
    private char symbol;

    public Food(int row, int col) {
        this.row = row;
        this.col = col;
        this.symbol = '.';
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getSymbol() {
        return symbol;
    }
}

class Ghost {
    private int row;
    private int col;
    private String name;
    private Random random;

    public Ghost(int row, int col, String name) {
        this.row = row;
        this.col = col;
        this.name = name;
        this.random = new Random();
    }

    public void moveRandomly(int maxRows, int maxCols) {
        int direction = random.nextInt(4);

        if (direction == 0 && row > 0) {
            row--;
        } else if (direction == 1 && row < maxRows - 1) {
            row++;
        } else if (direction == 2 && col > 0) {
            col--;
        } else if (direction == 3 && col < maxCols - 1) {
            col++;
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getName() {
        return name;
    }
}

class Pacman {
    private int row;
    private int col;
    private int score;

    public Pacman(int row, int col) {
        this.row = row;
        this.col = col;
        this.score = 0;
    }

    public void move(char direction, int maxRows, int maxCols) {
        if (direction == 'w' && row > 0) {
            row--;
        } else if (direction == 's' && row < maxRows - 1) {
            row++;
        } else if (direction == 'a' && col > 0) {
            col--;
        } else if (direction == 'd' && col < maxCols - 1) {
            col++;
        }
    }

    public void addScore(int points) {
        score += points;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getScore() {
        return score;
    }
}

class GameBoard {
    private int rows;
    private int cols;
    private Food[] foodItems;
    private int foodCount;
    private Pacman player;

    public GameBoard(int rows, int cols, Pacman player) {
        this.rows = rows;
        this.cols = cols;
        this.player = player;
        this.foodCount = 10;
        this.foodItems = new Food[foodCount];
        placeFoodItems();
    }

    private void placeFoodItems() {
        foodItems[0] = new Food(0, 2);
        foodItems[1] = new Food(1, 4);
        foodItems[2] = new Food(2, 1);
        foodItems[3] = new Food(2, 6);
        foodItems[4] = new Food(3, 3);
        foodItems[5] = new Food(4, 5);
        foodItems[6] = new Food(5, 0);
        foodItems[7] = new Food(5, 7);
        foodItems[8] = new Food(6, 2);
        foodItems[9] = new Food(7, 4);
    }
    public void checkAndEatFood() {
        for (int i = 0; i < foodItems.length; i++) {
            if (foodItems[i] != null) {
                if (foodItems[i].getRow() == player.getRow() &&
                        foodItems[i].getCol() == player.getCol()) {
                    foodItems[i] = null;
                    foodCount--;
                    player.addScore(10);
                    System.out.println("Yum! Food eaten. Score: " + player.getScore() + " | Food left: " + foodCount);
                }
            }
        }
    }
    public void displayBoard(Ghost ghost) {
        System.out.println("\n--- Board ---");

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == player.getRow() && c == player.getCol()) {
                    System.out.print("C ");
                } else if (r == ghost.getRow() && c == ghost.getCol()) {
                    System.out.print("G ");
                } else if (hasFoodAt(r, c)) {
                    System.out.print(". ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }

        System.out.println("Pacman: (" + player.getRow() + "," + player.getCol() + ")  Ghost: (" +
                ghost.getRow() + "," + ghost.getCol() + ")  Score: " + player.getScore());
    }

    private boolean hasFoodAt(int r, int c) {
        for (Food food : foodItems) {
            if (food != null && food.getRow() == r && food.getCol() == c) {
                return true;
            }
        }
        return false;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

public class PacmanGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Pacman Game ===");
        System.out.println("Controls: w = up, s = down, a = left, d = right");
        System.out.println("C = Pacman, G = Ghost, . = Food, # = Empty");
        System.out.println("Eat all food before the ghost catches you!\n");

        Pacman pacman = new Pacman(0, 0);
        Ghost ghost = new Ghost(7, 7, "Blinky");

        GameBoard board = new GameBoard(8, 8, pacman);
        while (true) {
            board.displayBoard(ghost);
            if (pacman.getRow() == ghost.getRow() && pacman.getCol() == ghost.getCol()) {
                System.out.println("\nOh no! The ghost caught you! Game Over.");
                System.out.println("Final Score: " + pacman.getScore());
                break;
            }

            if (board.getFoodCount() == 0) {
                System.out.println("\nCongratulations! You cleared all the food! You Win!");
                System.out.println("Final Score: " + pacman.getScore());
                break;
            }
            System.out.println("Controls: w = up, s = down, a = left, d = right");
            System.out.print("\nEnter move (w/a/s/d): ");
            char input = scanner.next().charAt(0);

            if (input != 'w' && input != 'a' && input != 's' && input != 'd') {
                System.out.println("Invalid input! Use w, a, s, or d.");
                continue;
            }
            pacman.move(input, board.getRows(), board.getCols());
            ghost.moveRandomly(board.getRows(), board.getCols());
            board.checkAndEatFood();
        }

        scanner.close();
    }
}
