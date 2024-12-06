package Queues;

import java.util.HashMap;

public class LRU<T, K> {
    private final AQueue<T> queue;
    private final HashMap<T, K> map;
    @SuppressWarnings("unused")
    private final int capacity;

    public LRU(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Size must be greater than 0");
        this.capacity = size;
        this.queue = new AQueue<>(size);
        this.map = new HashMap<>();
    }

    public K get(T key) {
        if (!map.containsKey(key)) {
            return null;
        }
        queue.remove();
        queue.add(key);
        return map.get(key);
    }

    public void add(T key, K value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            queue.remove();
            queue.add(key);
        } else {
            if (queue.isFull()) {
                T lruKey = queue.remove();
                map.remove(lruKey);
            }
            queue.add(key);
            map.put(key, value);
        }
    }

    public void printCache() {
        System.out.println("Cache Contents:");
        for (T key : queue.arr) {
            if (key != null) {
                System.out.println(key + ": " + map.get(key));
            }
        }
    }

    public static void main(String[] args) {
        LRU<String, String> lruCache = new LRU<>(3);
        lruCache.add("Youtube", "Using Youtube");
        lruCache.add("GFG", "Using Geeks for Geeks");
        lruCache.add("Leetcode", "Using LeetCode");
        lruCache.add("Pubg","Playing Pubg");
        lruCache.printCache();
    }
}
