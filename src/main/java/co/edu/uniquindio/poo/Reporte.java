package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Reporte implements Cloneable{
    private LocalDate fechaConsulta;
    private Paciente paciente;
    private Doctor doctor;
    private int edadPacienteEnConsulta;
    private LinkedList<String> enfermedades;
    private LinkedList<String> medicamentos;

    public Reporte(LocalDate fechaConsulta, Paciente paciente, Doctor doctor, LinkedList<String> enfermedades, LinkedList<String> medicamentos) {
        this.fechaConsulta = fechaConsulta;
        this.paciente = paciente;
        this.doctor = doctor;
        this.edadPacienteEnConsulta=paciente.calcularEdad();
        this.enfermedades = new LinkedList<>(enfermedades);
        this.medicamentos = new LinkedList<>(medicamentos);
    }


    public Reporte clonar() {
        Reporte copia = null;

        try {
            copia = (Reporte) clone();
            copia.enfermedades = new LinkedList<>(this.enfermedades);
            copia.medicamentos = new LinkedList<>(this.medicamentos);

            copia.paciente = new Paciente(this.paciente.getNombre(),this.paciente.getId(),this.paciente.getFechaNacimiento());
            copia.doctor = new Doctor(this.doctor.getNombre(),this.doctor.getId(),this.doctor.getEspecialidad());

            copia.edadPacienteEnConsulta = copia.paciente.calcularEdad();
            return copia;

        }catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error cloning Reporte");
        }
    }
    public String reporteToString(int n) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("----------Reporte-n"+n+"---------\n")
                .append("Fecha de consulta: " + fechaConsulta + "\n")
                .append("Paciente: " + paciente.getNombre() + "\n")
                .append("Doctor: " + doctor.getNombre() + "Especialidad: " + doctor.getEspecialidad() + "\n")
                .append("Edad: " + edadPacienteEnConsulta + "\n")
                .append("Enfermedades: " + enfermedades + "\n")
                .append(String.join("\n", enfermedades)).append("\n")
                .append("Medicamentos: " + medicamentos + "\n")
                .append(String.join("\n", medicamentos)).append("\n")
                .append("-----------------------------");
        return reporte.toString();
    }

    //-----------------Getters y Setters----------------------//


    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
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

    public int getEdadPacienteEnConsulta() {
        return edadPacienteEnConsulta;
    }

    public void setEdadPacienteEnConsulta(int edadPacienteEnConsulta) {
        this.edadPacienteEnConsulta = edadPacienteEnConsulta;
    }

    public LinkedList<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(LinkedList<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public LinkedList<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(LinkedList<String> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
