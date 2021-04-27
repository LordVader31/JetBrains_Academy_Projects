package tictactoe;

final public class Result {

    /**
     * determineResultOutput(Board)
     * ouputs the neccessary message if a player has won and returns true if there is
     * a winner or draw and false otherwise
     * @param game - current state of the board
     * @return - true (if a win / draw ) false (otherwise)
     */
    public static boolean determineResultOutput(Board game) {
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
            return false;
        }
    }

    /**
     * isWinner(Board, char) 
     * consumes the current state of the board and the player's piece and determines
     * they have a winning combination
     * @param game - current state of the board
     * @param piece - player's piece type
     * @return - whether or not they have a winning combination
     */
    public static boolean isWinner(final Board game, final char piece) {
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
