package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.Locale;

public class Paciente extends Persona {

    private LinkedList<Cita> citas;
    private LocalDate fechaNacimiento;
    private LinkedList<Reporte> historial;

    /**
     * Método constructor de la clase Paciente
     * @param nombre Nombre del paciente
     * @param id Número de identificación del paciente
     */
    public Paciente (String nombre, String id, LocalDate fechaNacimiento) {
        super(nombre, id);
        citas = new LinkedList<>();
        this.fechaNacimiento = fechaNacimiento;
        historial = new LinkedList<>();
    }

    /**
     * Metodo para obtener la edad del paciente
     * @return edad actual del paciente
     */
    public int calcularEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public String obtenerNombreSinApellido(){
        String nombreSinApellido = getNombre().toLowerCase().split(" ")[0];
        return nombreSinApellido;
    }

    public String obtenerHistorialMedico(){
        int i  =1;
        StringBuilder historialMedico = new StringBuilder();
        historialMedico.append("-------HISTORIAL-MEDICO------");
        for (Reporte reporte : historial) {
            historialMedico.append(reporte.reporteToString(i));
            historialMedico.append("\n");
            i++;
        }
        return historialMedico.toString();
    }

    //--------------Getters y Setters de la clase---------------//

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LinkedList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }

    public LinkedList<Reporte> getHistorial() {
        return historial;
    }

    public void setHistorial(LinkedList<Reporte> historial) {
        this.historial = historial;
    }
}
