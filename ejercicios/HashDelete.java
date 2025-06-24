package ejercicios;
class HashDeleteLinear {
    private Integer[] table;
    private boolean[] deleted;

    public HashDeleteLinear(int size) {
        table = new Integer[size];
        deleted = new boolean[size];
    }

    private int hash(int x) {
        return x % table.length;
    }

    public void insert(int x) {
        int index = hash(x);
        while (table[index] != null) {
            index = (index + 1) % table.length;
        }
        table[index] = x;
        deleted[index] = false;
    }

    public void delete(int x) {
        int index = hash(x);
        int start = index;
        while (table[index] != null) {
            if (table[index].equals(x)) {
                table[index] = null;
                deleted[index] = true;
                System.out.println("Eliminado " + x + " de la posición " + index);
                return;
            }
            index = (index + 1) % table.length;
            if (index == start) break;
        }
        System.out.println("Clave " + x + " no encontrada.");
    }

    public void show() {
        for (int i = 0; i < table.length; i++) {
            String val = table[i] != null ? table[i].toString() : (deleted[i] ? "X" : "null");
            System.out.println("[" + i + "] -> " + val);
        }
    }
}
