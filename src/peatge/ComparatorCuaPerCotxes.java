package peatge;

import java.util.Comparator;

public class ComparatorCuaPerCotxes implements Comparator <cua> {


    public int compare(cua a, cua b){
        Integer r;

        r = a.getOcupacio().compareTo(b.getOcupacio());
        if( r == 0){
            r= a.compareTo(b);
        }

        return r;
    }
}