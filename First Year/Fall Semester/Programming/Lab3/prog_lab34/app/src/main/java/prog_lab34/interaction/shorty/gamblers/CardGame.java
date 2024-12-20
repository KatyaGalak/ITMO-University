package prog_lab34.interaction.shorty.gamblers;

public record CardGame(String name, int numParticipants) {
    public CardGame {
        if (numParticipants <= 0) {
            throw new IllegalArgumentException("At least one shorty must participate in the game.");
        }
    }

    public CardGame(String name) {
        this(name, 1);
    }
}
