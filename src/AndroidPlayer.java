import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AndroidPlayer implements Player {
    final GameBoard gameBoard;

    public AndroidPlayer(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String getType() {
        return "Android";
    }

    public Move doMove() {
        int boardLength = gameBoard.getBoardLength();
        List<int[]> freeSpaces = new ArrayList<>();
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (gameBoard.isSlotFree(i, j)) {
                    freeSpaces.add(new int[]{i, j});
                }
            }
        }
        Random random = new Random();
        int[] randomArray = freeSpaces.get(random.nextInt(freeSpaces.size()));

        return new Move(randomArray[0], randomArray[1]);
    }
}
