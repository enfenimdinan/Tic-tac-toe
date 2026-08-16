import java.util.Scanner;

public class TicTacToe {
    static GameBoard gameBoard = new GameBoard();
    static HumanPlayers player = new HumanPlayers(gameBoard);
    static AndroidPlayer android = new AndroidPlayer(gameBoard);
    static Scanner scanner = new Scanner(System.in);
    static boolean isAndroid = false;

    public static void main(String[] args) {
        startGame();
        gameBoard.printBoard();
        if (isAndroid) {
            androidGame();
        } else {
            humanGame();
        }
    }

    static void startGame() {
        System.out.println("---+---+---+---+---+---+---+---+---");
        System.out.println("Hello there! Let's play tic-tac-toe!");
        System.out.println("---+---+---+---+---+---+---+---+---");
        System.out.println("Would you like to play:");
        System.out.println("1) player vs player");
        System.out.println("2) player vs super powerful android");
        System.out.println("Enter answer (1 or 2):");
        int answer = scanner.nextInt();
        isAndroid = answer == 2;
        if (isAndroid) {
            System.out.println("Great, you would play against powerful android.");
        } else {
            System.out.println("Great, there is two players!");
        }

        System.out.println("Good luck!");
    }


    static void humanGame() {
        int count = 0;
        char winner = ' ';
        while (winner == ' ' && count < 9) {
            player.askForMove(count % 2 == 0 ? player.player1MoveSymbol : player.player2MoveSymbol);
            winner = gameBoard.checkWinnerOnBoard();
            count++;
        }

        if (winner != ' ') {
            System.out.println("---+---+---+---+---+---+---+---+---");
            System.out.println("GAME OVER");
            System.out.println("Congratulations, winner is Player " + (winner == 'X' ? "1" : "2"));
            System.out.println("---+---+---+---+---+---+---+---+---");
        }

        if (count == 9) {
            System.out.println("---+---+---+---+---+---+---+---+---");
            System.out.println("GAME OVER!");
            System.out.println("It's a draw!");
            System.out.println("---+---+---+---+---+---+---+---+---");
        }
    }

    static void androidGame() {
        int count = 0;
        char winner = ' ';
        while (winner == ' ' && count < 9) {
            if (count % 2 == 0) {
                player.askForMove(player.player1MoveSymbol);
            } else {
                System.out.println("Android's doing a move...");
                android.doAndroidMove();
            }
            winner = gameBoard.checkWinnerOnBoard();
            count++;
        }

        if (winner != ' ') {
            System.out.println("---+---+---+---+---+---+---+---+---");
            System.out.println("GAME OVER");
            System.out.println("Congratulations, winner is " + (winner == 'X' ? "Player" : "Android"));
            System.out.println("---+---+---+---+---+---+---+---+---");
        }

        if (count == 9) {
            System.out.println("---+---+---+---+---+---+---+---+---");
            System.out.println("GAME OVER!");
            System.out.println("It's a draw!");
            System.out.println("---+---+---+---+---+---+---+---+---");
        }
    }
}
