package tictactoe.Players;

import tictactoe.Board;
import java.util.Random;

public class Easy extends Engine {

    @Override
    public void makeAMove(Board game) {
        Random random = new Random();
        int row = random.nextInt(9) / 3;
        int column = random.nextInt(9) % 3;

        while (game.board[row][column] == 'X' || game.board[row][column] == 'O') {
            row = random.nextInt(9) / 3;
            column = random.nextInt(9) % 3;
        }

        game.board[row][column] = 'O';
    }// end of void makeMove(Board)
}//end of class
