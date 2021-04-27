package tictactoe.Players.Engines;
import tictactoe.Players.Player;
import java.util.Random;
import tictactoe.Board;
public abstract class Engine extends Player {

    private int[] generateRandomCoordinates() {
        Random random = new Random();
        int[] randomCoord = new int[2];
        randomCoord[0] = random.nextInt(9) / 3 + 1;
        randomCoord[1] = random.nextInt(9) % 3 + 1;

        return randomCoord;
    }
    
    protected void placePieceRandomly(Board game) {
        int[] randomCoord = generateRandomCoordinates();
        int row = randomCoord[0] - 1;
        int column = randomCoord[1] - 1;
        while (game.board[row][column] == 'X' || game.board[row][column] == 'O') {
            randomCoord = generateRandomCoordinates();
            row = randomCoord[0] - 1 ;
            column = randomCoord[1] - 1;
        }
        game.board[row][column] = playerType;
    }
}
