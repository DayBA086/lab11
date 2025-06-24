package ejercicios;
public class TestHash {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: Sin colisiones ===");
        HashSimple h1 = new HashSimple(7);
        for (int x : new int[]{3, 10, 17, 24}) h1.insert(x);
        h1.show();

        System.out.println("\n=== EJERCICIO 2: Sondeo lineal ===");
        HashLinearProbing h2 = new HashLinearProbing(6);
        for (int x : new int[]{12, 18, 24, 30}) h2.insert(x);
        h2.show();

        System.out.println("\n=== EJERCICIO 3: Hash abierto (encadenamiento) ===");
        HashOpen h3 = new HashOpen(5);
        h3.insert(10, "Juan");
        h3.insert(15, "Ana");
        h3.insert(20, "Luis");
        h3.insert(25, "Rosa");

        System.out.println("Buscar clave 20: " + h3.search(20));
        System.out.println("Buscar clave 30: " + h3.search(30));

        System.out.println("\n=== EJERCICIO 4: Eliminar con sondeo lineal ===");
        HashDeleteLinear h4 = new HashDeleteLinear(7);
        for (int x : new int[]{5, 12, 19}) h4.insert(x);
        h4.delete(12);
        h4.show();
    }
}
