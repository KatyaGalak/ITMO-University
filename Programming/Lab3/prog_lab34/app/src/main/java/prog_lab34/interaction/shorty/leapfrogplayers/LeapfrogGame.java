package prog_lab34.interaction.shorty.leapfrogplayers;

public record LeapfrogGame(String name, int numParticipants) {
    public LeapfrogGame {
        if (numParticipants <= 0) {
            throw new IllegalArgumentException("At least one shorty must participate in the game.");
        }
    }

    public LeapfrogGame(String name) {
        this(name, 1);
    }
}
