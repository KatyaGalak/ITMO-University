package prog_lab34.interaction.location.tablelocation;

public enum TableType {
    DINNING_TABLE("за обеденными столами"),
    COFFE_TABLE("за кофейными столиками"),
    WORK_TABLE("за рабочими столами"),
    BAR_TABLE("за барными столами"),
    GARDEN_TABLE("за садовыми столиками");
    
    private final String description;

    private TableType(String description) {
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