public enum GameState {
    DNF("Game not finished"),
    DRAW("Draw"),
    XWIN("X Wins"),
    OWIN("O Wins");

    final String gameOutput;

    public GameState(String gameOutput) {
        this.gameOutput = gameOutput;
    }

    public String getGameOutput() {
        return gameOutput;
    }
}
