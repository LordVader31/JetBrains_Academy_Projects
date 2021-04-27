package tictactoe.Services;
import java.util.Arrays;

public class Board {
    private char[][] board;

    public int NO_OF_ROWS;
    public int NO_OF_COLUMNS;
    public char X;
    public char O;
    public char BLANK;

    public Board() {
        NO_OF_ROWS = 3;
        NO_OF_COLUMNS = 3;
        this.X = 'X';
        this.O = 'O';
        this.BLANK = ' ';
        board = new char[NO_OF_ROWS][NO_OF_COLUMNS];
        for(char[] row : board)
            Arrays.fill(row, ' ');
    }

    public Board(int NO_OF_ROWS, int NO_OF_COLUMNS) {
        this.NO_OF_ROWS =  NO_OF_ROWS;
        this.NO_OF_COLUMNS = NO_OF_COLUMNS;
        this.X = 'X';
        this.O = 'O';
        this.BLANK = ' ';
        board = new char[NO_OF_ROWS][NO_OF_COLUMNS];
        for(char[] row : board)
            Arrays.fill(row, ' ');
    }

    public Board(int NO_OF_ROWS, int NO_OF_COLUMNS, char X, char O, char BLANK) {
        this(NO_OF_ROWS, NO_OF_COLUMNS);
        this.X = X;
        this.O = O;
        this.BLANK = BLANK;
    }

    public Board(char[][] config) {
        this();
        NO_OF_ROWS = config.length;
        NO_OF_COLUMNS = config[0].length;
        for (int i = 0; i < NO_OF_ROWS; i++) {
            for (int j = 0; j < NO_OF_COLUMNS; j++) {
                if (config[i][j] == X) {
                    board[i][j] = X;
                }
                else if (config[i][j] == O)
                    board[i][j] = O;
                else board[i][j] = BLANK;
            }
        }
    }

    public boolean isTileMarked(int row, int column) {
        return board[row - 1][column - 1] != BLANK;
    }

    public boolean isComplete() {
        for (int i = 0; i < NO_OF_ROWS; i++) {
            for (int j = 0; j < NO_OF_COLUMNS; j++) {
                if (board[i][j] == BLANK)
                    return false;
            }
        }
        return true;
    }

    public void displayBoard() {
        for (int i = 1; i <= NO_OF_ROWS * NO_OF_COLUMNS ; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < NO_OF_ROWS; i++) {
            System.out.print("| ");
            for (int j = 0; j < NO_OF_ROWS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        for (int i = 1; i <= NO_OF_ROWS * NO_OF_COLUMNS ; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public char getPiece(int row, int column) {
        return board[row - 1][column - 1];
    }

    public boolean placePiece(int row, int column, char piece) {
        if (board[row - 1][column - 1] != BLANK) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        board[row - 1][column - 1] = piece;
        return true;
    }

    public void removePiece(int row, int column) {
        board[row - 1][column - 1] = BLANK;
    }
}
