package tictactoe.Players.Engines;
import tictactoe.Players.Player;
import java.util.Random;
import tictactoe.Services.Board;
public abstract class Engine extends Player {

    private int[] generateRandomCoordinates() {
        Random random = new Random();
        int[] randomCoord = new int[2];
        randomCoord[0] = Math.abs(random.nextInt()) % 3 + 1;
        randomCoord[1] = Math.abs(random.nextInt()) % 3 + 1;
        return randomCoord;
    }
    
    protected void placePieceRandomly(Board game) {
        int[] randomCoord = generateRandomCoordinates();
        int row = randomCoord[0] ;
        int column = randomCoord[1] ;
        while (game.getPiece(row, column) == game.X || game.getPiece(row, column) == game.O) {
            randomCoord = generateRandomCoordinates();
            row = randomCoord[0];
            column = randomCoord[1];
        }
        game.placePiece(row, column, playerType);
    }
}
