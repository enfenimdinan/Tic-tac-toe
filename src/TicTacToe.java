import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {
    static Scanner scanner = new Scanner(System.in);
    private final GameBoard gameBoard;
    private final Player player1;
    private final Player player2;

    public TicTacToe(GameBoard gameBoard, Player player1, Player player2) {
        this.gameBoard = gameBoard;
        this.player1 = player1;
        this.player2 = player2;
    }

    private char playerSymbol(Player player) {
        return player == player1 ? 'X' : 'O';
    }

    private Player nextPlayer(Player player) {
        return player == player1 ? player2 : player1;
    }

    public static void main(String[] args) {
        System.out.println("---+---+---+---+---+---+---+---+---");
        System.out.println("Hello there! Let's play tic-tac-toe!");
        System.out.println("There is 9 rounds in total, let's begin!");
        System.out.println("---+---+---+---+---+---+---+---+---");
        GameMode gameMode = chooseGameMode();
        GameBoard gameBoard = new GameBoard();
        Player player1 = gameMode == GameMode.ANDROID_ANDROID
                ? new AndroidPlayer(gameBoard)
                : new HumanPlayer(gameBoard);
        Player player2 = gameMode == GameMode.HUMAN_HUMAN
                ? new HumanPlayer(gameBoard)
                : new AndroidPlayer(gameBoard);
        TicTacToe game = new TicTacToe(gameBoard, player1, player2);
        game.startGame();
    }

    enum GameMode {
        HUMAN_HUMAN,
        HUMAN_ANDROID,
        ANDROID_ANDROID
    }

    static GameMode chooseGameMode() {
        System.out.println("How would you like to play:");
        System.out.println("1) player vs player");
        System.out.println("2) player vs super powerful android");
        System.out.println("3) android vs android");
        System.out.println("Enter answer (1 or 2 or 3):");
        int answer = scanner.nextInt();

        return switch (answer) {
            case 1 -> GameMode.HUMAN_HUMAN;
            case 2 -> GameMode.HUMAN_ANDROID;
            case 3 -> GameMode.ANDROID_ANDROID;
            default -> throw new IllegalStateException("Unexpected value: " + answer);
        };
    }


    private void startGame() {
        int count = 0;
        char winner = ' ';
        char currentPlayerSymbol = ' ';
        Player currentPlayer = player1;
        String playerType = "";
        gameBoard.printBoard();
        while (winner == ' ' && count < 9) {
            currentPlayerSymbol = playerSymbol(currentPlayer);
            playerType = Objects.equals(currentPlayer.getType(), "Player") ? "Player" : "Android";
            System.out.println("Round " + (count + 1));
            announceCurrentPlayer(playerType, currentPlayerSymbol);
            Move move = currentPlayer.doMove();
            if (gameBoard.isSlotFree(move.row(), move.column())) {
                gameBoard.doMove(move.row(), move.column(), currentPlayerSymbol);
                winner = gameBoard.checkWinnerOnBoard();
                count++;
                currentPlayer = nextPlayer(currentPlayer);
            } else {
                System.out.println("Sorry this spot is taken, try again");
            }
            gameBoard.printBoard();
        }

        if (winner != ' ') {
            System.out.println("---+---+---+---+---+---+---+---+---");
            System.out.println("GAME OVER");
            System.out.println("Congratulations, winner is " + playerType + " with symbol " + currentPlayerSymbol);
            System.out.println("---+---+---+---+---+---+---+---+---");
        }

        if (count == 9) {
            System.out.println("---+---+---+---+---+---+---+---+---");
            System.out.println("GAME OVER!");
            System.out.println("It's a draw!");
            System.out.println("---+---+---+---+---+---+---+---+---");
        }
    }

    private void announceCurrentPlayer(String playerType, char symbol) {
        System.out.printf(
                "Now it's %s turn (%c).%n",
                playerType,
                symbol
        );
    }
}
