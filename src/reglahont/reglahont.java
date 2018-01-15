package reglahont;

/**
 * _____ _     _____ ____ ____ ___ ___  _   _ ____
 *| ____| |   | ____/ ___/ ___|_ _/ _ \| \ | / ___|
 *|  _| | |   |  _|| |  | |    | | | | |  \| \___ \
 *| |___| |___| |__| |__| |___ | | |_| | |\  |___) |
 *|_____|_____|_____\____\____|___\___/|_| \_|____/
 *
 * Simulador sobre la llei d'Hondt en unes hipotètiques eleccions electorals.
 *
 * Característiques a complir (en un hipotètic país):
 *
 * 1) Entra per teclat el nom dels partits , el nombre de vots obtinguts i el tamany en nombre d'escons del parlament.
 * 2) Sel·lecciona aquells partits que tenen dret a obtenir representació al parlament.
 * 3) Assigna el nombre d'escons segons l'esmentada llei d'Hondt en cada partit.
 * 4) Permet fer algun canvi en el nombre de vots d'un partit i visualitza tot seguit els canvis produïts en
 * l'assignació d'escons.
 * 5) Donats uns partits decidir si permet o no formar equip de govern (per formar equip de govern es necessita la meitat
 * d'escons + 1).
 *
 *----------------------------------------------
 * La simulació es fa amb el disseny de tipus
 *
 * >objecte partit: objecte amb les característiques del partit: el nom i el número de vots.
 *
 * >objecte grup: objecte amb dades derivades dels càlculs: nom i número escons assigats.
 *
 * >objecte comparadorResultats: comparador per ordenar els objectes "partit" per número de vots.
 *
 * >objecte eleccions : un objecte amb tots els atributs de les eleccions (num partits, vots en blanc,
 * vots nuls, etc) i métodes per fer els càlculs de les eleccions.
 *
 * **/


public class reglahont {

    public static void main(String[] args) {

        eleccions generals2017 = new eleccions();

        generals2017.preguntesBasiques();
        generals2017.calculEscons();
        generals2017.canviVotsPartit();
        generals2017.calculEscons();
        generals2017.calculGovern();

    }

}













