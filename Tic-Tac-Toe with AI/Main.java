package TicTacToe;

import TicTacToe.Players.Easy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in), txt = new Scanner(System.in);

        Board board = new Board();
        Result gameRes = new Result();
        board.displayBoard();

        Easy ePlayer = new Easy(board);

        while (!board.isComplete()) {
            System.out.println("Enter the coordinates :");
            String coordinates = txt.nextLine();
            if (!isValidCoordinates(coordinates)) continue;
            coordinates = coordinates.replaceAll(" ", "");
            int row = coordinates.charAt(0) - 48;
            int column = coordinates.charAt(1) - 48;

            board.placePiece(row, column, 'X');
            board.displayBoard();

            System.out.println(gameRes.determineResultOutput());

            ePlayer.reconfigureBoard(board);
            System.out.println("Making move level \"easy\"");
            board = ePlayer.makeAMove();
            board.displayBoard();
            System.out.println(gameRes.determineResultOutput());

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
