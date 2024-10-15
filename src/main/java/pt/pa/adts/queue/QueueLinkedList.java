package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        this.trailer = new ListNode(null, null, null); //header not instantiated yet!
        this.header = new ListNode(null, null, this.trailer);

        this.trailer.prev = this.header;
        this.size = 0;
    }

    @Override
    public void enqueue(T elem) throws QueueFullException, NullPointerException {
        try {
            ListNode prevNode = this.trailer.prev;
            ListNode newNode = new ListNode(elem, prevNode, this.trailer);
            this.trailer.prev = newNode;
            prevNode.next = newNode;
            this.size++;
        } catch (OutOfMemoryError e) {
            throw new QueueFullException();
        }
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if(isEmpty())
            throw new QueueEmptyException();

        ListNode removeNode = this.header.next;
        removeNode.next.prev = header;
        header.next = removeNode.next;
        this.size--;
        return removeNode.element;
    }

    @Override
    public T front() throws QueueEmptyException {
        if(isEmpty())
            throw new QueueEmptyException();

        return this.header.next.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void clear() {
        /* return to empty state */
        this.header.next = this.trailer;
        this.trailer.prev = this.header;
        this.size = 0;
    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida


    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
