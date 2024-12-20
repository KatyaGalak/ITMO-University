package prog_lab34.interaction.community.exceptions;

import prog_lab34.interaction.shorty.Shorty;

public class ShortyAlreadyExistsException extends Exception {
    private String nameShorty;
    public ShortyAlreadyExistsException(Shorty shorty) {
        super();
        nameShorty = shorty.getActivityType().describe();
    }

    @Override
    public String getMessage() {
        return "[Error] Shorty has already been added to the group: " + nameShorty;
    }
    
}
