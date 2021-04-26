package tictactoe.Players.Engines;
import tictactoe.Board;
import tictactoe.Players.Player;
import java.util.Random;

public abstract class Engine extends Player {

    protected int[] generateRandomCoordinates() {
        Random random = new Random();
        int[] randomCoord = new int[2];
        randomCoord[0] = random.nextInt(9) / 3;
        randomCoord[1] = random.nextInt(9) % 3;

        return randomCoord;
    }
}
