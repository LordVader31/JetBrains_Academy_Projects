package tictactoe.Players.Engines;

import tictactoe.Services.*;

final public class Hard extends Engine {

    private static final int NEGATIVE_SCORE =  -100;
    private static final int POSITIVE_SCORE = 100;
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
        int[] bestMove = new int[]{0, 0};
        int bestMoveVal = Integer.MIN_VALUE;

        for (int i = 1; i <= game.NO_OF_ROWS; i++) {
            for (int j = 1; j <= game.NO_OF_COLUMNS; j++) {
                if (!game.isTileMarked(i, j)) {
                    game.placePiece(i, j, 'X');
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
    }
    
    private int miniMax(Board game, int depth, boolean isMax) {
        int currentBoardValue = evaluateBoard(game);

        if (Math.abs(currentBoardValue) == POSITIVE_SCORE || depth == 0 || game.isComplete()) {
            return currentBoardValue;
        }
        if (isMax) {
            int highestVal = Integer.MIN_VALUE;
            for (int )
        } else {
            int lowestVal = Integer.MAX_VALUE;
        }
        return 0;
    }

    private int evaluateBoard(Board game) {
        boolean isXWin = Result.isWinner(game, 'X');
        boolean isOWin = Result.isWinner(game, 'O');
        if (isXWin && !isOWin) {
            return POSITIVE_SCORE;
        } else if (isOWin && !isXWin) {
            return  NEGATIVE_SCORE;
        } else {
            return NEUTRAL_SCORE;
        }
    }

}//end of class
