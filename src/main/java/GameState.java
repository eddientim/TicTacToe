public enum GameState {
    WIN("Winner"),
    DRAW("Draw"),
    NO_WINNER("No winner");

    private final String message;

    GameState(String message) {
        this.message = message;
    }
}
