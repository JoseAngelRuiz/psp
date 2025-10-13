package es.cifpcarlos3;


import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class proceso {
    public static void main(String[] args) {
        File archivo = null;
        RandomAccessFile raf = null;
        int cantidad;

        

        try {
            Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("[*ERROR*] El segundo argumento debe ser un número entero.");
            System.exit(-1);
        }

        String proceso = args[0];
        cantidad = Integer.parseInt(args[1]);
        archivo = new File(args[2]);

        if(!archivo.exists()){
            try {
                archivo.createNewFile();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        try {
            raf = new RandomAccessFile(archivo, "rw");
            int numero = 2;
            for(int i = 0; i < cantidad; i++){
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
