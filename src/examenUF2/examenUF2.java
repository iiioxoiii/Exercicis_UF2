package examenUF2;

import java.util.Arrays;
import java.util.Scanner;

public class examenUF2 {


    public static void main(String[] args) {

    }


    /**
     * Problema 1.
     * <p>
     * Escriu un mètode que rebi un string i un caràcter i calculi el número d'aparicions del caràcter dins de l'string.
     * Implementa el mètode de dues maneres diferents:
     * <p>
     * com una funció anomenada numCharFunction (que retorni el número d'ocurrències del caràcter)
     * com una acció anomenada numCharAction (que no retorni res i escrigui el número d'ocurrències per pantalla). (30%)
     **/


    public static int numCharFunction(String cadena, char c) {
        int n = 0;
        char[] array = cadena.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                n++;
            }
        }

        return n;

    }

    public static void numCharAction(String cadena, char c) {

        System.out.println("El número de coincidències es: " + numCharFunction(cadena, c));
    }


    /**
     * Problema 2.
     * En una mateixa classe escriu el següent codi emprant, almenys,
     * la funció especificada: (30%)
     * <p>
     * public static int[] fusioDosArrays(int[] a, int[] b)
     * <p>
     * Escriure un mètode que rebi dos vectors d'enters ordenats i retorni el vector
     * resultant que sigui la fusió dels dos vectors en un de sol, de forma que els
     * elements continuïn estan ordenats. Nota: NO es pot fer servir la funció sort().
     **/


    //Fent servir sort
    public static Integer[] fusioDosArrays(Integer[] a, Integer[] b) {

        //Es crea un array de sortida de mida de la suma del dos arrays
        Integer[] temporal = new Integer[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            temporal[i] = a[i];
            temporal[i + b.length] = b[i];
        }

        Arrays.sort(temporal);


        return temporal;
    }

}


/** Problema 3. Realitza una classe que contingui una calculadora.
 * Desenvolupa el disseny modular i implementa'l d'acord amb els requisits següents: (40%)
 * - Ha de permetre realitzar les operacions de +, -, *, /.
 * - Ha de permetre utilitzar nombres decimals i binaris.
 * NOTA: L'ideal en totes tres activitats és que en el main només hi hagi crides a funcions que heu desenvolupat.
 **/


class calculadora {

    public static void main(String[] args) {
        menu();
        control();
    }


    public static void menu(){
        System.out.println("Quina operació vols fer?:");
        System.out.println("1) Suma");
        System.out.println("2) Resta");
        System.out.println("3) Multiplicacio");
        System.out.println("4) Divisió");
        System.out.println("5) <sortir>");
    }




    public static void control(){

        boolean sortir = false;
        int opcio = opcio();

        while (sortir!=true){
            if(opcio==1){
                System.out.println(suma());
            }else if (opcio == 2){
                System.out.println(resta());
            }else if (opcio == 3){
                System.out.println(multiplica());
            }else if (opcio == 4) {
                System.out.println(divideix());
            }else if (opcio == 5){
                sortir = true;
            }else {
                System.out.println("error opció");
            }
        }

        System.out.println("bye");
    }


    public static double preguntaValorA() {
        System.out.println("Entra el primer valor:");
        return valor();
    }

    public static double preguntaValorB() {
        System.out.println("Entra el segon valor: ");
        return valor();
    }

    public static int opcio(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        return num;
    }

    public static double valor(){
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        return num;
    }


    public static double multiplica() {
        double a = preguntaValorA();
        double b = preguntaValorB();
        return a * b;
    }

    public static double suma() {
        double a = preguntaValorA();
        double b = preguntaValorB();
        return a + b;
    }

    public static double resta() {
        double a = preguntaValorA();
        double b = preguntaValorB();
        return a - b;
    }

    public static double divideix() {
        double a = preguntaValorA();
        double b = preguntaValorB();
        return a / b;
    }



}