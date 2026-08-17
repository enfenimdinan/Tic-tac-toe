import java.util.Scanner;

public class HumanPlayer implements Player {
    final GameBoard gameBoard;
    final Scanner scanner;

    public HumanPlayer(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.scanner = new Scanner(System.in);
    }

    public String getType() {
        return "Player";
    }

    public Move doMove() {
        System.out.println("Enter row (1-3):");
        int row = scanner.nextInt() - 1;

        System.out.println("Enter column (1-3):");
        int column = scanner.nextInt() - 1;

        return new Move(row, column);
    }
}
