package prog_lab34.interaction.filmhero.action;

public class RunAction implements Action {
    @Override
    public String performAction() {
        return "бегали";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RunAction;
    }

    @Override
    public int hashCode() {
        return getClass().getSimpleName().hashCode();
    }

    @Override
    public String toString() {
        return "RunAction";
    }
}
