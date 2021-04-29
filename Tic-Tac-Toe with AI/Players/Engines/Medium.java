package tictactoe.Players.Engines;

import tictactoe.Services.Board;
import tictactoe.Services.Result;

final public class Medium extends Engine {
    final int difficultyIdentifier = 2;

    public Medium(char playerType) {
        this.playerType = playerType;
    }

    public void setPlayerType(char playerType) {
        this.playerType = playerType;
    }

    public char getPlayerType() {
        return playerType;
    }

    @Override
    public void makeAMove(Board game) {
        System.out.println("Making move level \"medium\"");

        int[] coordOfWin;
        // STEP 1 : DO I HAVE A WIN?
        coordOfWin = findWinningMove(game, this.playerType);
        if (coordOfWin != null) {
            System.out.println();
            game.placePiece(coordOfWin[0], coordOfWin[1], this.playerType);
            game.displayBoard();
            return;
        }

        // STEP 2 : BLOCK OPPONENTS WIN (IF THEY HAVE ONE)
        if (this.playerType == 'O') {
            coordOfWin = findWinningMove(game, game.X);
        } else {
            coordOfWin = findWinningMove(game, game.O);
        }

        if(coordOfWin != null) {
            game.placePiece(coordOfWin[0], coordOfWin[1], this.playerType);
            game.displayBoard();
            return;
        }

        // STEP 3 : (LAST RESORT) MAKE A RANDOM MOVE
        placePieceRandomly(game);
        game.displayBoard();
    }

    /**
     * findWinningMove(Board, char)
     * consumes a game and the player type and returns the coordinates of the winning move
     * if there is any. Returns NULL otherwise.
     * @param game - the current state of the board
     * @param playerType - the opponents pieces
     * @return - the opponent's winning coordinates (if any)
     */
    private int[] findWinningMove(Board game, char playerType) {
        for (int i = 1; i <= game.getNO_OF_ROWS(); i++) {
            for (int j = 1; j <= game.getNO_OF_COLUMNS(); j++) {
                if (!game.isTileMarked(i, j)) {
                    game.placePiece(i, j, playerType);
                    if (Result.isWinner(game, playerType)) {
                        game.removePiece(i, j);
                        return new int[]{i, j};
                    }
                    game.removePiece(i, j);
                }
            }
        }
        return null;
    }
}//end of class
