package prog_lab34.interaction.shorty.carouselers.exception;

public class CarouselersArentInAttractionParkException extends RuntimeException {
    public CarouselersArentInAttractionParkException() {
        super();
    }

    @Override
    public String getMessage() {
        return "[Error] Carouselers can only located in the attraction park."; 
    }
    
}
