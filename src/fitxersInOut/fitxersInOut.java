package fitxersInOut;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fitxersInOut {


    public static void main(String[] args) {

        /**1. Donat un fitxer de text pla crea un programa que escrigui el seu
         *contingut per pantalla.
         *
         *info: s'agafa l'arxiu INFO.txt
         *run: fitxersInOut_1
         **/

        //pintaArxiuPantalla();

        /** 2. Escriu un programa que llegeixi un fitxer de text plà i en reescrigui
         * per pantalla el contingut en majúscules.
         *
         * info: s'agafa l'arxiu INFO.txt
         * run: fitxersInOut_1
         **/

        //pintaArxiuMajuscula();

        /**3. Escriure un programa que donat el nom d'un fitxer de text pla i una
         * cadena de caràcters ens digui si la cadena apareix al contingut del fitxer.
         * info: s'agafa l'arxiu INFO.txt
         * run: fitxersInOut_1
         **/

        //System.out.println(apareixCadena());

        /** 4.Escriure un programa que donat el nom d'un fitxer de text pla i una
         * cadena de caràcters ens digui quantes vegades apareix la cadena al
         * contingut del fitxer. Suggerència: usar expressions regulars.
         * **/

        /** 5. Modifica el programa anterior per a que, un cop comptades les
         * ocurrències de la cadena, el programa escrigui en un altre fitxer el
         * número de vegades que apareix. El nou fitxer es dirà igual que
         * l'original més el sufix .count
         * **/

        //String entrada = "src/fitxersInOut/INFO.txt";
        //String cadenaCaracters = "polla";

        //apareixCadenaNumVegades(entrada, cadenaCaracters);


        /** 7. Escriu un programa que faci una còpia d'un fitxer de text pla amb
         * el nom original més un 2.
         * */

        copiaAmbDos("src/fitxersInOut/ascii");

        /** 8. Prova amb un exemple les classes BufferedInputStream i BufferedOutputStream.

        /** 9. Escriure un programa que fagi una còpia d'un fitxer. Ho ha de fer llegint-l
         * byte a byte, de manera que ha de copiar qualsevol tipus de fitxer (imatges,
         * vídeo, executable, text plà, ...).  Utilitza les classes BufferedInputStream
         * i BufferedOutputStream.
         **/

        /** 10. Realitza un programa anomenat Analitzador.java que donat un fitxer de text plà calculi el número de paraules que hi ha al text. El resultat s'escriurà per pantalla. El resultat també s'escriurà a un fitxer de text plà anomenat paraules.txt, on cada execució del programa afegirà una línia amb l'últim resultat obtingut, amb el format següent:
        * nom_fitxer número_paraules
        * Per exemple:
        * C:\Users\dam\prova.txt 12
        * C:\Users\pepito\curriculum.txt 297
        * C:\Users\pepito\abecedari.txt 10
        **/


        /** 11. Donat un fitxer binari que conté enters (int), llegeix el seu contingut i
         * calcula la mitjana de tots els enters. Després escriu la mitjana al final del
         * fitxer.
         **/


        /** 12. Donat un fitxer binari que conté enters (int), ordena directament sobre el
         * fitxer (usant la classe RandomAccesFile) tots els seus valors, de menor a major.
         **/





    }




    public static void copiaAmbDos(String fitxer){

        File fileOrigen = new File (fitxer);

        String ruta  = fileOrigen.getParent();
        String nomFileDesti = fileOrigen.getName().concat(".2");
        String barra = "/";
        nomFileDesti = ruta.concat(barra).concat(nomFileDesti);

        File fileDesti = new File(nomFileDesti);


        try {

            fileDesti.createNewFile();

            Reader a = new FileReader(fitxer);
            Writer b = new FileWriter(fileDesti);

            while (a.read() != -1 ){
                b.write((byte)a.read());

                //b.write(a.read());
            }
            b.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }









    public static void apareixCadenaNumVegades(String entrada, String cadenaCaracters){

        int n = 0;

        try {
            FileReader f = new FileReader(entrada);
            BufferedReader b = new BufferedReader(f);

            Pattern p = Pattern.compile(cadenaCaracters);

            // Es crea una cadena per posar el b.readline perquè sembla
            // que si es retorna null peta l'expressió regular amb matcher
            // https://www.tutorialspoint.com/java/io/bufferedreader_readline.htm

            String linia = null;

            while((linia = b.readLine())!=null) {

                Matcher m = p.matcher(linia);
                if (m.find()){
                    n++;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(n);

        escriuVegadesAFile(n,entrada);
    }



    public static void escriuVegadesAFile(int n, String entrada){

        File fEntrada = new File(entrada);

        //S'extreu la ruta, el nom i s'afegeix el prefix
        String ruta  = fEntrada.getParent();
        String f = fEntrada.getName();
        String barra = "/";
        f = ruta.concat(barra).concat(f).concat(".count");



        try{
            //S'escriu una linia en un fitxer nou
            String liniaFinal = "Les coincidencies son ".concat(String.valueOf(n));
            PrintWriter writer = new PrintWriter(f, "UTF-8");
            writer.println(liniaFinal);

            //IMPORTAT! Sense tancar no escriu.
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }


    public static boolean apareixCadena(){

        boolean apareix =false;

        //Instanciació del patró: "programes"
        Pattern p = Pattern.compile("programes");

        try {
            FileReader f = new FileReader("src/fitxersInOut/INFO.txt");
            BufferedReader b = new BufferedReader(f);


            while(b.readLine()!=null){

                String linia = b.readLine();
                Matcher m = p.matcher(linia);

                if (m.find()){
                    apareix=true;
                    return apareix;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return apareix;
    }

    public static void pintaArxiuMajuscula(){


        try {
            FileReader f = new FileReader("src/fitxersInOut/INFO.txt");
            BufferedReader b = new BufferedReader(f);

            while(b.readLine()!=null){

                //System.out.println(b.readLine());
                System.out.println(b.readLine().toUpperCase());

            }

            b.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }




    public static void pintaArxiuPantalla(){

        try {
            FileReader f = new FileReader("src/fitxersInOut/INFO.txt");
            BufferedReader b = new BufferedReader(f);

            while(b.readLine()!=null){
                System.out.println(b.readLine());
            }

            f.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }




}
