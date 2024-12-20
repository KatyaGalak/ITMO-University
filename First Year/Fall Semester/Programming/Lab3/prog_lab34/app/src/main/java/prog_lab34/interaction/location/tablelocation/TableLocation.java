package prog_lab34.interaction.location.tablelocation;

import java.util.Objects;

import prog_lab34.interaction.location.Location;

public class TableLocation extends Location {
    private TableType tableType;

    public TableLocation(String name, TableType tableType) {
        super(name);
        this.tableType = tableType;
    }

    public TableLocation(String name) {
        super(name);
    }

    public TableLocation() {
        super();
    }

    public TableLocation(TableType tableType) {
        this.tableType = tableType;
    }

    @Override
    public String getLocationInfo() {
        return "сидели " + (tableType == null ? "за столиками" : tableType.describe())
                + (name == null ? "" : " \"" + name + "\"") + " и";
    }

    public void setType(TableType tableType) {
        this.tableType = tableType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TableLocation)) return false;
        TableLocation other = (TableLocation) obj;
        return Objects.equals(this.name, other.name) && 
            Objects.equals(this.tableType, other.tableType) && 
            Objects.equals(this.getClass().getSimpleName(), obj.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();

        ans.append(this.getClass().getSimpleName());

        ans.append(getClass().getSimpleName()).append("{");
        ans.append(name != null ? name : "null");
        ans.append(", ");
        ans.append(tableType != null ? tableType.describe() : "null");
        ans.append('}');

        return ans.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass().getSimpleName(), name, tableType);
    }
}
