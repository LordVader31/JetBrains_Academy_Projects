package tictactoe.Players.Engines;

import tictactoe.Services.*;

final public class Hard extends Engine {

    private static final int NEGATIVE_SCORE =  -10;
    private static final int POSITIVE_SCORE = 10;
    private static final int NEUTRAL_SCORE = 0;
    private static final int MAX_DEPTH = 6;

    public Hard(char playerType) {
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
        System.out.println("Making move level \"hard\"");
        int[] bestMove = new int[]{0, 0};
        int bestMoveVal = Integer.MIN_VALUE;

        for (int i = 1; i <= game.getNO_OF_ROWS(); i++) {
            for (int j = 1; j <= game.getNO_OF_COLUMNS(); j++) {
                if (!game.isTileMarked(i, j)) {
                    game.placePiece(i, j, this.playerType);
                    int moveValue = miniMax(game, MAX_DEPTH, false);
                    game.removePiece(i, j);
                    if (moveValue > bestMoveVal) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestMoveVal = moveValue;
                    }
                }
            }
        }

        game.placePiece(bestMove[0], bestMove[1], this.playerType);
        game.displayBoard();
    }
    
    private int miniMax(Board game, int depth, boolean isMax) {
        int currentBoardValue = evaluateBoard(game);

        if (Math.abs(currentBoardValue) == POSITIVE_SCORE || depth == 0 || game.isComplete()) {
            return currentBoardValue;
        }
        if (isMax) {
            int highestVal = Integer.MIN_VALUE;
            for (int row = 1; row <= game.getNO_OF_ROWS(); row++) {
                for (int col = 1; col <= game.getNO_OF_COLUMNS(); col++) {
                    if (!game.isTileMarked(row, col)) {
                        game.placePiece(row, col, this.getPlayerType());
                        highestVal = Math.max(highestVal, miniMax(game, depth-1, false));
                        game.removePiece(row, col);
                    }
                }
            }
            return highestVal;
        } else {
            char opponentPlayerType = this.playerType == game.X ? game.O : game.X;
            int lowestVal = Integer.MAX_VALUE;
            for (int row = 1; row <= game.getNO_OF_ROWS(); row++) {
                for (int col = 1; col <= game.getNO_OF_COLUMNS(); col++) {
                    if (!game.isTileMarked(row, col)) {
                        game.placePiece(row, col, opponentPlayerType);
                        lowestVal = Math.min(lowestVal, miniMax(game, depth-1, true));
                        game.removePiece(row, col);
                    }
                }
            }
            return lowestVal;
        }
    }

    private int evaluateBoard(Board game) {
        boolean isXWin = Result.isWinner(game, game.X);
        boolean isOWin = Result.isWinner(game, game.O);
        if (this.playerType == game.X) {
            if (isXWin && !isOWin) {
                return  POSITIVE_SCORE;
            } else if (isOWin && !isXWin) {
                return NEGATIVE_SCORE;
            } else {
                return NEUTRAL_SCORE;
            }
        } else {
            if (isXWin && !isOWin) {
                return  NEGATIVE_SCORE;
            } else if (isOWin && !isXWin) {
                return POSITIVE_SCORE;
            } else {
                return NEUTRAL_SCORE;
            }
        }
    }

}//end of class
