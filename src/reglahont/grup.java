package reglahont;

/**
 * Típus grup.
 * El tipus grup es un tipus derivat per emmagatzemar nom de partit i escons assignats
 * i per fer un llistat amb resultats
 */
class grup {

    private String nom;
    private int escons;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEscons() {
        return escons;
    }

    public void setEscons(int escons) {
        this.escons = escons;
    }

    @Override
    public String toString() {
        return "grup{" +
                "nom='" + nom + '\'' +
                ", escons=" + escons +
                '}';
    }

}
