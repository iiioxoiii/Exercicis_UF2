package fitxersInOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

        System.out.println(apareixCadenaNumVegades());

        /** 5. Modifica el programa anterior per a que, un cop comptades les
         * ocurrències de la cadena, el programa escrigui en un altre fitxer el
         * número de vegades que apareix. El nou fitxer es dirà igual que
         * l'original més el sufix .count
         * **/

    }

    public static int apareixCadenaNumVegades(){

        int n = 0;

        try {
            FileReader f = new FileReader("src/fitxersInOut/INFO.txt");
            BufferedReader b = new BufferedReader(f);

            while(b.readLine()!=null) {

                String linia = b.readLine();

                linia.matches("");
                    n++;
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(n);
        return n;
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
