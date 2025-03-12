package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;

public class GestorCitas {
    private static GestorCitas instance;
    private final LinkedList<Cita> citas;

    private GestorCitas() {
        citas = new LinkedList<>();
    }

    public static GestorCitas getInstance() {
        if (instance == null) {
            instance = new GestorCitas();
        }
        return instance;
    }

    public void agendarCita(LocalDate fecha, Paciente paciente, Doctor doctor) {
        Cita nuevaCita = new Cita(fecha, paciente, doctor);
        citas.add(nuevaCita);
        paciente.getCitas().add(nuevaCita);
        doctor.getCitas().add(nuevaCita);
    }

    public boolean cancelarCita(Cita cita) {
        return citas.remove(cita);
    }

    public LinkedList<Cita> getCitas() {
        return new LinkedList<>(citas);
    }
}
