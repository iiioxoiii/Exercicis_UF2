package fitxersInOut;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fitxersInOut {




    public static void main(String[] args) {

        /**1. Donat un fitxer de text pla crea un programa que escrigui el seu
         contingut per pantalla.
         **/

        pintaArxiuPantalla();

        /** 2. Escriu un programa que llegeixi un fitxer de text plà i en reescrigui
        per pantalla el contingut en majúscules.
         **/

        pintaArxiuMajuscula();

    }


    public static void pintaArxiuMajuscula(){

        try {
            FileReader f = new FileReader("src/fitxersInOut/INFO.txt");
            BufferedReader b = new BufferedReader(f);

            while(b.readLine()!=null){

                //System.out.println(b.readLine());
                System.out.println(b.readLine().toUpperCase());

            }

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

        }catch (IOException e){
            e.printStackTrace();
        }

    }




}
