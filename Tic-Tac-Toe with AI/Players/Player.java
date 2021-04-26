package tictactoe.Players;

import tictactoe.Board;

public abstract class Player {
    public char playerType;

    public abstract void makeAMove(Board game);
}//end of class
