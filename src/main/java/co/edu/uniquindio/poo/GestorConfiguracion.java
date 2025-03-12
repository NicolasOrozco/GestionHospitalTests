package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class GestorConfiguracion {

    private static GestorConfiguracion instancia;
    private String horarioAtencion;
    private String maxPacientesPorMedico;
    private LinkedList<String> reglasFacturacion;

    /**
     * Método constructor privado para evitar la instanciación directa fuera de esta clase
     *
     */
    private GestorConfiguracion() {
        horarioAtencion = "8:00 a 20:00";
        maxPacientesPorMedico = "5";
        reglasFacturacion = new LinkedList<>();

        reglasFacturacion.add("Se aceptan tarjetas y efectivo.");
        reglasFacturacion.add("10% de descuento para jubilados.");
        reglasFacturacion.add("20% si cancelas el mismo día.");
    }

    /**
     * Método estático que devuelve la única instancia de la clase gestorConfiguaracion
     * Si la instancia no existe, se crea.
     * @return instancia única del gestor
     */
    public static GestorConfiguracion getInstancia() {
        if (instancia == null) {
            instancia = new GestorConfiguracion();
        }
        return instancia;
    }


    /**
     *
     *
     * @return
     */
    public String configuracionActualString(){
        StringBuilder configuracion = new StringBuilder("Horario de atencion: " + horarioAtencion + "\n" + "\n" +
                "Maximo de pacientes por medico: " + maxPacientesPorMedico + "\n" + "\n" +
                "Reglas de facturacion: " + "\n" + "\n");

        for (String regla : reglasFacturacion) {
            configuracion.append("- ").append(regla).append("\n");
        }

        return configuracion.toString();
    }

    //--------------Getters y Setters de la clase---------------//


    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public String getMaxPacientesPorMedico() {
        return maxPacientesPorMedico;
    }

    public void setMaxPacientesPorMedico(String maxPacientesPorMedico) {
        this.maxPacientesPorMedico = maxPacientesPorMedico;
    }

    public LinkedList<String> getReglasFacturacion() {
        return reglasFacturacion;
    }

    public void setReglasFacturacion(LinkedList<String> reglasFacturacion) {
        this.reglasFacturacion = reglasFacturacion;
    }

}
