import java.util.ArrayList;
import java.util.Scanner;

// Clase Ingrediente
class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidadMedida;

    public Ingrediente(String nombre, double cantidad, String unidadMedida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
    }

    @Override
    public String toString() {
        return "Ingrediente: " + nombre + ", Cantidad: " + cantidad + " " + unidadMedida;
    }
}

// Clase Plato
class Plato {
    private String nombreCompleto;
    private double precio;
    private boolean esBebida;
    private ArrayList<Ingrediente> ingredientes;

    public Plato(String nombreCompleto, double precio, boolean esBebida) {
        this.nombreCompleto = nombreCompleto;
        this.precio = precio;
        this.esBebida = esBebida;
        this.ingredientes = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public boolean esBebida() {
        return esBebida;
    }

    public void mostrarPlato() {
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Precio: $" + precio);
        if (esBebida) {
            System.out.println("Es una bebida. No tiene ingredientes.");
        } else {
            System.out.println("Ingredientes:");
            for (Ingrediente ingrediente : ingredientes) {
                System.out.println(ingrediente);
            }
        }
        System.out.println("====================================");
    }

    @Override
    public String toString() {
        return nombreCompleto + " - Precio: $" + precio;
    }
}

// Clase MenuRestaurant
public class ejercicio2Asociaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();

        // Cargar platos
        System.out.print("¿Cuántos platos desea agregar al menú? ");
        int cantidadPlatos = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.println("\nIngrese los datos del plato " + (i + 1));

            System.out.print("Nombre del plato: ");
            String nombrePlato = scanner.nextLine();
            System.out.print("Precio: ");
            double precioPlato = Double.parseDouble(scanner.nextLine());
            System.out.print("¿Es una bebida? (true/false): ");
            boolean esBebida = Boolean.parseBoolean(scanner.nextLine());

            Plato plato = new Plato(nombrePlato, precioPlato, esBebida);

            if (!esBebida) {
                System.out.print("¿Cuántos ingredientes tiene el plato? ");
                int cantidadIngredientes = Integer.parseInt(scanner.nextLine());

                while (cantidadIngredientes <= 0) {
                    System.out.print("Debe ingresar al menos un ingrediente. Intente nuevamente: ");
                    cantidadIngredientes = Integer.parseInt(scanner.nextLine());
                }

                for (int j = 0; j < cantidadIngredientes; j++) {
                    System.out.println("Ingrese el ingrediente " + (j + 1));
                    System.out.print("Nombre del ingrediente: ");
                    String nombreIngrediente = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    double cantidadIngrediente = Double.parseDouble(scanner.nextLine());
                    System.out.print("Unidad de medida: ");
                    String unidadIngrediente = scanner.nextLine();

                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidadIngrediente, unidadIngrediente);
                    plato.agregarIngrediente(ingrediente);
                }
            }

            platosMenu.add(plato);
        }

        // Mostrar menú
        System.out.println("\nMenú del Restaurante:");
        for (Plato plato : platosMenu) {
            plato.mostrarPlato();
        }

        scanner.close();
    }
}

