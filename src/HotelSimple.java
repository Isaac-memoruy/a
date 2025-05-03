import java.util.Scanner;

public class HotelSimple {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int totalHabitaciones = 10;
        String[] clientes = new String[totalHabitaciones]; 
        boolean[] ocupadas = new boolean[totalHabitaciones]; 
        
        int opcion;
    
        
        do {
            System.out.println("\n--- SISTEMA DE HOTEL SIMPLE ---");
            System.out.println("1. Hacer reserva");
            System.out.println("2. Ver habitaciones");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = input.nextInt();
            input.nextLine(); 
            
            switch(opcion) {
                case 1:
                    
                    System.out.print("\nIngresa tu nombre: ");
                    String nombre = input.nextLine();
                    
                    System.out.println("Habitaciones disponibles:");
                    for(int i = 0; i < totalHabitaciones; i++) {
                        if(!ocupadas[i]) {
                            System.out.print((i+1) + " ");
                        }
                    }
                    
                    System.out.print("\nElige una habitación (1-" + totalHabitaciones + "): ");
                    int habitacion = input.nextInt() - 1; 
                    
                    if(habitacion < 0 || habitacion >= totalHabitaciones) {
                        System.out.println("Número de habitación inválido!");
                        break;
                    }
                    
                    if(ocupadas[habitacion]) {
                        System.out.println("Habitación ya ocupada!");
                    } else {
                        ocupadas[habitacion] = true;
                        clientes[habitacion] = nombre;
                        System.out.println("Reserva exitosa para " + nombre + " en habitación " + (habitacion+1));
                    }
                    break;
                    
                case 2:
                    
                    System.out.println("\nEstado de las habitaciones:");
                    for(int i = 0; i < totalHabitaciones; i++) {
                        String estado = ocupadas[i] ? "Ocupada por " + clientes[i] : "Disponible";
                        System.out.println("Habitación " + (i+1) + ": " + estado);
                    }
                    break;
                    
                case 3:
                    
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:
                    System.out.println("Opción no válida!");
            }
        } while(opcion != 3);
    
        input.close(); 
    }
}
