package dissenyModular;
import java.util.Scanner;

/* 4) Als Estats Units és molt popular un joc de daus amb apostes: un jugador llença
simultàniament dos daus i suma la puntuació obtinguda entre ells, el valor resultant
de la suma és la puntuació obtinguda en el llançament.

Regles del joc.

- La puntuació obtinguda en el primer llançament s’anomena punt, que es memoritza.
- Si el punt és 7 o 11 es guanya i s'acaba la partida.
- Si el el punt és 2, 3 o 12 es perd i s'acaba la partida.

Pels altres valors del punt es seguix llançant els daus fins que es treu de nou el punt
obtingut al primer llançament, llavors es guanya i s'acaba la partida, o es treu un 7,
llavors es perd i s'acaba la partida.

        Exemples de partides:

        Partida a: 7 (és el punt) Es guanya

        Partida b: 11 (és el punt) Es guanya

        Partida c: 2 (és el punt) Es perd

        Partida d: 3 (és el punt) Es perd

        Partida e: 12 (és el punt) Es perd

        Partida d: 8 (és el punt), Es torna a tirar
                   9    Es torna a tirar
                   6    Es torna a tirar
                   5    Es torna a tirar
                   8    Es guanya!

        Partida c: 8 (és el punt), Es torna a tirar
                   9 Es torna a tirar
                   6 Es torna a tirar
                   5 Es torna a tirar
                   7 Es perd!


        -Dissenyar i implementar una aplicació emprant la metodologia de disseny descendent
        (top-down) i el paradigma de la programació estructurada i modular que permeti:

        -Jugar una partida: l'usuari llença els daus apretant la tecla espai i l'aplicació
        va informant del resultat i dels següents passos.

        -Determinar l'equitat del joc: l'aplicació juga automàticament el nombre de partides
        que li entra l'usuari per teclat, comptant el nombre de partides guanyades i perdudes
        i calculant la probabilitat de guanyar en %. La única diferència amb la partida
        interactiva (opció anterior) és que l'usuari no ha d'apretar l'espai per llançar els daus,
        la resta de missatges per pantalla són els mateixos.

        -Obtenir ajuda en línia.

        -Sortir de l'aplicació.

*/


public class daus {

    public static void main(String[] args) {
        joc();
    }

    public static void joc(){
        boolean theEnd= false;
        banner();
        while (!theEnd){
            menu();
            int opcio = preguntaOpcio();
            if(opcio==3) {
                sortir();
                theEnd = true;
            }else if (opcio ==4){
                partidaDesatesa();
            }else if(opcio == 1 || opcio ==2){
                executa(opcio);
            }else{
                System.out.println("Opció incorrecta");
            }
        }
    }

    public static void partidaDesatesa(){
        System.out.println("Entra les partides:");
        Scanner sc = new Scanner(System.in);
        int numPartides = sc.nextInt();

        int guanyades = 0;
        int perdudes = 0;

        for (int i = 0; i < numPartides; i++) {
            if(partidaSenseScanner()==1){
                guanyades++;
            }else{
                perdudes++;
            }
        }

        estadistica(guanyades,perdudes);


    }


    public static void estadistica (int guanyades, int perdudes){
        System.out.println("La estadística de "+ (guanyades+perdudes) + "partides: ");
        System.out.println("Partides guanyades: " + (100*guanyades/(guanyades+perdudes)) +"%");
        System.out.println("Partides perdudes: " + (100*perdudes/(guanyades+perdudes)) +"%");
        System.out.println();
    }


    public static int  partidaSenseScanner() {

        int resultat = 0;

        int punt = dau() + dau();

        System.out.println(punt);

        boolean end = false;

        if (punt == 7 || punt == 11)

        {
            System.out.println("Has guanyat");
            resultat = 1;

        } else if (punt == 2 || punt == 3 || punt == 12) {
            System.out.println("Has perdut");
            resultat = 0;

        } else {

            while (!end) {
                int novaTirada = dau() + dau();
                System.out.println(novaTirada);
                if (novaTirada == 7) {
                    System.out.println("Has perdut!");
                    end = true;
                    resultat = 0;
                } else if (novaTirada == punt) {
                    System.out.println("Has guanyat!");
                    end = true;
                    resultat = 1;
                } else {
                    System.out.print("Torna a tirar.");
                }
            }
        }

        return resultat;
    }






    public static int preguntaOpcio() {
        System.out.println("escriu opció: ");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        return op;
    }

    public static void executa (int op){
        switch (op) {
            case 1:
                partida();
                break;
            case 2:
                ajuda();
                break;
        }
    }

    public static void banner(){
        System.out.println("***********************");
        System.out.println("*******PARTIDA*********");
        System.out.println("***********************");
    }

    public static void menu() {

        System.out.println("1) jugar");
        System.out.println("2) ajuda");
        System.out.println("4) partida iteractiva");
        System.out.println("3) sortir");
    }

    public static void ajuda(){

        System.out.println("Regles del joc.\n" + "\n" +
        "- La puntuació obtinguda en el primer llançament s’anomena punt, que es memoritza.\n" +
        "- Si el punt és 7 o 11 es guanya i s'acaba la partida.\n" +
        "- Si el el punt és 2, 3 o 12 es perd i s'acaba la partida.\n" + "\n" +
        "Pels altres valors del punt es seguix llançant els daus fins que es treu de nou el punt\n" +
        "obtingut al primer llançament, llavors es guanya i s'acaba la partida, o es treu un 7,\n" +
        "llavors es perd i s'acaba la partida.");

        }

    public static void sortir(){


        System.out.println("bye");
    }

    public static void partida() {

        int punt = tirada();

        System.out.println(punt);

        boolean end = false;

        if (punt == 7 || punt == 11)

        {
            System.out.println("Has guanyat");

        } else if (punt == 2 || punt == 3 || punt == 12)

        {
            System.out.println("Has perdut");

        } else

        {

            while (!end) {
                int novaTirada = tirada();
                System.out.println(novaTirada);
                if (novaTirada == 7) {
                    System.out.println("Has perdut!");
                    end = true;
                } else if (novaTirada == punt) {
                    System.out.println("Has guanyat!");
                    end = true;
                } else {
                    System.out.print("Torna a tirar.");
                }
            }
        }

    }

    public static int tirada(){
        System.out.println("Tira daus!");
        System.out.print("Press return to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int numero = dau()+ dau();
        return numero;
    }

    public static int dau(){

        return (int) (Math.random() * (6 - 1)) + 1;
    }

}


