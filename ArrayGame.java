import java.util.Scanner;

public class ArrayGame {
    private static final int SIZE = 5; // Size of the grid
    private char[][] board; // Game board
    private int playerRow; // Player's current row
    private int playerCol; // Player's current column

    public ArrayGame() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
        // Initial player position
        playerRow = 0;
        playerCol = 0;
        board[playerRow][playerCol] = 'P';

        // Set goal position
        board[SIZE-1][SIZE-1] = 'G';
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void movePlayer(char direction) {
        // Remove player's current position
        board[playerRow][playerCol] = '-';
        switch (direction) {
            case 'w': // Move up
                playerRow = Math.max(0, playerRow - 1);
                break;
            case 's': // Move down
                playerRow = Math.min(SIZE - 1, playerRow + 1);
                break;
            case 'a': // Move left
                playerCol = Math.max(0, playerCol - 1);
                break;
            case 'd': // Move right
                playerCol = Math.min(SIZE - 1, playerCol + 1);
                break;
        }
        // Set new position
        board[playerRow][playerCol] = 'P';
    }

    public boolean isGameOver() {
        return playerRow == SIZE - 1 && playerCol == SIZE - 1;
    }

    public static void main(String[] args) {
        ArrayGame game = new ArrayGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple 2D Game. Use 'w' (up), 'a' (left), 's' (down), 'd' (right) to move. Goal is to reach 'G'.");

        while (!game.isGameOver()) {
            game.printBoard();
            System.out.print("Move: ");
            char move = scanner.nextLine().charAt(0);
            game.movePlayer(move);
        }

        System.out.println("Congratulations! You've reached the goal.");
    }
}