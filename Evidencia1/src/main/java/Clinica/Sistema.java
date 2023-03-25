package Clinica;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Doctor> doctores = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Cita> citas = new ArrayList<>();

    public void registrarDoctor (String id, String nombre, String especialidad){
        Doctor doctor = new Doctor(id, nombre, especialidad);
        doctores.add(doctor);
    }

    public void registrarPaciente (String id, String nombre){
        Paciente paciente = new Paciente(id, nombre);
        pacientes.add(paciente);
    }

    public void registrarCita (String id, String fecha, String hora, String motivo, String doctorId, String
            pacienteId){
        Doctor doctor = findDoctor(doctorId);
        Paciente paciente = findPaciente(pacienteId);
        Cita cita = new Cita(id, fecha, hora, motivo, doctor, paciente);
        citas.add(cita);
    }

    public void GuardarCSV () throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("doctores.csv"));
        for (Doctor doctor : doctores) {
            writer.write(doctor.getId() + "," + doctor.getNombre() + "," + doctor.getEspecialidad() + "\n");
        }
        writer.close();

        writer = new BufferedWriter(new FileWriter("pacientes.csv"));
        for (Paciente paciente : pacientes) {
            writer.write(paciente.getId() + "," + paciente.getNombre() + "\n");
        }
        writer.close();

        writer = new BufferedWriter(new FileWriter("citas.csv"));
        for (Cita cita : citas) {
            writer.write(cita.getId() + "," + cita.getFecha() + "," + cita.getHora() + "," +cita.getMotivo() + "," + cita.getDoctor().getId() + "," + cita.getPaciente().getId() + "\n");
        }
        writer.close();
    }

    public void CargarCSV () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("doctores.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            Doctor doctor = new Doctor(fields[0], fields[1], fields[2]);
            doctores.add(doctor);
        }
        reader.close();

        reader = new BufferedReader(new FileReader("pacientes.csv"));
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            Paciente paciente = new Paciente(fields[0], fields[1]);
            pacientes.add(paciente);
        }
        reader.close();

        reader = new BufferedReader(new FileReader("citas.csv"));
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            String id = fields[0];
            String fecha = fields[1];
            String hora = fields[2];
            String motivo = fields[3];
            Doctor doctor = findDoctor(fields[4]);
            Paciente paciente = findPaciente(fields[5]);
            Cita cita = new Cita(id, fecha, hora, motivo, doctor, paciente);
            citas.add(cita);
        }
        reader.close();
    }

    private Doctor findDoctor (String id){
        for (Doctor doctor : doctores) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    private Paciente findPaciente (String id){
        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }
        return null;
    }

    public void importarCitasCSV(String rutaCitas) {
    }
}
