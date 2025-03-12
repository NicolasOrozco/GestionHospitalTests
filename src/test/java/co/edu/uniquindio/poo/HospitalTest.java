package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.NoSuchElementException;

class HospitalTest {

    private Hospital hospital;
    private Paciente paciente1;
    private Paciente paciente2;
    private Doctor doctor1;
    private Doctor doctor2;

    @BeforeEach
    void setUp() {
        hospital = new Hospital("Hospital General");
        paciente1 = new Paciente("Hernesto Perez", "123", LocalDate.of(1985, 5, 15));
        paciente2 = new Paciente("Ana Cortazar", "124", LocalDate.of(1990, 8, 20));
        doctor1 = new Doctor("Dr. Smith", "D001", "Cardiología");
        doctor2 = new Doctor("Dr. Garcia", "D002", "Neurología");

        // Agregar un paciente y un doctor al hospital
        hospital.agregarPaciente(paciente1);
        hospital.agregarPaciente(paciente2);
        hospital.agregarDoctor(doctor1);
        hospital.agregarDoctor(doctor2);
    }

    @Test
    void testAgregarPaciente() {
        Paciente pacienteNuevo = new Paciente("Carlos Martinez", "125", LocalDate.of(1995, 3, 10));
        hospital.agregarPaciente(pacienteNuevo);
        assertNotNull(hospital.buscarPaciente("125"));
    }

    @Test
    void testBuscarPaciente() {
        Paciente encontrado = hospital.buscarPaciente("123");
        assertEquals("Hernesto Perez", encontrado.getNombre());
    }

    @Test
    void testBuscarPacienteInexistente() {
        Paciente encontrado = hospital.buscarPaciente("999");
        assertNull(encontrado);
    }

    @Test
    void testEliminarPaciente() {
        hospital.eliminarPaciente("123");
        assertNull(hospital.buscarPaciente("123"));
    }

    @Test
    void testActualizarPaciente() {
        Paciente pacienteActualizado = new Paciente("Juan Perez Actualizado", "123", LocalDate.of(1985, 5, 15));
        hospital.actualizarPaciente("123", pacienteActualizado);
        Paciente actualizado = hospital.buscarPaciente("123");
        assertEquals("Juan Perez Actualizado", actualizado.getNombre());
    }

    @Test
    void testAgregarDoctor() {
        Doctor doctorNuevo = new Doctor("Dr. Morales", "D003", "Pediatría");
        hospital.agregarDoctor(doctorNuevo);
        assertNotNull(hospital.buscarDoctor("D003"));
    }

    @Test
    void testBuscarDoctor() {
        Doctor encontrado = hospital.buscarDoctor("D001");
        assertEquals("Dr. Smith", encontrado.getNombre());
    }

    @Test
    void testBuscarDoctorInexistente() {
        Doctor encontrado = hospital.buscarDoctor("D999");
        assertNull(encontrado);
    }

    @Test
    void testEliminarDoctor() {
        hospital.eliminarDoctor("D001");
        assertNull(hospital.buscarDoctor("D001"));
    }

    @Test
    void testObtenerPacientesNombresPalindromos() {
        LinkedList<Paciente> palindromos = hospital.obtenerPacientesNombresPalindromos();
        assertTrue(palindromos.contains(paciente2));
    }

    @Test
    void testObtenerPacientesNombreDosVocalesIguales() {
        LinkedList<Paciente> vocalesIguales = hospital.obtenerPacientesNombreDosVocalesIguales();
        assertTrue(vocalesIguales.contains(paciente1));
    }

    @Test
    void testBuscarReporte() {
        LocalDate fechaConsulta = LocalDate.of(2025, 3, 1);
        LinkedList<String> enfermedades = new LinkedList<>();
        LinkedList<String> medicamentos = new LinkedList<>();
        enfermedades.add("Gripa");
        medicamentos.add("Dolex");
        Reporte reporte = new Reporte(fechaConsulta, paciente1, doctor1, enfermedades, medicamentos);
        hospital.agregarReporteAHistorial(reporte, "123");
        Reporte encontrado = hospital.buscarReporte(fechaConsulta, "123");
        assertNotNull(encontrado);
    }

    @Test
    void testEliminarReporte() {
        LocalDate fechaConsulta = LocalDate.of(2025, 3, 1);
        LinkedList<String> enfermedades = new LinkedList<>();
        LinkedList<String> medicamentos = new LinkedList<>();
        enfermedades.add("Gripa");
        medicamentos.add("Dolex");
        Reporte reporte = new Reporte(fechaConsulta, paciente1, doctor1, enfermedades, medicamentos);
        hospital.agregarReporteAHistorial(reporte, "123");
        hospital.eliminarReporteDelHistorial(fechaConsulta, "123");
        assertThrows(NoSuchElementException.class, () -> hospital.buscarReporte(fechaConsulta, "123"));
    }
}
