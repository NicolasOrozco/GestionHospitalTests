package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Hospital {

    public String nombre;
    public LinkedList<Doctor> doctores;
    public LinkedList<Paciente> pacientes;
    protected GestorConfiguracion gestorConfiguracion;
    protected GestorCitas gestorCitas;
    private String id;

    /**
     * Constructor público de la clase Hospital
     * @param nombre Nombre del hospital
     */
    public Hospital(String nombre) {
        this.nombre = nombre;
        doctores = new LinkedList<>();
        pacientes = new LinkedList<>();
        this.gestorConfiguracion = gestorConfiguracion.getInstancia();
        this.gestorCitas = gestorCitas.getInstance();
    }

    //---------------------CRUD Paciente-------------------------//

    /**
     * Metodo para buscar un paciente por su id.
     *
     * @param id Id del paciente a buscar.
     * @return paciente encontrado o null si no existe.
     */
    public Paciente buscarPaciente(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }

        return null;
    }

    /**
     * Metodo para agregar un nuevo paciente.
     *
     * @param paciente Paciente a agregar.
     */
    public void agregarPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("No se ingresó el paciente que se desea agregar.");
        }

        if (buscarPaciente(paciente.getId()) != null) {
            System.out.println("El paciente ya se encuentra registrado.");
            return;
        }

        pacientes.add(paciente);
        System.out.println("Paciente agregado exitosamente.");
    }

    /**
     * Metodo para actualizar los datos de un paciente.
     *
     * @param id          Id del paciente a actualizar.
     * @param actualizado Paciente con los nuevos datos.
     */
    public void actualizarPaciente(String id, Paciente actualizado) {
        if (actualizado == null) {
            throw new IllegalArgumentException("Los datos del paciente actualizado no pueden ser nulos.");
        }

        Paciente paciente = buscarPaciente(id);
        if (paciente != null) {
            paciente.setId(actualizado.getId());
            paciente.setNombre(actualizado.getNombre());
            System.out.println("Paciente actualizado exitosamente.");
        } else {
            System.out.println("No existe un paciente con el id ingresado.");
        }
    }

    /**
     * Metodo para eliminar un paciente.
     *
     * @param id Id del paciente a eliminar.
     */
    public void eliminarPaciente(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        Paciente paciente = buscarPaciente(id);
        if (buscarPaciente(id) != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente eliminado exitosamente.");
        } else {
            System.out.println("No existe un paciente con el id ingresado.");
        }
    }

    public String historialPaciente(String id) {
        Paciente paciente = buscarPaciente(id);
        return paciente.obtenerHistorialMedico();

    }
    //----------------------------------------------------------//

    //----------------------CRUD Doctor-------------------------//

    /**
     * Metodo para buscar un doctor por su id.
     *
     * @param id Id del doctor a buscar.
     * @return doctor Doctor encontrado o null si no existe.
     */
    public Doctor buscarDoctor(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        for (Doctor doctor : doctores) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }

        return null;
    }

    /**
     * Metodo para agregar un nuevo doctor.
     *
     * @param doctor Doctor a agregar.
     */
    public void agregarDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("No se ingresó el doctor que se desea agregar.");
        }

        if (buscarDoctor(doctor.getId()) != null) {
            System.out.println("El doctor ya se encuentra registrado.");
            return;
        }

        doctores.add(doctor);
        System.out.println("Doctor agregado exitosamente.");
    }

    /**
     * Metodo para actualizar los datos de un doctor.
     *
     * @param id          Id del doctor a actualizar.
     * @param actualizado Doctor con los nuevos datos.
     */
    public void actualizarDoctor(String id, Doctor actualizado) {
        if (actualizado == null) {
            throw new IllegalArgumentException("Los datos del doctor actualizado no pueden ser nulos.");
        }

        Doctor doctor = buscarDoctor(id);
        if (buscarDoctor(id) != null) {
            doctor.setId(actualizado.getId());
            doctor.setNombre(actualizado.getNombre());
            System.out.println("Doctor actualizado exitosamente.");
        } else {
            System.out.println("No existe un doctor con el id ingresado.");
        }
    }

    /**
     * Metodo para eliminar un doctor.
     *
     * @param id Id del doctor a eliminar.
     */
    public void eliminarDoctor(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        Doctor doctor = buscarDoctor(id);
        if (buscarDoctor(id) != null) {
            doctores.remove(doctor);
            System.out.println("Doctor eliminado exitosamente.");
        } else {
            System.out.println("No existe un doctor con el id ingresado.");
        }
    }
    //----------------------------------------------------------//

    //-------------------------Reporte--------------------------//

    /**
     * Método para buscar un reporte dada la fecha y el Id del paciente asociado
     * @param fechaConsulta Fecha en que se generó el reporte
     * @param idPaciente Id del paciente asociado al reporte
     * @return Reporte encontrado
     */
    public Reporte buscarReporte(LocalDate fechaConsulta, String idPaciente) {
        if (fechaConsulta == null || idPaciente == null) {
            throw new IllegalArgumentException("No se ingresaron datos para la búsqueda.");
        }

        Paciente pacienteActual = buscarPaciente(idPaciente);
        if (pacienteActual == null) { // Verificamos si el paciente existe
            throw new NoSuchElementException("No se encontró un paciente con el ID proporcionado.");
        }

        for (Reporte reporte : pacienteActual.getHistorial()) {
            if (reporte.getFechaConsulta().equals(fechaConsulta)) {
                return reporte; // Retorna el reporte si se encuentra
            }
        }
        throw new NoSuchElementException("No existe un reporte con la información ingresada.");
    }

    /**
     * Método para agregar un reporte al historial de un paciente
     * @param reporte Reporte a añadir
     * @param idPaciente Id del paciente a quien va dirigido
     */
    public void agregarReporteAHistorial(Reporte reporte, String idPaciente) {
        Paciente paciente = buscarPaciente(idPaciente);
        if(paciente == null || reporte == null) {
            throw new IllegalArgumentException("No se ingresó el paciente o el reporte");
        }
        paciente.getHistorial().add(reporte);
    }

    /**
     * Método para eliminar un reporte del historial de un paciente
     * dada la fecha del reporte y el id del paciente asociado
     * @param fechaConsulta Fecha en que se generó el reporte
     * @param idPaciente Id del paciente asociado al reporte@param fechaConsulta
     */
    public void eliminarReporteDelHistorial(LocalDate fechaConsulta, String idPaciente) {
        if (fechaConsulta == null || idPaciente == null) {
            throw new IllegalArgumentException("No se ingresaron datos para la búsqueda.");
        }

        Reporte reporte = buscarReporte(fechaConsulta, idPaciente);
        reporte.getPaciente().getHistorial().remove(reporte);

    }

    //----------------------------------------------------------//

    //------------------Métodos adicionales---------------------//

    /**
     * Metodo para obtener una lista con nombres palíndromos de la lista de pacientes.
     * @return palindromos Lista de nombres palíndromos de entre los pacientes.
     */
    public LinkedList<Paciente> obtenerPacientesNombresPalindromos(){

        LinkedList<Paciente> palindromos = new LinkedList<>();

        for(Paciente paciente : pacientes){
            if(esPalindromo(paciente.obtenerNombreSinApellido())){
                palindromos.add(paciente);
            }
        }

        return palindromos;

    }

    /**
     * Metodo para determinar si un nombre es palíndromo o no.
     * @param nombre Nombre del paciente.
     * @return true si es palíndromo, false si no lo es.
     */
    public boolean esPalindromo(String nombre){
        int i = 0;
        int j = nombre.length() - 1;
        while (i <= j) {
            if(nombre.charAt(i) != nombre.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Metodo para obtener una lista de nombres con dos vocales iguales de la lista de pacientes.
     * @return vocalesIguales Lista de nombres con dos vocales iguales de entre los pacientes.
     */
    public LinkedList<Paciente> obtenerPacientesNombreDosVocalesIguales(){

        LinkedList<Paciente> vocalesIguales = new LinkedList<>();

        for(Paciente paciente : pacientes){
            if(nombreDosVocalesIguales(paciente.obtenerNombreSinApellido())){
                vocalesIguales.add(paciente);
            }
        }

        return vocalesIguales;

    }

    /**
     * Metodo para determinar si un nombre tiene dos vocales iguales
     * @param nombre Nombre del paciente.
     * @return true si contiene una vocal repetida, false si no.
     */
    public boolean nombreDosVocalesIguales(String nombre){
        nombre = nombre.toLowerCase();
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (esVocal(c)) {
                int cuentaDeLaVocal = 0;
                for (int j = 0; j < nombre.length(); j++) {
                    if (nombre.charAt(j) == c){
                        cuentaDeLaVocal++;
                        }
                    }
                if (cuentaDeLaVocal >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo para determinar una letra es vocal
     * @return true
     */
    public boolean esVocal(char letra){
        return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
    }

    //----------------------------------------------------------//

    //--------------Getters y Setters de la clase---------------//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(LinkedList<Doctor> doctores) {
        this.doctores = doctores;
    }

    public LinkedList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(LinkedList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public GestorCitas getGestorCitas(){
        return gestorCitas;
    }

    public GestorConfiguracion getGestorConfiguracion(){ return gestorConfiguracion; }

    //----------------------------------------------------------//

}
