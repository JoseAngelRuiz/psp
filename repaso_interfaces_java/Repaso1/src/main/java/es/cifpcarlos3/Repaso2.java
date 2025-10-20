package es.cifpcarlos3;

import java.util.Scanner;

public class Repaso2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        if (!sc.hasNextInt()) {
            System.out.println("Entrada no válida.");
            sc.close();
            return;
        }
        int n = sc.nextInt();
        System.out.println(n % 2 == 0 ? "El número es par." : "El número es impar.");
        sc.close();
    }
}