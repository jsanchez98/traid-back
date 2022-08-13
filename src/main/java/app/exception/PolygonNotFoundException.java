package app.exception;

public class PolygonNotFoundException extends RuntimeException {
    public PolygonNotFoundException(String ticker){
        super("Could not find polygonResponse with ticker: " + ticker);
    }
}
