package ejercicios;
class HashLinearProbing {
    private Integer[] table;

    public HashLinearProbing(int size) {
        table = new Integer[size];
    }

    private int hash(int x) {
        return x % table.length;
    }

    public void insert(int x) {
        int index = hash(x);
        int originalIndex = index;
        while (table[index] != null) {
            System.out.println("Colisión en índice " + index + " para el valor " + x);
            index = (index + 1) % table.length;
            if (index == originalIndex) {
                System.out.println("Tabla llena, no se pudo insertar " + x);
                return;
            }
        }
        table[index] = x;
        System.out.println("Insertado " + x + " en índice " + index);
    }

    public void show() {
        for (int i = 0; i < table.length; i++) {
            System.out.println("[" + i + "] -> " + table[i]);
        }
    }
}
