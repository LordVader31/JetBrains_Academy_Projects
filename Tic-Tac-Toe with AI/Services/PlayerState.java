package tictactoe.Services;

public enum PlayerState {
    HUMAN("user"),
    EASY_AI("easy"),
    MEDIUM_AI("medium"),
    HARD_AI("hard");

    final String playerState;

    PlayerState(String gameOutput) {
        this.playerState = gameOutput;
    }

    public String getPlayerState() {
        return this.playerState;
    }
}
