package prog_lab34.interaction.filmhero.action;

public class FallAction implements Action {
    @Override
    public String performAction() {
        return "падали";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FallAction;
    }

    @Override
    public int hashCode() {
        return getClass().getSimpleName().hashCode();
    }

    @Override
    public String toString() {
        return "FallAction";
    }
}
