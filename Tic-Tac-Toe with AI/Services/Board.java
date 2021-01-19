package TicTacToe;

import java.util.Arrays;

public class Board {
    public static char[][] board;

    public Board() {
        board = new char[3][3];
        for(char[] row : board)
            Arrays.fill(row, ' ');
    }

    public Board(char[][] config) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (config[i][j] == 'X')
                    board[i][j] = 'X';
                else if (config[i][j] == 'O')
                    board[i][j] = 'O';
                else board[i][j] = ' ';
            }
        }
    }

    public Board(String initialState) {
        this();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char extract = initialState.charAt(i * 3 +j);
                if (extract == 'X')
                    board[i][j] = 'X';
                else if (extract == 'O')
                    board[i][j] = 'O';
            }
        }
    }

    protected boolean isComplete() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    protected void displayBoard() {
        System.out.println("\n");
        for (int i = 1; i <= 9 ; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        for (int i = 1; i <= 9 ; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }

    protected char decidedWhoseTurn() {
        return countPiece('X') == countPiece('O') ? 'X' : 'O';
    }

    private int countPiece(char piece) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == piece)
                    counter++;
            }
        }
        return counter;
    }

    protected void placePiece(int row, int column, char piece) {
        if (board[row-1][column-1] != ' ')
            System.out.println("This cell is occupied! Choose another one!");
        else
            board[row-1][column-1] = piece;
    }
}
