package prog_lab34.interaction.location.parkattractionlocation;

import java.util.Objects;

import prog_lab34.interaction.location.Location;

public class ParkAttractionLocation extends Location {
    private ParkAttractionType parkAttractionType;

    public ParkAttractionLocation(String name, ParkAttractionType parkAttractionType) {
        super(name);
        this.parkAttractionType = parkAttractionType;
    }

    public ParkAttractionLocation(String name) {
        super(name);
    }

    public ParkAttractionLocation() {
        super();
    }

    public ParkAttractionLocation(ParkAttractionType parkAttractionType) {
        this.parkAttractionType = parkAttractionType;
    }

    @Override
    public String getLocationInfo() {
        return "находились " +(parkAttractionType == null ? "в парке аттракционов" : parkAttractionType.describe())
                + (name == null ? "" : " \"" + name + "\"") + " и";
    }

    public void setType(ParkAttractionType parkAttractionType) {
        this.parkAttractionType = parkAttractionType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ParkAttractionLocation)) return false;
        ParkAttractionLocation other = (ParkAttractionLocation) obj;
        return Objects.equals(this.name, other.name) && 
            Objects.equals(this.parkAttractionType, other.parkAttractionType) && 
            Objects.equals(this.getClass().getSimpleName(), obj.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();

        ans.append(this.getClass().getSimpleName());

        ans.append(getClass().getSimpleName()).append("{");
        ans.append(name != null ? name : "null");
        ans.append(", ");
        ans.append(parkAttractionType != null ? parkAttractionType.describe() : "null");
        ans.append('}');

        return ans.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass().getSimpleName(), name, parkAttractionType);
    }
}