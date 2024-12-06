package Queues;

public class LLQueue<E> {
    static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    private Node<E> front, rear;
    private int size;

    public LLQueue() {
        front = rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        }
        E frontData = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return frontData;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        }
        return front.data;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        int dashWidth = (size * 2) - 1;
        System.out.println("-".repeat(dashWidth));
        Node<E> current = front;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" ");
            }
            current = current.next;
        }
        System.out.println();
        System.out.println("-".repeat(dashWidth));
        System.out.println("Size: " + size);
    }

    public static void main(String[] args) {
        LLQueue<Integer> intQueue = new LLQueue<>();
        intQueue.add(10);
        intQueue.add(20);
        intQueue.add(30);
        intQueue.printQueue();
        intQueue.remove();
        intQueue.printQueue();
        System.out.println("Peek: " + intQueue.peek());

        LLQueue<String> stringQueue = new LLQueue<>();
        stringQueue.add("Apple");
        stringQueue.add("Banana");
        stringQueue.printQueue();
        stringQueue.remove();
        stringQueue.printQueue();
    }
}
