package tictactoe.Services;

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
        for (int i = 1; i <= 3; i++) {
            if (game.getPiece(i, 1) == piece && game.getPiece(i, 2) == piece
                    && game.getPiece(i, 3) == piece)
                return true;
        }

        // COLUMN WINS?
        for (int i = 1; i <= 3; i++) {
            if (game.getPiece(1, i) == piece && game.getPiece(2, i) == piece
                    && game.getPiece(3, i) == piece)
                return true;
        }

        // DIAGONAL WINS?
        if (game.getPiece(1, 1) == piece && game.getPiece(2, 2) == piece
                && game.getPiece(3 ,3) == piece) {
            return true;
        } else {
            return game.getPiece(1, 3) == piece && game.getPiece(2, 2) == piece
                    && game.getPiece(3, 1) == piece;
        }
    }
}
