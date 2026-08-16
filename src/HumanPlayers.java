import java.util.Scanner;

public class HumanPlayers {
    final char player1MoveSymbol = 'X';
    final char player2MoveSymbol = 'O';
    GameBoard gameBoard;

    public HumanPlayers(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    Scanner scanner = new Scanner(System.in);

    public void askForMove(char player) {
        System.out.println("Now it's turn of Player " + (player == 'X' ? "1 with X" : "2 with O"));
        System.out.println("Let's choose next move!");
        doHumanMove(player);
    }

    public void doHumanMove(char player) {
        System.out.println("Enter row (1-3):");
        int row = scanner.nextInt() - 1;
        System.out.println("Enter column (1-3):");
        int column = scanner.nextInt() - 1;
        if (gameBoard.isSlotFree(row, column)) {
            gameBoard.doMove(row, column, player);
        } else {
            System.out.println("Sorry this spot is taken, try again");
            doHumanMove(player);
        }

        gameBoard.printBoard();
    }
}
