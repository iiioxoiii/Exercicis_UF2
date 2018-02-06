/*3. Gestió de peatge. Mitjançant un petit programa ens han demanat que portem la gestió
d'un peatge.

El peatge està compost per 4 cues diferents per on poden passar els cotxes, es tracta de
portar el control numèric d'aquestes cues. Un cotxe quan arriba a un peatge escull per
defecte la cua que va menys carregada, en cas d'empat escull en ordre incremental
de la primera a la quarta. El valor màxim d'una cua és 5.

El programa principal, situat a Peatge.java, tindrà un menú que permet:

-visualitzar l'estat de cada cua amb els cotxes que hi ha.
-donar l'avís de l'arribada d'un nou cotxe
-donar l'avís de la sortida d'un cotxe d'una de les cues (indicant la cua).

-També disposem d'una altra classe Cua.java que conté una variable de classe per a cada cua i
que contindrà el nombre de cotxes en aquella cua. A part, contindrà els mètodes per saber quants
cotxes hi ha en una cua, incrementar el valor de la cua, decrementar el valor de la cua, preguntar
si una cua està plena i preguntar si una cua està buida.

Pista: vigilar amb els màxims i mínims.
*/

package peatge;
import java.util.Scanner;

public class peatge {


    public static cua [] peatge;



    public static void main(String [] args ){
        peatge peatge = new peatge();

        peatge.muntaCues();
        peatge.menu();

    }



    public void menu(){

        boolean sortir = false;

        while(sortir != true){
            System.out.println("MENU");
            System.out.println("1) Veure cues");
            System.out.println("2) Entrada cotxe");
            System.out.println("3) Sortida cotxe");
            System.out.println("4) Sortir");

            Scanner sc = new Scanner(System.in);
            int opcio = sc.nextInt();

            if(opcio == 1){

                ocupacioCues();

            }else if (opcio == 2){

                entraCotxe();

            }else if (opcio == 3){

                surtCotxe();

            }else if (opcio == 4){
                sortir = true;

            }else{
                System.out.println("error opcio!");
            }
        }

    }



    public static void surtCotxe(){

        boolean sortit = false;

        for (cua cc:peatge) {
            if((cc.minOcupacio <= cc.ocupacio)
                    && (cc.equals(cuaMesOcupada()))
                    && (sortit == false)){

                cc.treuCotxe();
                sortit = true;

                System.out.println("Cotxe fora!");
            }
        }



    }


    public static cua cuaMesOcupada(){
        cua cuaMax = peatge[0];

        for (cua cc : peatge){
            if (cc.getOcupacio() >= cuaMax.getOcupacio()){
                cuaMax = cc;
            }
        }

        return cuaMax;
    }






    public static cua cuaMenysOcupada(){
        cua cuaMinima = peatge[0];

        for (cua cc : peatge){
            if (cc.getOcupacio() <= cuaMinima.getOcupacio()){
                cuaMinima = cc;
            }
        }

        return cuaMinima;
    }




    public static void entraCotxe(){

        boolean afegit = false;

        for (cua cc:peatge) {
            if((cc.cuaDisponible() == !afegit)
                    && (cc.equals(cuaMenysOcupada()))){

                cc.afegeixCotxe();
                afegit = true;

                System.out.println("Cotxe afegit!");
            }
        }

    }



    public static void ocupacioCues(){
        for (cua cc: peatge) {
            System.out.println(cc.toString());
        }
    }




    public void muntaCues(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quants carrils vols habilitar? ");
        int carrils = sc.nextInt();
        peatge = new cua[carrils];

        for (int i = 0; i < carrils ; i++) {
            System.out.println("Cua num " + i);
            String nom = String.valueOf(i);
            System.out.println("Màxim de cotxes a la cua?");
            int max = sc.nextInt();

            cua c = new cua(nom,max);
            peatge[i]=c;
        }
    }

}


