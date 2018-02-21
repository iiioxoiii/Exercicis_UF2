package fitxersInOut;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
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

        //copiaAmbDos("src/fitxersInOut/ascii");

        /** 8. Prova amb un exemple les classes BufferedInputStream i BufferedOutputStream.**/

        //exempleAmbBuffered("src/fitxersInOut/INFO.txt");

        /** 9. Escriure un programa que fagi una còpia d'un fitxer. Ho ha de fer llegint-l
         * byte a byte, de manera que ha de copiar qualsevol tipus de fitxer (imatges,
         * vídeo, executable, text plà, ...).  Utilitza les classes BufferedInputStream
         * i BufferedOutputStream.
         **/

        //copiaUnFitxer("src/fitxersInOut/INFO.txt", "src/fitxersInOut/INFO2.txt");


        /** 10. Realitza un programa anomenat Analitzador.java que donat un fitxer de text
         * plà calculi el número de paraules que hi ha al text. El resultat s'escriurà per pantalla.
         * El resultat també s'escriurà a un fitxer de text plà anomenat paraules.txt, on cada execució
         * del programa afegirà una línia amb l'últim resultat obtingut, amb el format següent:
         *
         * nom_fitxer número_paraules
         * Per exemple:
         * C:\Users\dam\prova.txt 12
         * C:\Users\pepito\curriculum.txt 297
         * C:\Users\pepito\abecedari.txt 10
         * **/

        //analitzador("src/fitxersInOut/INFO.txt");

        /** 11. Donat un fitxer binari que conté enters (int), llegeix el seu contingut i
         * calcula la mitjana de tots els enters. Després escriu la mitjana al final del
         * fitxer.
         **/


        //creaBinari("src/fitxersInOut/enters.bin");
        //mitjanaEnters("src/fitxersInOut/enters.bin");


        /** 12. Donat un fitxer binari que conté enters (int), ordena directament sobre el
         * fitxer (usant la classe RandomAccesFile) tots els seus valors, de menor a major.
         **/

        //creaBinari("src/fitxersInOut/enters.bin");
        mostraBinari("src/fitxersInOut/enters.bin");
        //ordenaBinari("src/fitxersInOut/enters.bin");
    }



    public static void mostraBinari(String fitxer){

        File ff = new File (fitxer);

        try {
            FileInputStream fff = new FileInputStream(ff);

            long mida = ff.length();
            byte[] bytes = new byte[(int) mida];

            for (int i = 0; i < mida; i++) {
                bytes[i] = (byte) fff.read();
                System.out.println(bytes[i]);
            }


            fff.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }


    public static void ordenaBinari(String fitxer){
        File ff = new File (fitxer);

        try {
            FileInputStream fff = new FileInputStream(ff);

            long mida = ff.length();
            byte[] bytes = new byte[(int)mida];

            for (int i = 0; i < mida ; i++) {
                bytes[i]=(byte)fff.read();
            }

            fff.close();
            FileOutputStream ffo = new FileOutputStream(fitxer);

            Arrays.sort(bytes);

            for (int i = 0; i < bytes.length; i++) {
                ffo.write(bytes[i]);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public static void mitjanaEnters(String fitxer){
        File ff = new File (fitxer);
        long mida = ff.length();
        long total = 0;

            try {
                BufferedReader bf = new BufferedReader(new FileReader(ff));
                for (int i = 0; i < mida ; i++) {
                    int n = bf.read();
                    System.out.println(n);
                    total = n + total;
                }

                //System.out.println("Suma del total: "+ total);
                total = total / (mida);
                System.out.println("Mitjana: "+ total);

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }



    public static void creaBinari(String fitxer){

        //Quantitat de números enters que es desaran al fitxer
        final int q = 10;

        try {
            FileWriter fw = new FileWriter(fitxer);
            for (int i = 0; i < q; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
                fw.write(randomNum);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void mitjana(String fitxer){

    }


    public static void analitzador(String fitxer) {
        int num = 0;

        String fNumParaules = "src/fitxersInOut/número_paraules.txt";

        try {

            File entrada = new File (fitxer);
            File sortida = new File (fNumParaules);

            BufferedReader fReader = new BufferedReader(new FileReader(entrada));
            BufferedWriter fWriter = new BufferedWriter(new FileWriter(sortida,true));

            while (fReader.ready()) {
                String linia = fReader.readLine();
                num = num + countWords(linia);
            }

            fReader.close();
            fWriter.write(fitxer+" " + num);
            fWriter.write('\n');
            fWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int countWords(String text) {

        int result = 0;

        //Pattern p = Pattern.compile("[A-Za-z]");
        Pattern p = Pattern.compile("\\w*");
        Matcher matcher = p.matcher(text);
        while (matcher.find()){
            result++;
        }
        //int result = text.split("\\w+").length ;

        return result;
    }


    public static void copiaUnFitxer(String origen, String desti) {

        File fo = new File(origen);
        File fd = new File(desti);

        BufferedOutputStream outputStreamData = null;
        try {
            BufferedInputStream inputStreamData = new BufferedInputStream(new FileInputStream(fo));
            outputStreamData = new BufferedOutputStream(new FileOutputStream(fd));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStreamData.read(buffer)) > 0) {
                outputStreamData.write(buffer, 0, length);
            }

            inputStreamData.close();
            outputStreamData.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //El IDE no pilla tancament al finally
            //inputStreamData.close();
            //outputStreamData.close();
        }

    }



    public static void exempleAmbBuffered(String fitxer){

        File fileOrigen = new File (fitxer);

        String ruta  = fileOrigen.getParent();
        String nomFileDesti = fileOrigen.getName().concat(".2");
        String barra = "/";
        nomFileDesti = ruta.concat(barra).concat(nomFileDesti);

        File fileDesti = new File(nomFileDesti);


        try {

            fileDesti.createNewFile();

            BufferedReader a = new BufferedReader(new FileReader(fitxer));
            BufferedWriter b = new BufferedWriter(new FileWriter(fileDesti));


            while (a.ready()){
                String linia = a.readLine();
                b.write(linia);
            }
            a.close();
            b.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Amb File, Reader i Writer
     * @param fitxer
     */
    public static void copiaAmbDos(String fitxer){

        File fileOrigen = new File (fitxer);

        String ruta  = fileOrigen.getParent();
        String nomFileDesti = fileOrigen.getName().concat(".2");
        nomFileDesti = ruta + fileOrigen.separatorChar + nomFileDesti ;

        File fileDesti = new File(nomFileDesti);


        try {

            fileDesti.createNewFile();

            //Reader a = new FileReader(fitxer);
            //Writer b = new FileWriter(fileDesti);

            /**while (a.read() != -1) {
             try {
             char c = (char) a.read();
             b.write(c);

             } catch (IOException e) {
             e.printStackTrace();
             }
             }**/

            FileInputStream aa = new FileInputStream(fileOrigen);
            FileOutputStream bb = new FileOutputStream(fileDesti);

            int cc;
            while ((cc = aa.read()) != -1) {
                try {
                    bb.write(cc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            bb.close();
            aa.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * Amb FileReades i BufferedReader.
     * Comptabilitza el numero de vegades que apareix una cadena de caràcters i
     * escriu el resultat cridant el mètode escriuVegadesAFile.
     * @param entrada
     * @param cadenaCaracters
     */
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


    /**
     * Amb File i PrintWritter
     * Crea un arxiu amb informació passada pels paràmetres
     * @param n Un enter
     * @param entrada nom en el qual es crea l'arxiu final
     */
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


    /**
     * Amb FileReader i BufferedReader
     * Es llegeix línia a línia i s'analitza si conté un patro Pattern.
     *
     * @return true si el patró apareix de 1 o més vegades.
     */
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


    /**
     * Amb FileReader i BufferedReader
     * Es llegeix línia a línia i es passa a majuscula
     */
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


    /**
     * Amb FileReader i BufferedReader
     * Es llegeix línia a línia.
     */
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
