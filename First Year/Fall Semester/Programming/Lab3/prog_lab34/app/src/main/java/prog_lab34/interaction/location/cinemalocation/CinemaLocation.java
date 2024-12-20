package prog_lab34.interaction.location.cinemalocation;

import java.util.Objects;

import prog_lab34.interaction.location.Location;

public class CinemaLocation extends Location {
    private CinemaType cinemaType;

    public CinemaLocation(String name, CinemaType cinemaType) {
        super(name);
        this.cinemaType = cinemaType;
    }

    public CinemaLocation(String name) {
        super(name);
    }

    public CinemaLocation() {
        super();
    }

    public CinemaLocation(CinemaType cinemaType) {
        this.cinemaType = cinemaType;
    }

    @Override
    public String getLocationInfo() {
        return "сидели " + (cinemaType == null ? "в кинотеатре" : cinemaType.describe()) 
                + (name == null ? "" : " \"" + name + "\"") + " и";
    }

    public void setType(CinemaType cinemaType) {
        this.cinemaType = cinemaType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CinemaLocation)) return false;
        CinemaLocation other = (CinemaLocation) obj;
        return Objects.equals(this.name, other.name) && 
            Objects.equals(this.cinemaType, other.cinemaType) && 
            Objects.equals(this.getClass().getSimpleName(), obj.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();

        ans.append(this.getClass().getSimpleName());

        ans.append(getClass().getSimpleName()).append("{");
        ans.append(name != null ? name : "null");
        ans.append(", ");
        ans.append(cinemaType != null ? cinemaType.describe() : "null");
        ans.append('}');

        return ans.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass().getSimpleName(), name, cinemaType);
    }
}
