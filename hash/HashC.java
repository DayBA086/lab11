package hash;

public class HashC {

    private static class Element {
        Register register;
        boolean isAvailable;

        public Element() {
            this.register = null;
            this.isAvailable = true;
        }
    }

    private Element[] table;
    private int size;

    public HashC(int size) {
        this.size = size;
        this.table = new Element[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int index = hash(reg.getKey());
        int startIndex = index;
        do {
            if (table[index].isAvailable) {// verifica si hay espacio dispo
                table[index].register = reg; //obj que se va a guardar 
                table[index].isAvailable = false; //cuando esta lleno
                return;
            }
            index = (index + 1) % size;
        } while (index != startIndex);

        System.out.println("ERROR: La tabla está llena, no se puede insertar " + reg);
    }

    public Register search(int key) { // calcula el indice el obj a buscar
        int index = hash(key);
        int startIndex = index;
        do {
            if (!table[index].isAvailable && table[index].register.getKey() == key) {
                return table[index].register;
            }
            if (table[index].isAvailable && table[index].register == null) {
                return null; // nunca hubo un registro aqui
            }
            index = (index + 1) % size;
        } while (index != startIndex);

        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        int startIndex = index;
        do {
            if (!table[index].isAvailable && table[index].register.getKey() == key) {
                table[index].isAvailable = true; // eliminación lógica
                return;// elimina
            }
            if (table[index].isAvailable && table[index].register == null) {//sigue buscando
                return;
            }
            index = (index + 1) % size;
        } while (index != startIndex);
    }

    public void printTable() {
        System.out.println("Estado actual de la tabla:");
        for (int i = 0; i < size; i++) {
            System.out.print("Índice " + i + ": ");
            if (!table[i].isAvailable && table[i].register != null) {
                System.out.println(table[i].register);
            } else {
                System.out.println("VACÍO");
            }
        }
    }
}
