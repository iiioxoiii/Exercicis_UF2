package dissenyModular;


/*5) Ens han demanat que fem una gestió molt simple de reserves d'un cinema.

El programa ha de complir els següents requisits:

1- S'ha d'iniciar amb un nombre total d'entrades lliures.
2- Ha d'anar preguntant el nombre d'entrades que volem reservar. En cada reserva ha
de comprovar si hi suficients localitats lliures. En cas afirmatiu, ha de calcular
el preu total de la reserva a raó de 6 euros l'entrada.
3- El programa ha d'acabar quan li demanem un nombre d'entrades que sobrepassa
l'aforament disponible. Quan això passi s'ha de mostrar el nombre total d'entrades
venudes per aquella sessió i la recaudació total que s'ha realitzat.
*/


import java.util.Scanner;

public class cinema {

    final static int AFORMAMENT = 100;
    final static int PREU = 6;

    static int entradesReservades = 0;

    public static void main(String[] args) {

        boolean sortir = false;

        while(!sortir) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Num reserves: ");

            int entrades = sc.nextInt();


            if (AFORMAMENT > (entradesReservades + entrades)) {
                reservar(entrades);
            } else {
                System.out.println("No hi ha suficients entrades");
                System.out.println("Entrades venudes: " + entradesReservades);
                System.out.println("Recaptació: " + entradesReservades * PREU + " €");
                sortir = true;
            }
        }
    }

    public static void reservar(int entrades){

        System.out.println("Has comprat "+ entrades + " entrades");
        System.out.println("Preu: " + (entrades*PREU)+"€");
        entradesReservades = entradesReservades + entrades;
    }

}
