package reglahont;

import java.util.Comparator;

/**
 * Comparador per ordenar objectes del tipus "partit"
 */
class comparadorResultats implements Comparator<partit> {

    public int compare(partit p1, partit p2) {
        int n;
        n = p1.getVots().compareTo(p2.getVots());
        if (n == 0) {
            n = p1.compareTo(p2);
        }
        return n;
    }
}
