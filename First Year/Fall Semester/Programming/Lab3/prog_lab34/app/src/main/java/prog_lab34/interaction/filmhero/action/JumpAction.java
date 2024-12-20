package prog_lab34.interaction.filmhero.action;

public class JumpAction implements Action {
    @Override
    public String performAction() {
        return "прыгали";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof JumpAction;
    }

    @Override
    public int hashCode() {
        return getClass().getSimpleName().hashCode();
    }

    @Override
    public String toString() {
        return "JumpAction";
    }
}
