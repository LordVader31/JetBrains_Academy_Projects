package tictactoe.Players.Humans;

import tictactoe.Board;
import tictactoe.Players.Player;

import java.util.Scanner;

public class Human extends Player {

    public Human() {
        this.playerType = 'X';
    }

    public Human(char playerType) {
        this.playerType = playerType;
    }

    @Override
    public void makeAMove(Board game) {

    }
}//end of class
