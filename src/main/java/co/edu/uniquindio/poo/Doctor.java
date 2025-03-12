package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Doctor extends Persona {

    private String especialidad;
    private LinkedList<Cita> citas;

    /**
     * Método constructor de la clase Doctor
     * @param nombre Nombre del doctor
     * @param id Número de identificación del doctor
     * @param especialidad Especialidad del doctor
     */
    public Doctor(String nombre, String id, String especialidad) {
        super(nombre, id);
        this.especialidad = especialidad;
        citas = new LinkedList<>();
    }


    //--------------Getters y Setters de la clase---------------//

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LinkedList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }

}
