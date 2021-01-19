package Services;

class Result extends Board {

    public Result() {
        super();
    }

    public Result(Board b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = b.board[i][j];
            }
        }
    }

    protected String determineResult() {
        if (isWinner('X'))
            return GameState.XWIN.getGameOutput();
        else if (isWinner('O'))
            return GameState.OWIN.getGameOutput();
        else if (isComplete())
            return GameState.DRAW.getGameOutput();
        else return GameState.DNF.getGameOutput();
    }

    private boolean isWinner(char piece) {
        // ROW WINS?
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == piece && board[i][1] == piece && board[i][2] == piece)
                return true;
        }

        // COLUMN WINS?
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == piece && board[1][i] == piece && board[2][i] == piece)
                return true;
        }

        // DIAGONAL WINS?
        if (board[0][0] == piece && board[1][1] == piece && board[2][2] == piece)
            return true;
        else
            return board[0][2] == piece && board[1][1] == piece && board[2][0] == piece;
    }
}
