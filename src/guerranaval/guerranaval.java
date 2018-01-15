/** package guerranaval;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class guerranaval {

    public static void main(String[] args) {

    }

}





class partida{

    taulell a= new taulell();
    taulell b= new taulell();

}



class taulell{

    private Map <casilla, element>;
    private int n;


    public taulell (int n){
        this.n = n;
        crea();
    }

    public void crea(){

        ArrayList[][] table = new ArrayList[this.n][this.n];

        table[0][0] = new ArrayList(); // add another ArrayList object to [0,0]
        table[0][0].add(); // add object to that ArrayList

        Map<Integer, String> map = new HashMap<Integer, String>();

    }


}


enum element{
    NAVE,MAR,
}





class nau{

    private casilla origen;
    private orientacio o;
    private casilla [] mida;

    public nau(int mida, casilla origen, orientacio o, casilla [] mida) {
        this.origen = origen;
        this.o = o;
        this.mida=mida;
    }


    public int getMida() {
        return mida;
    }

    public void setMida(int mida) {
        this.mida = mida;
    }

    public guerranaval.casilla getOrigen() {
        return origen;
    }

    public void setOrigen(guerranaval.casilla origen) {
        this.origen = origen;
    }

    public orientacio getXy() {
        return xy;
    }

    public void setXy(orientacio xy) {
        this.xy = xy;
    }
}



enum orientacio {
    VERTICAL,HORITZONTAL
}



class casilla {

    private String nom;
    private coordenada;

    private

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}




class coordenada{

    private int x;
    private int y;

    public coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}


 **/