package tictactoe.Players.Engines;

import tictactoe.Board;

final public class Easy extends Engine {
    final int difficultyIdentifier = 1;

    public Easy(char playerType) {
        this.playerType = playerType;
    }

    public void setPlayerType(char playerType) {
        this.playerType = playerType;
    }

    public char getPlayerType() {
        return this.playerType;
    }

    @Override
    public void makeAMove(Board game) {
        System.out.println("Making move level \"easy\"");
        placePieceRandomly(game);
        game.displayBoard();
    }// end of void makeMove(Board)
}//end of class
