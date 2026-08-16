public class GameBoard {
    private char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public void printBoard() {
        System.out.println("Here is board: ");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            if (i < board[i].length - 1) {
                System.out.println();
                System.out.println("--+---+--");
            }
        }
        System.out.println();
    }

    public int getBoardLength() {
        return board.length;
    }

    public boolean isSlotFree(int row, int column) {
        return board[row][column] == ' ';
    }

    public void doMove(int row, int column, char symbol) {
        board[row][column] = symbol;
    }

    public char checkWinnerOnBoard() {
        // row
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != ' ' && board[i][1] == board[i][0] && board[i][2] == board[i][1]) {
                return board[i][0];
            }
        }

        //columns
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] != ' ' && board[1][i] == board[0][i] && board[2][i] == board[1][i]) {
                return board[1][i];
            }
        }

        // diagonal \
        for (int i = 0; i < board.length; i++) {
            if (board[0][0] != ' ' && board[1][1] == board[0][0] && board[2][2] == board[1][1]) {
                return board[0][0];
            }
        }

        // diagonal /
        for (int i = 0; i < board.length; i++) {
            if (board[0][2] != ' ' && board[1][1] == board[0][2] && board[2][0] == board[1][1]) {
                return board[0][2];
            }
        }

        return ' ';
    }
}
