package submari;

/*
* 5. El fitxer Submari.java implementa el joc anomenat La Caça del Submarí.
*
* Analitza el codi i fes el següent:
*
* - Explica com funciona el joc, i per tant el programa.
* - Escriu els comentaris javadoc de tots els mètodes, descrivint la seva funcionalitat i
* el significat dels seus arguments i resultats.
* - Modifica el codi de manera que quan no s'encerti el submarí es doni una pista d'on està situat.
*
* La pista s'ha de donar abans de moure el submarí:
*
* Si el tret no destrueix el submarí  però  cau en algun dels punts situats just a l'entorn de la
* posicióó del submarí, s'informarà  sobre la proximitat de l'impacte donant les dues coordenades de
* posicióó del submarí.. Si la càrega no destrueix el submarí ni cau en algun dels punts situats
* just a l'entorn de la posició del submarí, el sònar informarà  del fet tot mostrant a l'usuari
* el valor de la coordenada x del submarí..
* */



/*  Primer un menu
* En cas de jugar partida se'ns demana la dimensió de la graella i el número de càrregues.
* Se situa el submarí en una coordenada aleatòria.
*
 */

import java.util.Scanner;

public class submari {

    /**
     * Menú principal.
     * @param args No emprat
     */
    public static void main(String args[]) {
        boolean continuar = true;
        Scanner teclat = new Scanner(System.in);

        while (continuar) {
            System.out.print("\n\nLA CAÇA DEL SUBMARÍ\n\n");
            System.out.print("Menú principal\n\n");
            System.out.print("  1 Jugar una partida\n  2 Ajuda\n  0 Sortir\n");
            System.out.print("\nOpció (1, 2, 0) ? ");
            int op = teclat.nextInt();
            switch (op) {
                case 1:
                    System.out.print("\nDimensió del mar ? ");
                    int dm = teclat.nextInt();
                    System.out.print("Nombre de càrregues de profunditat ? ");
                    int nc = teclat.nextInt();
                    jugarPartida(dm, nc);
                    break;
                case 2:
                    mostrarAjuda();
                    break;
                default:
                    System.out.print("Fi del joc\n\n");
                    continuar = false;
            }
        }
        teclat.close();
    }

    /**
     * @param dm dimensió del mar
     * @param nc càrreges de profunditat
     */
    private static void jugarPartida(int dm, int nc) {
        boolean esfonsat = false;
        int cc = nc;
        int[] ps = situarSubmari(dm);
        while (cc != 0 && !esfonsat) {
            int[] pc = situarCarrega(nc, cc);
            esfonsat = escoltarSonar(ps, pc);
            if (!esfonsat) {
                ps = moureSubmari(dm, ps);
            }
            cc--;
        }
        if (cc == 0) {
            System.out.print("\nCàrregues esgotades!\nFi de la partida\n");
        }
    }

    /**
     * Mostra l'ajuda de l'aplicació
     */
    private static void mostrarAjuda() {

        System.out.print("\nNo implementada\n");
    }

    /**A partir d'un enter amb les dimensions del taulell retorna una coordenada
     * @param dm dimensions del mar
     * @return array amb una coordenada (dos enters)
     */
    private static int[] situarSubmari(int dm) {
        int x = (int) (dm * Math.random());
        int y = (int) (dm * Math.random());
        int[] ps = {x, y};
        return ps;
    }

    /**Pregunta la situació de càrrega x i y.
     * @param nc número de càrregues
     * @param cc càrrega
     * @return una coordenada de dos enters (x i y)
     */
    private static int[] situarCarrega(int nc, int cc) {
        Scanner teclat = new Scanner(System.in);
        System.out.printf("\nCarrega %d de %d\n", cc, nc);
        System.out.print("Coordenada x de la càrrega ? ");
        int x = teclat.nextInt();
        System.out.print("Coordenada y de la càrrega ? ");
        int y = teclat.nextInt();
        int[] pc = {x, y};
        return pc;
    }

    /**Metode que procesa la colocació de les càrreges amb la situació del submarí
     * @param ps situació del submarí
     * @param pc situació de les càrreges
     * @return true si el submarí s'ha enfonsat or false si no ho ha estat.
     */
    private static boolean escoltarSonar(int[] ps, int[] pc) {
        // Apliquem pitàgores entre els dos punts (submarí i tret) per saber a la distància que estan
        double dis = Math.sqrt((ps[0] - pc[0]) * (ps[0] - pc[0]) + (ps[1] - pc[1]) * (ps[1] - pc[1]));


        if (dis == 0) {
            System.out.print("Submarí enfonsat!\n");
            return true;
        } else if (dis < 1.42) { // 1.42 és la hipotenusa d'un triangle rectangle de catets = 1, vol dir que el tret està al costat del submarí
            System.out.print("Submarí aprop!\n");
            return false;


            //Modificació de programa d'avís de submarí en coordenada x;

        } else if (ps[0]-1 == pc[0]-1 || ps[0]+1 == pc[0]+1){
            System.out.println("La coordenada x del submari es: "+ ps[0]+"!");
            return false;

        } else {
            System.out.print("Aigua!\n");

            return false;
        }


    }

    /**
     * Ni edea
     * @param dm
     * @param ps
     * @return
     */
    private static int[] moureSubmari(int dm, int[] ps) {
        int[] nps = {ps[0], ps[1]};
        int ix = (int) (3 * Math.random()) - 1;
        int iy = (int) (3 * Math.random()) - 1;
        nps[0] += ix;
        nps[1] += iy;
        if (nps[0] < 0) {
            nps[0] = 0;
        }
        if (nps[0] > dm - 1) {
            nps[0] = dm - 1;
        }
        if (nps[1] < 0) {
            nps[1] = 0;
        }
        if (nps[1] > dm - 1) {
            nps[1] = dm - 1;
        }
        return nps;
    }
}

