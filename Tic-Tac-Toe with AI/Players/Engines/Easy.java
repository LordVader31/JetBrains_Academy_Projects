package tictactoe.Players.Engines;

import tictactoe.Board;

final public class Easy extends Engine {

    public Easy(char playerType) {
        this.playerType = playerType;
    }

    public void setPlayerType(char playerType) {
        this.playerType = playerType;
    }

    public char getPlayerType() {
        return this.playerType;
    }

    @Override
    public void makeAMove(Board game) {

        int[] randomCoord = generateRandomCoordinates();
        int row = randomCoord[0];
        int column = randomCoord[1];
        while (game.board[row][column] == 'X' || game.board[row][column] == 'O') {
            randomCoord = generateRandomCoordinates();
            row = randomCoord[0];
            column = randomCoord[1];
        }

        game.board[row][column] = playerType;
    }// end of void makeMove(Board)
}//end of class
