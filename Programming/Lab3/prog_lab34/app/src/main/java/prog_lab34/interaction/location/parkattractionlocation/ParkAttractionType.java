package prog_lab34.interaction.location.parkattractionlocation;

public enum ParkAttractionType {
    SAFARI("в сафари-парке"),
    MEGAPARK("в мегапарке"),
    ENTERTAINMENT_PARK("в парке развлечений");
    
    private final String description;

    private ParkAttractionType(String description) {
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
