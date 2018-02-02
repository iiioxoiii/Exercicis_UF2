package guerranaval;

class casella {

    private ubicacio u;
    private estat e;


    casella(ubicacio u, estat e) {
        this.u = u;
        this.e = e;
    }

    public ubicacio getUbicacio() {
        return u;
    }

    public void setUbicacio(ubicacio u) {
        this.u = u;
    }

    public estat getEstat() {
        return e;
    }

    public void setEstat(estat e) {
        this.e = e;
    }
}

