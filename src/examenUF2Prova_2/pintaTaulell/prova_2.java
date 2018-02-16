package examenUF2Prova_2.pintaTaulell;

import java.util.Scanner;


public class prova_2 {

    /** 1) Recursivitat:
     * Realitza un programa que donat un nombre N, mostri els nombres
     * parells de forma ordenada ascendent fins a N (inclòs N).
     * Per exemple: Si en el programa introdueixo el 11 m'ha de mostrar
     * 2 4 6 8 10, de forma recursiva. (20%)
     *
     * La capçalera del programa pot ser: public static void escriuParellsN (int N)
     *
     *
     *
     * 2) Enfonsar la flota: (80%)
     * El joc “Enfonsar la flota” o Batalla naval és un clàssic joc infantil de llapis i paper,
     * del que s'han comercialitzat multitud de versions com a joc de taula.
     * Cada jugador col·loca, secretament, la seva flota de vaixells en un dels seus taulers,
     * que es manté ocult de l'adversari durant tota la partida. Cada vaixell de la flota ocupa
     * 3 cel·les, i han de col·locar-se en el tauler vertical o horitzontalment.
     *
     * Crear un programa per a gestionar el tauler d' un jugador el qual amb un menú es pugui triar les
     * següents opcions:
     *
     * - Crear un vaixell en el tauler.
     * - Visualitzar tauler amb els vaixells posats i les cel·les tocades.
     * - Llançar un míssil a una cel·la determinada:
     *
     *
     * El tauler serà fix i ha de ser de 5x5.
     *
     * L'usuari podrà triar la posició on es posa el vaixell i l’orientació (vertical o horitzontal).
     * Ex: posició (x=1, y =1), i orientació (horitzontal): el vaixell ocuparà les posicions (1,1),(1,2),(1,3).
     * Quan es llança un míssil es demanarà a l'usuari la posició de destinació.
     * Has de tenir dins un package una classe Visualitzacio.java que contingui les opcions de visualitzar
     * una partida.
     * Heu d'utilitzar el disseny i la programació modular per a resoldre el problema.
     * Es penalitzarà l'incompliment d’un bon disseny modular.
     * */



    /**Taulells
     *
     * El taulellA es el nostre taulell
     * El taulellB es el taulell de la màquina
     **/

    static int [][] taulellA = {{0,0,0,0,0},
                        {0,0,0,0,0},
                        {0,0,0,0,0},
                        {0,0,0,0,0},
                        {0,0,0,0,0}};

    static int [][] taulellB = {{1,1,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,0,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}};






    public static void main(String[] args) {
        //escriuParellsN(10);
        enfonsarLaFlota();
    }


    public static void enfonsarLaFlota(){
        insertaVaixells();
        jugaPartida();


    }


    public static void jugaPartida(){

        boolean finalPartida = false;
        int dianes = 0;


        while(!finalPartida){
            Scanner sc = new Scanner(System.in);
            System.out.println("Dispara:");
            System.out.println("fila:");
            int f = sc.nextInt();
            System.out.print("columna");
            int c = sc.nextInt();

            boolean resultat = disparo(f,c);

            if(resultat){
                dianes++;
            }

            //Pinta el taulell
            pintaTaulellA();

            //Instancia la classe pintaTaulell i
            //mostra veritat absoluta...
            pintaTaulell ops = new pintaTaulell();
            ops.getPensamentConfus();

            if(dianes==9){
                finalPartida=true;
                System.out.println("by");
            }
        }

    }


    public static void pintaTaulellA(){
        for (int i = 0; i < taulellA.length; i++) {
            for (int j = 0; j <taulellA[0].length ; j++) {
                System.out.println(taulellA[i][j] + " ");
            }
        }
    }



    public static boolean disparo(int fila, int columna){
        boolean disparo;

        if(taulellA[fila][columna] == 1){
            System.out.println("Encert! Bravo!");
            taulellA[fila][columna] = 2;
            disparo = true;
        }else{
            System.out.println("Aigua");
            disparo = false;
        }

        return disparo;
    }



    public static void insertaVaixells() {

        //1) Els vaixells ocupen 3 posicions
        //2) El valor de les entrades ha de d'estar dins els parametres perquè els valors
        //no se surtin de l'array. Els vaixells es posen a partir de les coordenades de baix a dalt i
        //d'esquerra a dreta.
        //3) No poden haver entrades al taulellA que es trepitjin perquè no hi ha control.
        //4) El programa agafa el valor de fila, coluna i orientacio, i marca com un valor enter
        // '1' el vaixell amb les 3 caselles consecutives en horitzontal o vertical.


        int numVaixells = 3;


        for (int i = 0; i <numVaixells ; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Inserta vaixell:");
            System.out.println("fila:");
            String fila = sc.nextLine();
            System.out.println("columna:");
            String columna = sc.nextLine();
            System.out.print("horitzontal <h> o vertical  <v>: ");
            String orientacio = sc.nextLine();

            posaVaixell(fila,columna,orientacio);
        }


    }

    public static void posaVaixell(String fila, String columna, String orientacio){

        int f = Integer.parseInt(fila);
        int c = Integer.parseInt(columna);

        if (orientacio.equals("h")){
            taulellA[f][c] = 1;
            taulellA[f][c+1] = 1;
            taulellA[f][c+2] =1;
        }else {
            // posicionament en vertical
            taulellA[f][c] = 1;
            taulellA[f+1][c] = 1;
            taulellA[f+2][c] =1;
        }
    }















    // L'he implementat de major a menor.
    public static int escriuParellsN (int n){

        if (n <= 0) {

        }else{
            if(n%2 == 0){
                System.out.println(n);
            }

            return escriuParellsN(n-1);

        }

        return 0;
    }


    // Joc de vaixells








}
