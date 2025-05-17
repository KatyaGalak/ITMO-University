package prog_lab34.interaction.shorty.carouselers;

public record Carousel(String name, int numParticipants) {
    public Carousel {
        if (numParticipants <= 0) {
            throw new IllegalArgumentException("At least one shorty must participate in the game.");
        }
    }

    public Carousel(String name) {
        this(name, 1);
    }
}
