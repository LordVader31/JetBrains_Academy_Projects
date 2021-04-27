package tictactoe.Players.Humans;

import tictactoe.Board;
import tictactoe.Players.Player;
import java.util.Scanner;

public class Human extends Player {
    final int difficultyIdentifier = 4;

    public Human() {
        this.playerType = 'X';
    }

    public Human(char playerType) {
        this.playerType = playerType;
    }

    @Override
    public void makeAMove(Board game) {
        boolean isPlaceValid;
        int[] coord;
        do {
            coord = acceptCoordinates();
            isPlaceValid = game.placePiece(coord[0], coord[1], playerType);
        } while (!isPlaceValid);
        game.displayBoard();
    }

    private static int[] acceptCoordinates() {
        Scanner move = new Scanner(System.in);
        int[] coord = new int[2];
        System.out.println("Enter the coordinates:");
        String coordinates = move.nextLine();
        if (!isValidCoordinates(coordinates)) {
            acceptCoordinates();
        }
        coordinates = coordinates.replaceAll(" ", "");
        coord[0] = coordinates.charAt(0) - 48;
        coord[1] = coordinates.charAt(1) - 48;
        return coord;
    }

    private static boolean isValidCoordinates(String coordinates) {
        try {
            Integer.parseInt(coordinates.replaceAll(" ", ""));
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        coordinates = coordinates.replaceAll(" ", "");
        if (coordinates.length() != 2) {
            System.out.println("There should be ONLY 2 numbers ");
            return false;
        }
        int row = coordinates.charAt(0) - 48;
        int col = coordinates.charAt(1) - 48;

        if (row < 1 || row > 3 || col < 1 || col > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return  false;
        }
        return true;
    }
}//end of class
