package dissenyModular;

public class forecast {

    private String [] parametres;

    public forecast(){
    }

    public forecast(String[] parametres) {
        this.parametres = parametres;
    }



    public void pintaInfo(){
        System.out.println("Dades climatològiques de la ciutat de " + this.parametres[0]);
        System.out.println("Temperatura: " + this.parametres[1]);
        System.out.println("Humitat Relativa: " + this.parametres[2]);
        System.out.println("Pressió Atmosfèrica: " + this.parametres[3]);
        System.out.println("Velocitat Vent: " + this.parametres[4]);
        System.out.println("Direcció Vent: " + this.parametres[5]);
        System.out.println("Estat general: " + this.parametres[6]);
    }

    public void setParametres(String ciutat, String temp, String hr, String press, String vel, String direccio, String estat) {
        this.parametres[0] = ciutat;
        this.parametres[1] = temp;
        this.parametres[2] = hr;
        this.parametres[3] = press;
        this.parametres[4] = vel;
        this.parametres[5] = direccio;
        this.parametres[6] = estat;
    }
}