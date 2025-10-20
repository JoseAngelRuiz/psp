package es.cifpcarlos3;

import java.util.Scanner;


public class Repaso1 {
    public static void main(String[] args) {
        // 1. Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // 2. Pedir al usuario que ingrese su nombre
        System.out.println("Por favor, introduce tu nombre:");

        // 3. Leer la línea de texto que el usuario introduce
        String nombre = scanner.nextLine();

        // 4. Mostrar el saludo personalizado por pantalla
        System.out.println("Hola " + nombre);

        // 5. Cerrar el objeto Scanner para liberar recursos (buena práctica)
        scanner.close();
    }
}