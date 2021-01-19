package TicTacToe.Players;

import TicTacToe.Board;
import java.util.Arrays;

public class Easy extends Player {

    public Easy() {
        super();
        board = new char[3][3];
        for(char[] row : board)
            Arrays.fill(row, ' ');
    }

    public Easy(Board b) {
        this();
        reconfigureBoard(b);
    }

    @Override
    public Board makeAMove() {
        int row = (int) (Math.floor(Math.random()) * 3);
        int column = (int) (Math.floor(Math.random()) * 3);

        while (board[row][column] == 'X' || board[row][column] == 'O') {
            row = (int) (Math.floor(Math.random()) * 3);
            column = (int) (Math.floor(Math.random()) * 3);
        }

        board[row][column] = 'O';
        return new Board(board);
    }
}//end of class
