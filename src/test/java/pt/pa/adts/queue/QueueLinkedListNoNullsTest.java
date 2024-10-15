package pt.pa.adts.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListNoNullsTest {
    Queue<Integer> queue;

    @BeforeEach
    void setUp() {
      queue = new QueueLinkedListNoNulls<>();
    }

    @Test
    void dequeue_Exception_WhenElementIsNull() {
        assertThrows(NullNotAllowedException.class, ()->queue.enqueue(null));
    }
}