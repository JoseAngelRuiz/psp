package es.cifpcarlos3;

import java.util.Scanner;

public class Repaso3 {
private static final double TASA_CONVERSION = 166.386;

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);


            System.out.println("Introduce la cantidad en pesetas (Ptas.):");


            double pesetas;

            if (scanner.hasNextDouble()) {
                pesetas = scanner.nextDouble();
            } else {
                System.out.println("Error: Por favor, introduce un valor numérico válido.");
                scanner.close();
                return; // Termina el programa si la entrada no es un número
            }


            double euros = pesetas / TASA_CONVERSION;


            System.out.printf("%.2f pesetas equivalen a %.2f euros.\n", pesetas, euros);


            scanner.close();
        }
    }


