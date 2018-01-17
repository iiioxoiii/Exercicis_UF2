package guerranaval;

class casella {

    private nomCasella nom;
    private coordenada xy;


    casella(coordenada xy){
        this.xy = xy;
    }

    public nomCasella getNom() {
        return this.nom;
    }

    public void setNom(nomCasella nom) {
        this.nom = nom;
    }

    public coordenada getCoordenada(){
        return this.xy;
    }

    public void setCoordenada(coordenada xy) {
        this.xy=xy;
    }
}

