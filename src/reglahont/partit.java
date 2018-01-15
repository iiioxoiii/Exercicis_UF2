package reglahont;


/**
 * Tipus partit. És un tipus per declarar els noms i els vots.
 * Amb aquest tipus es pot confeccionar el llistat global de les eleccions.
 */
class partit implements Comparable<partit> {

    private String nom;
    private Integer vots;

    partit(String nom, Integer vots) {
        this.nom = nom;
        this.vots = vots;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVots(Integer vots) {
        this.vots = vots;
    }

    public String getNom() {
        return this.nom;
    }

    public Integer getVots() {
        return this.vots;
    }


    @Override
    public String toString() {
        return "partit{" +
                "nom='" + nom + '\'' +
                ", vots=" + vots +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        boolean r = false;
        if (o instanceof partit) {
            partit p = (partit) o;
            r = this.getNom().equals(p.getNom()) && this.getVots().equals(p.getVots());
        }
        return r;
    }

    public int compareTo(partit p) {
        int r;
        r = getNom().compareTo(p.getNom());
        if (r == 0) {
            r = getVots().compareTo(p.getVots());
        }
        return r;
    }

    public int hashCode() {
        return getNom().hashCode() + getVots().hashCode() * 31;
    }

}