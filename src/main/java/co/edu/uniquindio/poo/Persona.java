package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Persona {

    private String nombre;
    private String id;

    /**
     * Método constructor de la clase Persona
     * @param nombre Nombre de la persona
     * @param id Número de identificación de la persona
     */
    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    //--------------Getters y Setters de la clase---------------//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
