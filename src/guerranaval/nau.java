package guerranaval;

class nau{

    private casella origen;
    private orientacio o;

    private int mida;

    public nau(int mida, casella origen, orientacio o) {
        this.origen = origen;
        this.o = o;
        this.mida = mida;
    }


    public int getMida() {
        return mida;
    }

    public void setMida(int mida) {
        this.mida = mida;
    }

    public casella getOrigen() {
        return origen;
    }

    public void setOrigen(casella origen) {
        this.origen = origen;
    }

    public orientacio getOrientacio() {
        return o;
    }

    public orientacio setOrientacio (orientacio o) {
        this.o = o;
    }
}