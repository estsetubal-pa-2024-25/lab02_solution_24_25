package pt.pa.adts.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {
    protected Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueLinkedList<>();
    }

    @Test
    public void dequeue_isCorrect_afterEnqueueDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.front(),"front element is not correct!");
        assertEquals(1, queue.dequeue(),"dequeue element is not correct!");

        assertEquals(2, queue.front(),"front element is not correct!");
        assertEquals(2, queue.dequeue(),"dequeue element is not correct!");

        assertEquals(3, queue.front(),"front element is not correct!");
        assertEquals(3, queue.dequeue(),"dequeue element is not correct!");
    }

    @Test
    public void size_isCorrect_AfterEnqueueDequeue() {
        assertEquals(0, queue.size(), "size is not correct!");
        assertTrue(queue.isEmpty(), "the queue should be empty");

        queue.enqueue(1);
        assertEquals(1, queue.size(), "size is not correct!");
        assertFalse(queue.isEmpty(), "the queue should not be empty");

        queue.enqueue(2);
        assertEquals(2, queue.size(), "size is not correct!");
        assertFalse(queue.isEmpty(), "the queue should not be empty");

        queue.enqueue(3);
        assertEquals(3, queue.size(), "size is not correct!");
        assertFalse(queue.isEmpty(), "the queue should not be empty");

        queue.dequeue();
        assertEquals(2, queue.size(), "size is not correct!");
        assertFalse(queue.isEmpty(), "the queue should not be empty");

        queue.dequeue();
        queue.dequeue();
        assertEquals(0, queue.size(), "size is not correct!");
        assertTrue(queue.isEmpty(), "the queue should be empty");
    }

    @Test
    public void dequeue_Exception_WhenEmpty() {
        assertThrows(QueueEmptyException.class, () -> queue.dequeue());
    }

    @Test
    public void front_Exception_WhenEmpty() {
        assertThrows(QueueEmptyException.class, () -> queue.front());
    }

    @Test
    @DisplayName("Test is empty")
    void testIsEmptyClearTrue(){
        queue.enqueue(1);
        queue.enqueue(3);
        queue.clear();
        assertTrue(queue.isEmpty(),"the queue should be empty after clear");
    }
}