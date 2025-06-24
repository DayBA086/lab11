package ejercicios;

class HashSimple {
    private Integer[] table;

    public HashSimple(int size) {
        table = new Integer[size];
    }

    private int hash(int x) {
        return x % table.length;
    }

    public void insert(int x) {
        int index = hash(x);
        table[index] = x; // Sin colisiones, se asume que el índice está libre
    }

    public void show() {
        for (int i = 0; i < table.length; i++) {
            System.out.println("[" + i + "] -> " + table[i]);
        }
    }
}
