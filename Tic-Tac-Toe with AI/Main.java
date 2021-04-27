package tictactoe;

import tictactoe.Players.Engines.Easy;
import tictactoe.Players.Engines.Hard;
import tictactoe.Players.Engines.Medium;
import tictactoe.Players.Humans.Human;
import tictactoe.Players.Player;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner command = new Scanner(System.in);

        while (true) {
            System.out.print("Input command: ");
            String[] menuArgs = command.nextLine().split(" ");
            if (menuArgs[0].equals("exit")) {
                System.exit(0);
            }
            if (menuArgs.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }

            String playOption = menuArgs[0];
            if (playOption.equals("start")) {
                String p1Status = menuArgs[1];
                String p2Status = menuArgs[2];

                // DETERMINE WHAT TYPE PLAYER 1 AND PLAYER 2 ARE 
                int p1Difficulty = determinePlayerDifficulty(p1Status);
                int p2Difficulty = determinePlayerDifficulty(p2Status);
                if (p1Difficulty == 0 || p2Difficulty == 0) {
                    continue;
                }

                // PLAY THE GAME
                setPlayerMatch(p1Difficulty, p2Difficulty);
            } else {
                System.out.println("Bad parameters!");
            }
        } // while loop
    } // end of void main(String[])

    /**
     * determinePlayerDifficulty(String)
     * consumes a String and determine what level of difficulty the player is (easy (1),
     * medium (2) , hard (3), human (4)). Prints out an error message if invalid
     * parameters are entered.
     * @param playerStatus - user entered difficulty
     * @return - player difficulty level
     */
    private static int determinePlayerDifficulty(String playerStatus) {
        if (playerStatus.equals(PlayerState.HUMAN.getPlayerState())) {
            return 4;
        } else if (playerStatus.equals(PlayerState.EASY_AI.getPlayerState())) {
            return 1;
        } else if (playerStatus.equals(PlayerState.MEDIUM_AI.getPlayerState())) {
            return 2;
        } else if (playerStatus.equals(PlayerState.HARD_AI.getPlayerState())) {
            return 3;
        }
        System.out.println("Bad parameters!");
        return 0;
    }
    
    /**
     * setPlayerMatch(bool, bool)
     * consumes the status of the 2 players and plays the game of TTT until the finish
     * @param p1Dif - difficulty level of Player 1
     * @param p2Dif -  difficulty level of Player 2
     */
    private static void setPlayerMatch(int p1Dif, int p2Dif) {
        // SETTING UP THE BOARD
        Board board = new Board();
        board.displayBoard();

        boolean isWin;
        Player p1 = determinePlayerState(p1Dif, 'X');
        Player p2 = determinePlayerState(p2Dif, 'O');
        
        while (!board.isComplete()) {
            // PLAYER 1 MAKES A MOVE
            p1.makeAMove(board);
            isWin = Result.determineResultOutput(board);
            if (isWin) {
                return;
            }
            // PLAYER 2 MAKES A MOVE
            p2.makeAMove(board);
            isWin = Result.determineResultOutput(board);
            if (isWin) {
                return;
            }
        }
    }

    private static Player determinePlayerState(int playerDiff, char playerType) {
        Player p = null;
        if (playerDiff == 1) {
            p = new Easy(playerType);
        } else if (playerDiff == 2) {
            p = new Medium(playerType);
        } else if (playerDiff == 3) {
            p = new Hard(playerType);
        } else {
            p = new Human(playerType);
        }
        return p;
    }
}
