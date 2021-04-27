package tictactoe.Players;

import tictactoe.Board;

public abstract class Player {
    public char playerType;

    /**
     * makeAMove(Board)
     * consumes a Board and makes a move on the board and displays it. The move depends
     * whether the player is an EASY_AI, MEDIUM_AI, HARD_AI or HUMAN
     * @param game - the current board state
     */
    public abstract void makeAMove(Board game);
}//end of class
