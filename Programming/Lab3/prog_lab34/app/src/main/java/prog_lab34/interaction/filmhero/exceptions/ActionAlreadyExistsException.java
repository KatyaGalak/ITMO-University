package prog_lab34.interaction.filmhero.exceptions;

import prog_lab34.interaction.filmhero.action.Action;

public class ActionAlreadyExistsException extends Exception {
    private String nameAction;
    public ActionAlreadyExistsException(Action action) {
        super();
        nameAction = action.toString();
    }

    @Override
    public String getMessage() {
        return "[Error] Action has already been added: " + nameAction;
    }
    
}