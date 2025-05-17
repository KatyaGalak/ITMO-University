package prog_lab34.interaction.shorty.constants;

public enum TimeSpent {
    FROM_MORNING_TO_EVENING("с утра до вечера"),
    DAY_TO_DAY("день-деньской"),
    WHOLE_DAY("весь день"),
    EVERY_MORNING("каждое утро"),
    ONCE_A_WEEK("раз в неделю"),
    ONCE_A_YEAR("раз в год"),
    ALL_DAY_LONG("целыми днями");

    private final String description;

    private TimeSpent(String description) {
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
