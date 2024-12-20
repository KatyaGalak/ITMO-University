package prog_lab34.interaction.filmhero.action;

public class ShootAction implements Action {
    @Override
    public String performAction() {
        return "палили из пистолета";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ShootAction;
    }

    @Override
    public int hashCode() {
        return getClass().getSimpleName().hashCode();
    }

    @Override
    public String toString() {
        return "ShootAction";
    }
}