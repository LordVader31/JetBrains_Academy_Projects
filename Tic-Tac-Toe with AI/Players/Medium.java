package tictactoe.Players.Engines;

import tictactoe.Players.Engines.Engine;
import tictactoe.Board;

final public class Medium extends Engine {
    public Medium(char playerType) {
        this.playerType = playerType;
    }

    public void setPlayerType(char playerType) {
        this.playerType = playerType;
    }

    public char getPlayerType() {
        return playerType;
    }

    @Override
    public void makeAMove(Board game) {

    }

    private int[] isOpponentWinning(Board game, char opponentType) {

        return new int[]{0, 0};
    }
}//end of class
