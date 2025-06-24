package ejercicios;
import java.util.*;
class HashOpen {
    private LinkedList<Pair>[] table;

    public HashOpen(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) table[i] = new LinkedList<>();
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void insert(int key, String name) {
        int index = hash(key);
        table[index].add(new Pair(key, name));
    }

    public String search(int key) {
        int index = hash(key);
        for (Pair p : table[index]) {
            if (p.key == key) return p.value;
        }
        return null;
    }

    static class Pair {
        int key;
        String value;

        Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}

