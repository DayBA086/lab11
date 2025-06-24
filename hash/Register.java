package hash;
/**
 * Clase que representa un registro con una clave y un nombre.
 * El estudiante no necesita modificar esta clase.
 */
public class Register {
    private int key;        // Clave que se usará como índice en la tabla
    private String name;    // Nombre asociado al registro

    // Constructor
    public Register(int key, String name) {
        this.key = key;
        this.name = name;
    }

    // Getter de la clave
    public int getKey() {
        return key;
    }

    // Getter del nombre
    public String getName() {
        return name;
    }

    // Representación como texto
    public String toString() {
        return "(" + key + ", " + name + ")";
    }
}
