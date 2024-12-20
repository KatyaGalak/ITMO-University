package prog_lab34.interaction.shorty.dominolovers;

public record DominoGame(String name, int numParticipants) {
    public DominoGame {
        if (numParticipants <= 0) {
            throw new IllegalArgumentException("At least one shorty must participate in the game.");
        }
    }

    public DominoGame(String name) {
        this(name, 1);
    }
}
