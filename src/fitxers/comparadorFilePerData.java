package fitxers;
import java.io.File;


public class comparadorFilePerData implements Comparable {

    public long t;
    public File f;


    public comparadorFilePerData(File file) {
        f = file;
        t = file.lastModified();
    }

    public int compareTo(Object o) {
        long u = ((comparadorFilePerData) o).t;
        return t < u ? -1 : t == u ? 0 : 1;
    }

    //Implementació per retornar el nom del arxiu
    public String getNom(){
        return this.f.getName();
    }
}