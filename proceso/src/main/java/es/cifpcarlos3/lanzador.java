package es.cifpcarlos3;

import java.io.IOException;
import java.util.ArrayList;

public class lanzador {
    public static void main(String[] args) {
        Process nuevoProceso;
        for (int i = 0; i < 10; i++) {
            try {
                nuevoProceso = Runtime.getRuntime().exec("java -jar "
                        + "proceso-1.0-SNAPSHOT.jar " + "proceso" + i + " 10 " + "numeros.txt");
                System.out.println("java -jar "
                        + "proceso-1.0-SNAPSHOT.jar " + "proceso" + i + " 5 " + "numeros.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
