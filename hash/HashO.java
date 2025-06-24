package hash;

import java.util.LinkedList;

public class HashO {
    private LinkedList<Register>[] table; // arreglo de listas enlazadas
    private int size;

    // Constructor
    public HashO(int size) {
        this.size = size; // num total de posiciones 
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Función hash
    private int hash(int key) {
        return key % size;
    }

    // Inserta un registro
    public void insert(Register reg) {
        int index = hash(reg.getKey());// aca se encadenan
        table[index].add(reg);
    }

    // Busca un registro por su clave
    public Register search(int key) {
        int index = hash(key);
        for (Register reg : table[index]) {
            if (reg.getKey() == key) {
                return reg;
            }
        }
        return null;
    }

    // Elimina un registro por su clave
    public void delete(int key) {
        int index = hash(key);
        Register toRemove = null;
        for (Register reg : table[index]) {
            if (reg.getKey() == key) {
                toRemove = reg;
                break;
            }
        }
        if (toRemove != null) {
            table[index].remove(toRemove);
        }
    }

    // Imprime la tabla hash
    public void printTable() {
        System.out.println("Estado actual de la tabla con encadenamiento:");
        for (int i = 0; i < size; i++) {
            System.out.print("Índice " + i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("VACÍO");
            } else {
                for (Register reg : table[i]) {
                    System.out.print(reg + " -> ");
                }
                System.out.println("NULL");
            }
        }
    }
}
