package org.cifp.carlos3;
import java.io.*;
import java.nio.file.*;

public class GestorFrase {
    public static void main(String[] args) {

        //Crear el File de los archivos de entrada

        File ficheroEntrada = new File("src/main/java/es/cifpcarlos3/frases.txt");

        if (!ficheroEntrada.exists()) {
            System.out.println(" El archivo frases.txt no existe en la ruta especificada.");
            return;
        }


        //Crear el directorio de salida ‘procesados’

        File carpetaProcesados = new File("src/main/java/es/cifpcarlos3/procesados");
        if (!carpetaProcesados.exists()) {
            carpetaProcesados.mkdir();

        }

        File ficheroSalida = new File(carpetaProcesados, "frases_filtradas.txt");


        //Abrir los flujos de lectura y escritura con try-with-resources

        try (
                BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada));
                BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida))
        ) {
            String linea;


            //Leer y procesar las líneas

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                // Dividir la línea en 3 partes: código | frase | autor
                String[] partes = linea.split("\\|");
                if (partes.length != 3) continue;

                String codigo = partes[0].trim();
                String frase = partes[1].trim();
                String autor = partes[2].trim();


                //Aplicar los filtros

                boolean cumpleCondicion = codigo.startsWith("2")
                        || autor.endsWith("Monroe")
                        || autor.endsWith("Davis");


                // Escribir en el nuevo fichero si cumple

                if (cumpleCondicion) {
                    bw.write("\"" + frase + "\" - " + autor);
                    bw.newLine();
                }
            }


            //Al salir del try, los flujos se cierran automáticamente

            System.out.println(" Archivo 'frases_filtradas.txt' creado en la carpeta 'procesados'.");

        } catch (IOException e) {
            System.out.println(" Error al procesar el archivo: " + e.getMessage());
        }


        //Eliminar el fichero original

        if (ficheroEntrada.exists()) {
            if (ficheroEntrada.delete()) {
                System.out.println("🗑️ Archivo original 'frases.txt' eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se pudo eliminar el archivo original.");
            }
        }
    }
}
