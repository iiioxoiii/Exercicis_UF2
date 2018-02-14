package matricula;

import java.util.Comparator;

public class ComparatorEstudiantPerEdat implements Comparator<estudiant> {

    public int compare (estudiant a, estudiant b){
        int r;

        r = a.getNaixement().compareTo(b.getNaixement());
        if( r == 0){
            r = a.compareTo(b);
        }

        return r;
    }
}
