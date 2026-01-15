package geeksforgeeks.Arrays.LeetCode.HashTables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DesignHashMap
{

    private static class Entry {
        int key;
        int value;
        Entry(int k, int v) { key = k; value = v; }
    }

    private final List<LinkedList<Entry>> buckets;
    private final int capacity;

    public DesignHashMap() {
        this.capacity = 10007; // a prime around 10k to reduce collisions
        this.buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    /***
     * What it does:
     *
     * Integer.hashCode(key) just returns the int value itself (for int, hash = key).
     *
     * In Java, int is signed 32-bit. That means values can be negative.
     *
     * When we compute an array index (% capacity), we need a non-negative integer.
     *
     * 0x7fffffff is a hexadecimal constant:
     *
     * In binary: 01111111 11111111 11111111 11111111
     *
     * It’s the largest positive 32-bit signed int (2^31 - 1 = 2147483647).
     * @param key
     * @return
     */
    private int indexForKey(int key) {
        // Use key's hash and ensure non-negative
        return (Integer.hashCode(key) & 0x7fffffff) % capacity;
    }

    /** Insert a (key, value) pair. If key exists, update its value. */
    public void put(int key, int value) {
        int idx = indexForKey(key);
        LinkedList<Entry> bucket = buckets.get(idx);
        for (Entry e : bucket) {
            if (e.key == key) {
                e.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if not present. */
    public int get(int key) {
        int idx = indexForKey(key);
        LinkedList<Entry> bucket = buckets.get(idx);
        for (Entry e : bucket) {
            if (e.key == key) return e.value;
        }
        return -1;
    }

    /***
     * The problem with modifying a list while iterating
     *
     * Suppose you try this:
     *
     * for (Entry e : bucket) {
     *     if (e.key == key) {
     *         bucket.remove(e);  // ❌ DANGER
     *     }
     * }
     *
     *
     * This uses the enhanced for-loop, which is internally using an Iterator.
     *
     * If you modify the list directly (bucket.remove(e)), the iterator detects that the structure of the list changed unexpectedly.
     *
     * Java throws a ConcurrentModificationException to prevent unpredictable behavior.
     *
     * 2️⃣ Why Iterator.remove() is safe
     * Iterator<Entry> it = bucket.iterator();
     * while (it.hasNext()) {
     *     Entry e = it.next();
     *     if (e.key == key) {
     *         it.remove(); // ✅ safe
     *     }
     * }
     *
     *
     * Iterator keeps track of the current position internally.
     *
     * it.remove() tells the iterator “remove the current element”, so it can update its internal bookkeeping.
     *
     * No concurrent modification exception occurs.
     *
     * It works safely even in a linked list or array list.
     */

    /** Removes the mapping for the specified key if present. */
    public void remove(int key)
    {
        int idx = indexForKey(key);
        LinkedList<Entry> bucket = buckets.get(idx);
        Iterator<Entry> it = bucket.iterator(); /***it.next() does two things:
     Entry e = it.next();


     Moves the iterator forward to the next element.

     Returns the element at the new position.

     So before calling it.next(), the iterator is “between” elements — there is no current element yet.

     3️⃣ Why you can’t use a “current value” before calling next()

     The iterator doesn’t automatically know which element is current.

     You must call next() to advance it and retrieve the value.

     Only after calling next() can you operate on the element (e.key, e.value) or remove it safely using it.remove().
     If you modify the list directly (bucket.remove(e)), the iterator detects that the structure of the list changed unexpectedly.

     Java throws a ConcurrentModificationException to prevent unpredictable behavior.
     ***/
        while (it.hasNext())
        {
            Entry e = it.next();
            if (e.key == key)
            {
                it.remove();
                return;
            }
        }
    }

    public static void main(String[] args) {
        DesignHashMap map = new DesignHashMap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1)); // 10
        System.out.println(map.get(3)); // -1
        map.put(2, 200);
        System.out.println(map.get(2)); // 200
        map.remove(2);
        System.out.println(map.get(2)); // -1


    }

}
