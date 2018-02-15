package recursibilitat;



public class recursibilitat {

    public static void main(String[] args) {

        //System.out.println(NoSeQueFa(4,2));
        //System.out.println(suma(10));
        //mostraNaturalsInvers(10);

        //FUCK!!
        System.out.println(mostraNaturals(10));

        //System.out.println(divisioPerRestes(10,2));
    }


    /**
     * 1. Implementa el següent programa recursiu amb Java i quan endevinis el que fa,
     * fes l'equivalent de forma seqüencial (utilitzant un bucle):
     * Funcio NoSeQueFa (enter a, entr b): enter
     * Si (b>0) llavors retorna 0
     * Sino retorna a + NoSeQueFa(a,b-1)
     * Fi Funció
     *
     * MUltiplica!!!!
     *
     **/

    public static int NoSeQueFa(int a, int b) {
        if (b == 0) {
            return 0;
        } else {
            return a + NoSeQueFa(a, b-1);
        }
    }



    /**
     * 2. Fes un programa que escrigui la suma dels N primers nombres:
     * Ex: N=5 5+4+3+2+1+0=15
     * suma(N) = N + suma(N-1);
     **/

    public static int suma(int n) {

        //System.out.println(n);
        if( n == 0 ){
            return n;
        }else {
            return n + suma(n - 1);
        }

    }



    /**
     * 3. Escriu un programa que visualitzi els N primers nombres naturals:
     * Donat un N que mostri-> 1 2 3 4 5 ... N
     **/

    public static int mostraNaturals(int n) {
        if (n >= 0) {
            return mostraNaturals((n-n)+1);
        } else {
            return 0;
        }
    }



    /**4. Escriu un programa que visualitzi els N primers nombres naturals en sentit invers:
     * Donat un N que mostri-> N N-1 ... 3 2 1
     **/

    public static int mostraNaturalsInvers(int n) {
        System.out.println(n);
        if (n <= 0) {
            return 0;
        }else{
            return mostraNaturalsInvers(n - 1);
        }
    }

    /**
     * 5. Programa un algorisme recursiu capaç de sumar les xifres d'un nombre.
     **/

    public static int sumaXifra(int n) {
        if (n == 0) {

        } else {
            n = sumaXifra(n + (n - 1));
        }
        return n;
    }


    /**
     * 6. Calcula el nombre de fibonnacci a partir d'un nombre donat.
     * (Sèrie de Fibonnacci)
     **/

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }


    /** 7. Programa un algorisme recursiu capaç d'invertir un nombre.
     * Ex: donat el 123 volem
     * aconseguir el 321.
     */

    //public static int inverteix(int n){

    //}






/** 8. Implementa un programa que permeti realitzar la divisió per restes successives.
 */

public static int divisioPerRestes(int a, int b){

    if( (a-b) <= 0 ){
        return 0;
    }else{

        return divisioPerRestes((a-b), b);

        }
    }

}

 /** 9. Programa un algorsime recursiu capaç de sumar els nombre d'un vector.
 * Darrera modificació: Monday, 1 January 2018, 21:24
 **/
