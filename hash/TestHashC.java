package hash;

public class TestHashC {
    public static void main(String[] args) {
        HashC hashTable = new HashC(13);

        // Insertar registros
        hashTable.insert(new Register(34, "Ana"));
        hashTable.insert(new Register(3, "Luis"));
        hashTable.insert(new Register(7, "Lucía"));
        hashTable.insert(new Register(30, "Pedro"));
        hashTable.insert(new Register(11, "Carmen"));
        hashTable.insert(new Register(8, "José"));
        hashTable.insert(new Register(7, "Mario")); // clave repetida
        hashTable.insert(new Register(23, "Laura"));
        hashTable.insert(new Register(41, "Carlos"));
        hashTable.insert(new Register(16, "Diana"));
        hashTable.insert(new Register(34, "Julio")); // clave repetida

        System.out.println("\nTabla después de insertar:");
        hashTable.printTable();

        System.out.println("\nEliminando la clave 30...");
        hashTable.delete(30);

        System.out.println("\nTabla después de eliminar la clave 30:");
        hashTable.printTable();

        System.out.println("\nBuscando la clave 23...");
        Register resultado = hashTable.search(23);
        if (resultado != null) {
            System.out.println("Registro encontrado: " + resultado);
        } else {
            System.out.println("Registro no encontrado.");
        }
    }
}
