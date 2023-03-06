public enum GameState {
    PLAYING("Game in progress"),
    WIN("Winner"),
    DRAW("Draw"),
    NOT_STARTED("Game not active"),
    NO_WIN("No winner");

    private final String message;

    GameState(String message) {
        this.message = message;
    }
}
