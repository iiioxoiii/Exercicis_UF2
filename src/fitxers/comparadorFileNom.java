package fitxers;
import java.io.File;


public class comparadorFileNom implements Comparable {

    public String n;
    public File f;


    public comparadorFileNom(File file) {
        f = file;
        n = file.getName();
    }

    public int compareTo(Object o) {

        String u = ((comparadorFileNom) o).n;
        return n.compareTo(u);
    }

    //Implementació per retornar el nom del arxiu
    public String getNom(){
        return this.f.getName();
    }

}