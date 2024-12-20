package prog_lab34.interaction.filmhero.action;

public class TumbleAction implements Action {
    @Override
    public String performAction() {
        return "кувыркались";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TumbleAction;
    }

    @Override
    public int hashCode() {
        return getClass().getSimpleName().hashCode();
    }

    @Override
    public String toString() {
        return "TumbleAction";
    }
}