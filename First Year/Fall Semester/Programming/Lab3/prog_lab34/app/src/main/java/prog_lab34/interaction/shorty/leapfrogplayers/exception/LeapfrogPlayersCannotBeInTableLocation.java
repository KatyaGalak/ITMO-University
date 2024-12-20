package prog_lab34.interaction.shorty.leapfrogplayers.exception;

public class LeapfrogPlayersCannotBeInTableLocation extends RuntimeException {

    public LeapfrogPlayersCannotBeInTableLocation() {
        super();
    }

    @Override
    public String getMessage() {
        return "[Error] LeapfrogPlayres cannot interact in the TableLocation."; 
    }
    
}
