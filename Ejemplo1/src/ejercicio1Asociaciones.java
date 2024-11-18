import java.util.ArrayList;
import java.util.Scanner;

// Clase Nota
class Nota {
    private String catedra;
    private double notaExamen;

    public Nota(String catedra, double notaExamen) {
        this.catedra = catedra;
        this.notaExamen = notaExamen;
    }

    public String getCatedra() {
        return catedra;
    }

    public double getNotaExamen() {
        return notaExamen;
    }

    @Override
    public String toString() {
        return "Cátedra: " + catedra + ", Nota: " + notaExamen;
    }
}

// Clase Alumno
class Alumno {
    private String nombreCompleto;
    private long legajo;
    private ArrayList<Nota> notas;

    public Alumno(String nombreCompleto, long legajo) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.notas = new ArrayList<>();
    }

    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    public double calcularPromedio() {
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNotaExamen();
        }
        return notas.size() > 0 ? suma / notas.size() : 0;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + ", Legajo: " + legajo;
    }

    public void mostrarNotas() {
        System.out.println("Notas de " + nombreCompleto + ":");
        for (Nota nota : notas) {
            System.out.println(nota);
        }
    }

    public double getPromedio() {
        return calcularPromedio();
    }
}

// Clase CargaNotas
public class ejercicio1Asociaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        // Cargar alumnos
        System.out.print("¿Cuántos alumnos desea ingresar? ");
        int cantidadAlumnos = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("\nIngrese los datos del alumno " + (i + 1));
            System.out.print("Nombre completo: ");
            String nombre = scanner.nextLine();
            System.out.print("Legajo: ");
            long legajo = Long.parseLong(scanner.nextLine());

            Alumno alumno = new Alumno(nombre, legajo);

            // Cargar notas para cada alumno
            System.out.print("¿Cuántas notas desea ingresar para " + nombre + "? ");
            int cantidadNotas = Integer.parseInt(scanner.nextLine());

            while (cantidadNotas <= 0) {
                System.out.print("Debe ingresar al menos una nota. Intente nuevamente: ");
                cantidadNotas = Integer.parseInt(scanner.nextLine());
            }

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.println("Ingrese la información de la nota " + (j + 1));
                System.out.print("Cátedra: ");
                String catedra = scanner.nextLine();
                System.out.print("Nota: ");
                double notaExamen = Double.parseDouble(scanner.nextLine());

                Nota nota = new Nota(catedra, notaExamen);
                alumno.agregarNota(nota);
            }

            alumnos.add(alumno);
        }

        // Mostrar información y promedios
        System.out.println("\nDatos ingresados:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
            alumno.mostrarNotas();
            System.out.println("Promedio de notas: " + alumno.getPromedio());
        }

        scanner.close();
    }
}

