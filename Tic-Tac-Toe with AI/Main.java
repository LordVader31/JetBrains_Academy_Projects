package tictactoe;

import tictactoe.Players.Easy;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner command = new Scanner(System.in);

        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println("Input command:");
            String initCommand = command.next();
            if (initCommand.equals("exit")) {
                System.exit(0);
            } else if (initCommand.equals("start")) {
                String p1Status = command.next();
                String p2Status = command.next();
                if (p1Status.equals(PlayerState.HUMAN.getPlayerState())) {
                    if (p2Status.equals(PlayerState.HUMAN.getPlayerState())) {
                        setPlayerMatch(false, false);
                    } else if (p2Status.equals(PlayerState.EASY_AI.getPlayerState())) {
                        setPlayerMatch(false, true);
                    } else {
                        System.out.println("Bad parameters!");
                        continue;
                    }
                    isValidInput = true;
                } else if (p1Status.equals(PlayerState.EASY_AI.getPlayerState())) {
                    if (p2Status.equals(PlayerState.HUMAN.getPlayerState())) {
                        setPlayerMatch(true, false);
                    } else if (p2Status.equals(PlayerState.EASY_AI.getPlayerState())) {
                        setPlayerMatch(true, true);
                    } else {
                        System.out.println("Bad parameters!");
                        continue;
                    }
                    isValidInput = true;
                } else {
                    System.out.println("Bad parameters");
                }
            } else {
                break;
            }
        }
    }

    /**
     * setPlayerMatch(bool, bool) consumes the status of the 2 players and plays the game
     *      of TTT until the finish
     * @param isP1AI - status of Player 1
     * @param isP2AI - status of Player 2
     */
    private static void setPlayerMatch(boolean isP1AI, boolean isP2AI) {
        // SETTING UP THE BOARD
        Board board = new Board();
        board.displayBoard();

        // DEFINING THE EASY PLAYER
        Easy ePlayer1 = new Easy('X');
        Easy ePlayer2 = new Easy('O');

        while (!board.isComplete()) {

            if (isP1AI) {
                System.out.println("Making move level \"easy\"");
                ePlayer1.makeAMove(board);
                board.displayBoard();
            } else {
                int[] coord = acceptCoordinates();
                board.placePiece(coord[0], coord[1], ePlayer1.getPlayerType());
            }

            boolean result = Result.determineResultOutput(board);
            if (result) {
                System.exit(0);
            }

            if (isP2AI) {
                System.out.println("Making move level \"easy\"");
                ePlayer2.makeAMove(board);
                board.displayBoard();
            } else {
                int[] coord = acceptCoordinates();
                board.placePiece(coord[0], coord[1], ePlayer2.getPlayerType());
            }
        }
    }

    /**
     * acceptCoordinates() accepts the input of coordinates from the player
     * @return - row and column of the input position as a int array
     */
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

    /**
     * isValidCoordinates(String) checks if the input string corresponds to valid 
     *      coordinates on a 3x3 TTT board 
     * @param coordinates - the input coordinates
     * @return - whether or not the coordinates are valid.
     */
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
