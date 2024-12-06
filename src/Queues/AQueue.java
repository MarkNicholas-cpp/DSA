package Queues;

@SuppressWarnings("unchecked")
public class AQueue<D> {
    @SuppressWarnings("unused")
    private int size;
    public D[] arr;
    private int rear;

    public AQueue(int size) {
        if (size <= 0)
            throw new IllegalStateException("Size is not valid");
        this.size = size;
        arr = (D[]) new Object[size]; 
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == arr.length - 1;
    }

    public void add(D n) {
        if (isFull())
            throw new IllegalStateException("Queue is Full");
        arr[++rear] = n;
    }

    public D remove() {
        if (isEmpty())
            throw new IllegalStateException("Queue is Empty");
        D removedValue = arr[0];
        // Shift elements to the left to maintain the order
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return removedValue;
    }

    public D peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is Empty");
        return arr[0];
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        int dashWidth = (rear + 1) * 2 - 1;
        System.out.println("-".repeat(dashWidth));
        for (int i = 0; i <= rear; i++) {
            System.out.print(arr[i]);
            if (i < rear) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("-".repeat(dashWidth));
        System.out.println("Front: " + 0);
        System.out.println("Rear : " + rear);
    }
}
