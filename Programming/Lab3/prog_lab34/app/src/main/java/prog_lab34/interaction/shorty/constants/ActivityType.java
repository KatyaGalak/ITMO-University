package prog_lab34.interaction.shorty.constants;

public enum ActivityType {
    CAROUSEL("Карусельщики"),
    WHEEL("Колесисты"),
    LEAPFROG("Чехардисты"),
    DOMINO("Доминошники"),
    CARDS("Картежники"),
    CINEMA("Киношники"),
    SHARASHKA("Шарашники");
    
    private final String description;

    private ActivityType(String description) {
        this.description = description;
    }

    public String describe() {
        return description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    // TO DO: hashCode and equals
}
