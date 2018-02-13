package fitxers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * 1.
 * Escriu un programa que donat un directori escrigui per pantalla el nom del fitxer més gran que conté.
 * Ha de comprovar si el directori és vàlid.
 *
 * 2.
 * Modifica l'exercici anterior de manera que si rep un argument al ser executat l'utilitzi com a nom del directori de búsqueda.
 * Si no rep arguments preguntarà el nom del directori a l'usuari per teclat.
 *
 * 3. Cercador de fitxers.
 * Busca dins un directori donat quins fitxers contenen la paraula "exercici" al seu nom i mostra'ls per pantalla.
 *
 * 4. Necessitem fer un inventari.
 * Entra dins un directori i per cada entrada que trobis dóna totes les característiques que puguis.
 *
 * 5. Crea un programa que donat un directori sigui capaç d'eliminar tots els fitxers que comencin per un número.
 *
 * 6. Donat un directori crea un programa que sigui capaç de crear-hi un nou directori per cada fitxer.txt i viceversa,
 * per cada directori trobat creï un fitxer txt amb el mateix nom.
 *
 * 7. Crea un programa amb un menú que sigui capaç de mostrar les entrades d'un directori per ordre alfabètic,
 * per ordre de modificació o per ordre de més tamany a menys tamany.
 *
 * **/


public class fitxers {


    public static void main(String[] args) {
        fitxers inici = new fitxers();
        inici.go();

    }



    /**
     * Cada metode comentat correspon a cada enunciat. Hi han un total de 7 mètodes
     * Per executar cal descomentar el metode que es vulgui executar
     *
     * **/
    public static void go(){

        //System.out.println(biggestFile("/fitxers/directoriDeTreball"));
        //biggestFile();
        //cercadorFitxers("src/fitxers/directoriDeTreball");
        //inventari("src/fitxers/directoriDeTreball");
        //esborraPerNumero("src/fitxers/directoriDeTreball");
        crea("src/fitxers/directoriDeTreball");
        // explorador();

    }

    public static void crea(String ruta){

        File d = new File(ruta);
        File [] dir = d.listFiles();

        //Es recorre la llista de fitxers
        for (File ff: dir) {

            // Si es un fitxer es crea un directori
            if(ff.isFile()){
                ff.mkdir();
            }

            //Si es un directori es crea un fitxer.
            if(ff.isDirectory()){
                File fff = new File (d, ff.getName()+ ".txt");
                try {
                    fff.createNewFile();
                }catch (IOException e){
                    System.out.println("Error en creacio");
                }
            }
        }


    }

    public static void esborraPerNumero(String ruta){

        File d = new File(ruta);
        File [] dir = d.listFiles();

        //Patro regex: primer caracter es un numero.
        Pattern p = Pattern.compile("^\\d");

        for(File fd: dir){

            if(fd.isFile()){
                Matcher m = p.matcher(fd.getName());
                if(m.find()){
                    fd.delete();
                }
            }
        }

    }


    public static void inventari(String ruta){

        File f =new File(ruta);

        File[] files = f.listFiles();

        for (File ff: files) {

            if (ff.isDirectory()) {
                System.out.println("d " + ff.getName());
                inventari(ff.getAbsolutePath());
            } else {
                System.out.println("f " + ff.getName() + " "+ff.length() + " B");
            }
        }


    }


    public static void cercadorFitxers(String ruta) {

        Pattern p = Pattern.compile("exercici");

        File r = new File(ruta);

        File[] llista = r.listFiles();

        if (llista == null) {
            System.out.println("Directori buit");

        } else {
            for (File ff : llista) {
                Matcher m = p.matcher(ff.getName());
                if (m.find()) {
                    System.out.println(ff.getName().toString());
                }
            }
        }
    }


    /**Retorna true or false si el directori es buit.
     * @param ff
     * @return true or false
     */

    public static boolean dirBuit(File ff) {

        boolean sortida = false;

        if (ff.length() == 0) {
            sortida = true;
        } else {
            sortida = false;
        }

        return sortida;
    }


    /**
     * Retorna true or false si el directori es buit.
     *
     * @param ruta
     * @return true or false
     */
    public static boolean dirBuit(String ruta) {

        File ff = new File(ruta);

        boolean sortida = false;

        if (ff.length() == 0) {
            sortida = true;
        } else {
            sortida = false;
        }

        return sortida;
    }


    public static void biggestFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriu directori");
        String ruta = sc.nextLine();
        biggestFile(ruta);
    }


    public static String biggestFile(String ruta) {

        File rutadir = new File(ruta);

        boolean hihaFitxer = false;

        File max = null;

        //1. Es comproba que el dir no estigui buit
        if (dirBuit(ruta)) {
            return "Directori buit";
        }


        //2. Es comprova que hi hagi un fitxer com a mínim

        for (File ff : rutadir.listFiles()) {

            if (ff.isFile()) {
                max = ff;
                hihaFitxer = true;
            }
        }

        if (!hihaFitxer) {
            return "No hi ha cap fitxer al directori";
        }


        //3.  Si hi ha un fitxer es fa la cerca del més gran
        if (hihaFitxer) {
            for (File ff : rutadir.listFiles()) {
                //Es comprova si es més gran que el maxim posat abans
                if (ff.isFile()) {

                    if (ff.length() >= max.length()) {
                        max = ff;
                    }
                }
            }
        }

        return ("El fitxer mes gran es " + max.toString());
    }


}