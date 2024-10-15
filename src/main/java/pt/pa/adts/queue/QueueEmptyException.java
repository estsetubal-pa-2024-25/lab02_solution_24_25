package pt.pa.adts.queue;

/**
 * An exception that signals that a queue is empty.
 *
 * This exception should be thrown whenever an access is attempted on an empty queue.
 */
public class QueueEmptyException extends RuntimeException {

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super("Queue is empty");
    }
}