package Queues;

import java.util.*;

public class CQueue {

    public static <E> void interLeave(Queue<E> q) {
        Queue<E> temp = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            temp.add(q.remove());
        }
        while (!temp.isEmpty()) {
            q.add(temp.remove());
            q.add(q.remove());
        }
    }

    public static void firstNonRepeatingCharacter(String streamOfCharacters) {
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26];
        for (char letter : streamOfCharacters.toCharArray()) {
            q.add(letter);
            freq[letter - 'a'] += 1;
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static <E> void queueReverseStack(Queue<E> q) {
        Stack<E> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static <E> void queueReverseRec(Queue<E> q) {
        if (q.isEmpty())
            return;
        E temp = q.remove();
        queueReverseRec(q);
        q.add(temp);
    }

    public static <E> void printQueue(Queue<E> q) {
        if (q.isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        int dashWidth = (q.size() * 2) - 1;
        System.out.println("-".repeat(dashWidth));

        Queue<E> tempQueue = new LinkedList<>();
        while (!q.isEmpty()) {
            E element = q.peek();
            System.out.print(element);
            q.remove();
            tempQueue.add(element);
            if (!q.isEmpty()) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("-".repeat(dashWidth));

        while (!tempQueue.isEmpty()) {
            q.add(tempQueue.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        firstNonRepeatingCharacter("aabbccxbvhxv");

        System.out.println("\nOriginal Queue:");
        printQueue(q);

        System.out.println("Queue Reversed Using Stack:");
        queueReverseStack(q);
        printQueue(q);

        System.out.println("Queue Reversed Using Recursion:");
        queueReverseRec(q);
        printQueue(q);
    }
}
