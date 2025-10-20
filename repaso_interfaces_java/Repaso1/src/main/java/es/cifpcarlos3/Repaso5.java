
package es.cifpcarlos3;

        import java.util.Scanner;

        public class Repaso5 {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Introduce un valor (puede ser un número o una cadena de texto):");
                String entrada = scanner.nextLine();

                if (esNumero(entrada)) {
                    System.out.println("El valor introducido es un NÚMERO.");
                } else {
                    System.out.println("El valor introducido es una CADENA DE CARACTERES.");
                }

                scanner.close();
            }

            public static boolean esNumero(String str) {
                if (str == null || str.isEmpty()) {
                    return false;
                }

                try {
                    Double.parseDouble(str);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }