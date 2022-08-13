package app;

public class TraderNotFoundException extends RuntimeException {
    public TraderNotFoundException(Long id){
        super("Could not find trader id: " + id);
    }
}
