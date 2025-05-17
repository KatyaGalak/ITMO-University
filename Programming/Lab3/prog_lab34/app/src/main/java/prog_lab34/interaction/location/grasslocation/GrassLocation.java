package prog_lab34.interaction.location.grasslocation;

import java.util.Objects;

import prog_lab34.interaction.location.Location;

public class GrassLocation extends Location {
    private GrassType grassType;

    public GrassLocation(String name, GrassType grassType) {
        super(name);
        this.grassType = grassType;
    }

    public GrassLocation(String name) {
        super(name);
    }

    public GrassLocation() {
        super();
    }

    public GrassLocation(GrassType grassType) {
        this.grassType = grassType;
    }

    @Override
    public String getLocationInfo() {
        return "располагались " + (grassType == null ? "на траве" : grassType.describe())
                + (name == null ? "" : " \"" + name + "\"") + " и";
    }

    public void setType(GrassType grassType) {
        this.grassType = grassType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GrassLocation)) return false;
        GrassLocation other = (GrassLocation) obj;
        return Objects.equals(this.name, other.name) && 
            Objects.equals(this.grassType, other.grassType) && 
            Objects.equals(this.getClass().getSimpleName(), obj.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();

        ans.append(this.getClass().getSimpleName());

        ans.append(getClass().getSimpleName()).append("{");
        ans.append(name != null ? name : "null");
        ans.append(", ");
        ans.append(grassType != null ? grassType.describe() : "null");
        ans.append('}');

        return ans.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass().getSimpleName(), name, grassType);
    }
}
