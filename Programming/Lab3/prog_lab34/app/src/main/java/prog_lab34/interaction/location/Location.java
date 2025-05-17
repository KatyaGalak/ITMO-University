package prog_lab34.interaction.location;

public abstract class Location {
    public String name;

    public Location() {}

    public Location(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getLocationInfo();
}
