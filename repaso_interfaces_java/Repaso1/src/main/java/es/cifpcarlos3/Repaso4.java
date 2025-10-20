package es.cifpcarlos3;

import java.util.Scanner;

public class Repaso4 {
    // Constante para la relación de alumnos por ordenador
    private static final int alumnos_ordenador = 2;


    public static int calcularOrdenadores(int alumnos) {
        // La fórmula de redondeo hacia arriba es (int) Math.ceil((double) alumnos / ALUMNOS_POR_ORDENADOR)


        return (int) Math.ceil((double) alumnos / alumnos_ordenador);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalOrdenadores = 0;
        int[] alumnosPorAula = new int[3];
        int[] ordenadoresPorAula = new int[3];

        System.out.println("Indica el número de alumnos por aula:");

        // 1. Pedir y leer el número de alumnos para cada aula
        for (int i = 0; i < 3; i++) {
            System.out.print("Aula " + (i + 1) + ": ");
            alumnosPorAula[i] = scanner.nextInt();
        }

        // 2. Calcular los ordenadores necesarios para cada aula y el total
        for (int i = 0; i < 3; i++) {
            int alumnos = alumnosPorAula[i];

            // Llama a la función de cálculo con redondeo
            int ordenadores = calcularOrdenadores(alumnos);

            ordenadoresPorAula[i] = ordenadores;
            totalOrdenadores += ordenadores;
        }

        // 3. Mostrar los valores de salida
        System.out.println("\nResultado");
        for (int i = 0; i < 3; i++) {
            System.out.println("Aula " + (i + 1) + ": " + ordenadoresPorAula[i] + " ordenadores");
        }

        System.out.println("Total: " + totalOrdenadores + " ordenadores");

        scanner.close();
    }
}
