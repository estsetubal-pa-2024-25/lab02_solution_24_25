package pt.pa.adts.queue;

public class NullNotAllowedException extends RuntimeException {
    public NullNotAllowedException() {
        super();
    }

    public NullNotAllowedException(String message) {
        super("NULL - Not allowed");
    }
}
