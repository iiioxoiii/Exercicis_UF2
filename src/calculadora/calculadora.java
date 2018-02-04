package calculadora;

import java.util.Scanner;

public class calculadora {


    /* Fes el disseny aplicant anàlisi top-down) i implementació dels següents problemes en
    més d'una Classe.

    1. Calculadora.
    Anem a definir el problema clàssic de la calculadora en més d'una classe.
    En una classe que definirem com a Calculadora, per tant el nom del fitxer s'ha
    de dir Calculadora.java, hi haurà un mètode main que contindrà un menú amb diferents
    opcions d'operacions: suma, resta, multiplicació, divisió i residu (mod).
    Tindrem una segona classe Operacions, per tant el nom del fitxer serà Operacions.java,
    que no contindrà cap main, sinó que contindrà els mètodes que necessita Calculadora per a
    realitzar les operacions. */


    public static void main(String[] args) {
        calculadora inici = new calculadora();
        inici.menu();
    }

    public static void menu(){

        boolean sortir = false;

        while (sortir != false) {

            operacions op = new operacions();

            pintaMenu();
            int opcio = preguntaOpcio();

            if (opcio == 1) {
                op.suma();
            } else if (opcio == 2) {
                op.resta();
            } else if (opcio == 3) {
                op.multiplicacio();
            } else if (opcio == 4) {
                op.divisio();
            } else if (opcio == 5) {
                op.residu();
            } else if (opcio == 6) {
                System.out.println("by");
                sortir = true;
            } else {
                System.out.println("Valor erroni.");
            }
        }
    }

    private static int preguntaOpcio() {
        System.out.println("Opcio:");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void pintaMenu() {
        System.out.println("Que vols fer?");
        System.out.println("1) Suma");
        System.out.println("2) Resta");
        System.out.println("3) Multiplicacio");
        System.out.println("4) Divisio");
        System.out.println("5) Residu");
        System.out.println("6) Sortir");
    }


}
