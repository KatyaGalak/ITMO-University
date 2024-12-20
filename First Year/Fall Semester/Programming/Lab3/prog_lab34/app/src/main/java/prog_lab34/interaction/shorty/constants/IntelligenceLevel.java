package prog_lab34.interaction.shorty.constants;

public enum IntelligenceLevel {
    ANIMAL_STATE("животное состояние"),
    VERY_LOW_LEVEL("очень низкий уровень интеллекта"),
    REDUCED_LEVEL("сниженный уровень интеллекта"),
    AVERAGE_LEVEL("средний уровень интеллекта"),
    ABOVE_AVERAGE_LEVEL("уровень интеллекта выше среднего"),
    GENIUS("гений");

    private final String description;

    private IntelligenceLevel(String description) {
        this.description = description;
    }

    public static IntelligenceLevel fromLevel(int intelligence) {
        if (intelligence < 0) {
            throw new IllegalArgumentException("Уровень интеллекта не может быть отрицательным.");
        } 

        if (intelligence <= 1) {
            return ANIMAL_STATE;
        } else if (intelligence > 1 && intelligence <= 3) {
            return VERY_LOW_LEVEL;
        } else if (intelligence > 3 && intelligence <= 5) {
            return REDUCED_LEVEL;
        } else if (intelligence > 5 && intelligence <= 7) {
            return AVERAGE_LEVEL;
        } else if (intelligence > 7 && intelligence <= 9) {
            return ABOVE_AVERAGE_LEVEL;
        }

        return GENIUS;
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
