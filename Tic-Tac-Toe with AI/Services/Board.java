class Board {
    char[][] board;

    public Board() {
        board = new char[3][3];

        for(char[] row : board)
            Arrays.fill(' ');
    }

    public Board(String initialState) {
        this();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char extract = intialState.charAt(i * 3 +j);
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
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.println(board[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    protected void placePiece(int row, int column, char piece) {
        if (board[row-1][column-1] != ' ')
            System.out.println("This cell is occupied! Choose another one!");
        else
            board[row-1][column-1] = piece
    }
}
