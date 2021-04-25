package tictactoe;

class Result {

    protected static boolean determineResultOutput(Board game) {
        if (isWinner(game, 'X')) {
            System.out.println(GameState.XWIN.getGameOutput());
            return true;
        } else if (isWinner(game, 'O')) {
            System.out.println(GameState.OWIN.getGameOutput());
            return true;
        } else if (game.isComplete()) {
            System.out.println(GameState.DRAW.getGameOutput());
            return true;
        } else {
            //System.out.println(GameState.DNF.getGameOutput());
            return false;
        }
    }

    private static boolean isWinner(Board game, char piece) {
        // ROW WINS?
        for (int i = 0; i < 3; i++) {
            if (game.board[i][0] == piece && game.board[i][1] == piece && game.board[i][2] == piece)
                return true;
        }

        // COLUMN WINS?
        for (int i = 0; i < 3; i++) {
            if (game.board[0][i] == piece && game.board[1][i] == piece && game.board[2][i] == piece)
                return true;
        }

        // DIAGONAL WINS?
        if (game.board[0][0] == piece && game.board[1][1] == piece && game.board[2][2] == piece)
            return true;
        else
            return game.board[0][2] == piece && game.board[1][1] == piece && game.board[2][0] == piece;
    }
}
