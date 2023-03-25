package Clinica;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        boolean exit = false;
        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Registrar Doctor");
            System.out.println("2. Registrar Paciente");
            System.out.println("3. Registrar Cita");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Genera un ID:");
                    String id = scanner.nextLine();
                    System.out.println("Ingresa tu nombre completo:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa la especialidad:");
                    String especialidad = scanner.nextLine();
                    sistema.registrarDoctor(id, nombre, especialidad);
                    System.out.println("Doctor registrado de manera satisfactoria.");
                    break;
                case 2:
                    System.out.println("Genera un ID:");
                    id = scanner.nextLine();
                    System.out.println("Ingresa su nombre completo:");
                    nombre = scanner.nextLine();
                    sistema.registrarPaciente(id, nombre);
                    System.out.println("Paciente registrado de manera satisfactoria.");
                    break;
                case 3:
                    System.out.println("Genera un ID de cita:");
                    id = scanner.nextLine();
                    System.out.println("Ingresa la fecha de la cita");
                    String fecha = scanner.nextLine();
                    System.out.println("Ingresa la hora de la cita");
                    String hora = scanner.nextLine();
                    System.out.println("Ingresa el motivo de la consulta:");
                    String motivo = scanner.nextLine();
                    System.out.println("Ingresa el ID del Doctor a asignar:");
                    String doctorId = scanner.nextLine();
                    System.out.println("Ingresa el ID del Paciente a asignar:");
                    String pacienteId = scanner.nextLine();
                    sistema.registrarCita(id, fecha, hora, motivo, doctorId, pacienteId);
                    System.out.println("Cita registrada satisfactoriamente.");
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción invalida.");
            }
        }
    }
}