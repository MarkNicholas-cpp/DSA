import Queues.AQueue;

public class App {
    public static void main(String[] args) {
        AQueue<Integer> q = new AQueue<>(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.printQueue();
    }

}
