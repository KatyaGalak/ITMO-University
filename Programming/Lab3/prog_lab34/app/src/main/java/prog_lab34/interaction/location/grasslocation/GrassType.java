package prog_lab34.interaction.location.grasslocation;

public enum GrassType {
    LAWN("на газоне"),
    MEADOW_GRASS("на луговой траве"),
    SMALL_LEAVED_GRASS("на мелколистной траве"),
    MIX_GRASS("на смешанной травке"),
    WEEDS("среди сорняков");
    
    private final String description;

    private GrassType(String description) {
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
