package tictactoe;

import tictactoe.Players.Easy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in), txt = new Scanner(System.in);

        // SETTING UP THE BOARD
        Board board = new Board();
        tictactoe.Result gameRes = new tictactoe.Result();
        board.displayBoard();

        // DEFINING THE EASY PLAYER
        Easy ePlayer = new Easy();

        while (!board.isComplete()) {
            // S1 : ACCEPTING THE COORDINATES
            System.out.println("Enter the coordinates :");
            String coordinates = txt.nextLine();
            if (!isValidCoordinates(coordinates))
                continue;
            coordinates = coordinates.replaceAll(" ", "");
            int row = coordinates.charAt(0) - 48;
            int column = coordinates.charAt(1) - 48;

            // S2 : PLACING THE PIECE ON THE BOARD
            board.placePiece(row, column, 'X');
            board.displayBoard();

            // S3 : DETERMINING THE RESULT OF THE MOVE
            boolean result = Result.determineResultOutput(board);
            if (result) {
                System.exit(0);
            }
            System.out.println("Making move level \"easy\"");
            ePlayer.makeAMove(board);
            board.displayBoard();

            // S3 : DETERMINING THE RESULT OF THE MOVE
            result = Result.determineResultOutput(board);
            if (result) {
                System.exit(0);
            }
        }
    }

    public static boolean isValidCoordinates(String coordinates) {
        try {
            Integer.parseInt(coordinates.replaceAll(" ", ""));
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        coordinates = coordinates.replaceAll(" ", "");
        int row = coordinates.charAt(0) - 48;
        int col = coordinates.charAt(1) - 48;

        System.out.println(row + ":" + col);
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return  false;
        }
        return true;
    }
}
