package TicTacToe.Players;

import TicTacToe.Board;

abstract class Engine {
    protected char[][] board;

    public void reconfigureBoard(Board b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Board.board[i][j] == 'X')
                    board[i][j] = 'X';
                else if (Board.board[i][j] == 'O')
                    board[i][j] = 'O';
                else board[i][j] = ' ';
            }
        }
    }

    public abstract Board makeAMove();
}
