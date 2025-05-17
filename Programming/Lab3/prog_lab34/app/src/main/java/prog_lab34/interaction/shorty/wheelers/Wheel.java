package prog_lab34.interaction.shorty.wheelers;

public record Wheel(String name, int numParticipants) {
    public Wheel {
        if (numParticipants <= 0) {
            throw new IllegalArgumentException("At least one shorty must participate in the game.");
        }
    }

    public Wheel(String name) {
        this(name, 1);
    }
}
