package tictactoe.Players;
import tictactoe.Board;

abstract class Engine {
    char playerType;

    public abstract void makeAMove(Board game);
}
