package prog_lab34.interaction.shorty.wheelers.exception;

public class WheelersArentInAttractionParkException extends RuntimeException {

    public WheelersArentInAttractionParkException() {
        super();
    }

    @Override
    public String getMessage() {
        return "[Error] Wheelers can only located in the attraction park."; 
    }
    
}