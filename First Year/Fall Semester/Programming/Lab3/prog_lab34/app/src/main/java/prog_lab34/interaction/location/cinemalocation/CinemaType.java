package prog_lab34.interaction.location.cinemalocation;

public enum CinemaType {
    HOME_CINEMA("в домашнем кинотеатре"),
    OPEN_AIR_CINEMA("в кинотеатре на открытом воздухе"),
    CLASSIC_CINEMA("в обычном кинотеатре"),
    CINEMA_3D("в 3D кинотеатре"),
    CINEMA_5D("в 5D кинотеатре");
    
    private final String description;

    private CinemaType(String description) {
        this.description = description;
    }

    public String describe() {
        return description;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
