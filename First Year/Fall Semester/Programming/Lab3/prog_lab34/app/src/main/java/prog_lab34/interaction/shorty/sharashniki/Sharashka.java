package prog_lab34.interaction.shorty.sharashniki;

public record Sharashka(String name, int numParticipants) {
    public Sharashka {
        if (numParticipants <= 0) {
            throw new IllegalArgumentException("At least one shorty must participate in the interaction.");
        }
    }

    public Sharashka(String name) {
        this(name, 1);
    }
}
