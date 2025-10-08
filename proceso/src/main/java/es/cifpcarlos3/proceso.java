package es.cifpcarlos3;


import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class proceso {
    public static void main(String[] args) {
        File f = null;
        RandomAccessFile raf = null;
        int cantidadNumeros;

        if(args.length != 3) {
            System.err.println("[*ERROR*] Uso correcto: java -jar xxxx.jar <nombre_proceso> <cantidad_numeros> <fichero>");
            System.exit(-1);
        }

        try {
            Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("[*ERROR*] El segundo argumento debe ser un número entero.");
            System.exit(-1);
        }

        String proceso = args[0];
        cantidadNumeros = Integer.parseInt(args[1]);
        f = new File(args[2]);

        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        try {
            raf = new RandomAccessFile(f, "rw");
            int numero = 2;
            for(int i = 0; i < cantidadNumeros; i++){
                try{
                    FileLock bloqueo = raf.getChannel().lock();
                    raf.seek(raf.length());
                    raf.writeBytes(proceso+"\n");
                    raf.writeBytes(numero + "\n");
                    bloqueo.release();
                } catch (Exception e) {
                    System.err.println(e);
                }
                numero += 2;
            }
            raf.close();
        } catch (Exception e){
            System.err.println(e);
        }
    }
}