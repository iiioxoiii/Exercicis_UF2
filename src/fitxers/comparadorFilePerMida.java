package fitxers;
import java.io.File;


public class comparadorFilePerMida implements Comparable {

    public long t;
    public File f;


    public comparadorFilePerMida(File file) {
        f = file;
        t = file.length();
    }

    public int compareTo(Object o) {
        long u = ((comparadorFilePerMida) o).t;
        return t < u ? -1 : t == u ? 0 : 1;
    }

    //Implementació per retornar el nom del arxiu
    public String getNom(){
        return this.f.getName();
    }

    //Implementació per retornar el nom del arxiu
    public long getMida(){
        return t;
    }

}