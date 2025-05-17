package prog_lab34.interaction.filmhero.exceptions;

public class EmptyListException extends Exception {
    public EmptyListException() {
        super();
    }

    @Override
    public String getMessage() {
        return "[Error] The size of the ArrayList is zero. It is impossible to perform actions.";
    }
    
}
