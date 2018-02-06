package peatge;

public class cua {

    String nomCua;
    Integer maxOcupacio;
    Integer minOcupacio;
    Integer ocupacio;

    public cua(String nomCua, int maxOcupacio) {
        this.nomCua = nomCua;
        this.maxOcupacio = maxOcupacio;
        this.minOcupacio = 0;
        this.ocupacio = 0;
    }


    public boolean cuaDisponible(){
        if(this.ocupacio < this.getMaxOcupacio()){
            return true;
        }else{
            System.out.println("Cua "+ this.getNomCua() + " PLENA!");
            return false;
        }
    }



    public boolean afegeixCotxe(){

        if(this.ocupacio < this.maxOcupacio){
            this.ocupacio = this.ocupacio+1;
            return true;
        }else{
            return false;
        }

    }





    public boolean treuCotxe(){
        boolean tret = false;

        if (this.ocupacio >= 1 ){
            this.ocupacio = this.ocupacio-1;

            return true;

        }else{
            return false;
        }

    }


    public String getNomCua() {
        return nomCua;
    }

    public void setNomCua(String nomCua) {
        this.nomCua = nomCua;
    }

    public Integer getMaxOcupacio() {
        return maxOcupacio;
    }

    public void setMaxOcupacio(int maxOcupacio) {
        this.maxOcupacio = maxOcupacio;
    }

    public Integer getMinOcupacio() {
        return minOcupacio;
    }

    public void setMinOcupacio(int minOcupacio) {
        this.minOcupacio = minOcupacio;
    }

    public Integer getOcupacio() {
        return ocupacio;
    }

    public void setOcupacio(int ocupacio) {
        this.ocupacio = ocupacio;
    }



    // Són dos estudiants iguals aquells que tenen:
    // nom i dni iguals
    public boolean equals(Object o){
        boolean r = false;

        if(o instanceof cua){
            cua e = (cua) o;
            r = this.getNomCua().equals(e.getNomCua());
        }
        return r;
    }



    //El compareTo amb els mateixos elements que el equals
    //nom i dni
    public int compareTo(cua e){
        int r;
        r = getNomCua().compareTo(e.getNomCua());
        if (r==0){
            r = getOcupacio().compareTo(e.getOcupacio());
        }

        return r;
    }


    public String toString(){
        String ss;
        ss = "["+"Nom: "+ getNomCua()+ " Ocupacio:"+ getOcupacio() + " MaxOcup:" + getMaxOcupacio() + " ,MinOcup:" + getMinOcupacio()+"]";

        return ss;
    }


}
