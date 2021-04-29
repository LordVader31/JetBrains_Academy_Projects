package tictactoe.Services;

public enum GameState {
    DNF("Game not finished"),
    DRAW("Draw"),
    XWIN("X wins"),
    OWIN("O wins");

    final String gameOutput;

    GameState(String gameOutput) {
        this.gameOutput = gameOutput;
    }

    public String getGameOutput() {
        return gameOutput;
    }
}
