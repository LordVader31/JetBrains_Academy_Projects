package tictactoe.Players;

import tictactoe.Board;
import java.util.Random;

public class Easy extends Engine {

    @Override
    public void makeAMove(Board game) {
        Random random = new Random();
        int choice = 1 + random.nextInt(2);
        int row = choice;
        choice = 1 + random.nextInt(2);
        int column = choice;
        System.out.printf("ROW : [%d], COLUMN : [%d]", row, column);

        while (game.board[row][column] == 'X' || game.board[row][column] == 'O') {
            row = random.nextInt(2);
            column = 1 + random.nextInt(2);
            System.out.printf("ROW : [%d], COLUMN : [%d]\n", row, column);
        }

        game.board[row][column] = 'O';
    }// end of void makeMove(Board)
}//end of class
