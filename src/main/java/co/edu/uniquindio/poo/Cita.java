package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Cita {

    private LocalDate fecha;
    private Paciente paciente;
    private Doctor doctor;

    /**
     * Metodo constructor de la clase Cita
     * @param fecha Fecha de la cita
     * @param paciente Paciente que asistirá
     * @param doctor Doctor que atenderá
     */
    public Cita(LocalDate fecha, Paciente paciente, Doctor doctor) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.doctor = doctor;
        paciente.getCitas().add(this);
        doctor.getCitas().add(this);
    }

    public String citaToString(){
        StringBuilder cita = new StringBuilder();

        cita.append("Cita Medica: ")
                .append("fecha: " + fecha + "\n")
                .append("Paciente: " + paciente.getNombre() + "\n")
                .append("Doctor: " + doctor.getNombre() + "\n");

        return cita.toString();
    }

    //--------------Getters y Setters de la clase---------------//


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
