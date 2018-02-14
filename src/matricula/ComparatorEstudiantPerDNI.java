package matricula;

import java.util.Comparator;

public class ComparatorEstudiantPerDNI implements Comparator<estudiant> {

    public int compare (estudiant a, estudiant b){
        int r;

        r = a.getDni().compareTo(b.getDni());
        if( r == 0){
            r = a.compareTo(b);
        }

        return r;
    }
}
