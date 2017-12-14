package dissenyModular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class exercicis {

    public static void main(String[] args) {


    }


    /* 1. (signe) Fer una funció que rebi un enter i retorni la cadena "negatiu”,
    "zero” o "positiu” segons si l'enter és negatiu, zero o positiu.*/

    public String signe (int num) {

        String sortida=null;

        if( num == 0 ){
            sortida = "zero";
        }
        if ( num > 0 ){
            sortida = "positiu";
        }
        if ( num < 0 ){
            sortida = "negatiu";
        }

        return sortida;
    }



    /*2. (esPrimer) Fer una funció que rebi un nombre natural i ens retorni true si
    és primer i false si no ho és. */

    public boolean esPrimer (int num){

        int aux;
        for(int cont=2;cont<num;cont++) {
            aux=num%cont;
            if(aux==0)
            return false;
        }
        return true;
    }



    /*3. (max) Fer una funció que donats dos nombres ens retorni el màxim. */

    public int max (int a, int b){

        int sortida=0;

        if( a > b ){
            sortida = a;
        }

        if( a < b ){
            sortida = b;
        }

        return sortida;
    }



    /* 4. (max,min) Fer dues funcions que donats tres nombres ens retornin el
    màxim i el mínim, respectivament*/

    public int max(int a,int b, int c){
        if(a>=b && a>=c){
            return a;
        }else if(b>=a && b>=c){
            return b;
        } else if(c>=a && c>=b){
            return c;
        }else
            return 0;
    }

    public int min(int a,int b, int c){
        if(a<=b && a<=c){
            return a;
        }else if(b<=a && b<=c){
            return b;
        } else if(c<=a && c<=b){
            return c;
        }else
            return 0;

    }



    /*5. (ordena) Fer una funció que donats tres nombres ens els ordeni de manera creixent */

    public void ordena (Integer a, Integer b, Integer c){
        List llista = new ArrayList();

        llista.add(a);
        llista.add(b);
        llista.add(c);

        Collections.sort(llista);

        for (Object n:llista) {
            System.out.println( n + " ");
        }
    }



    /*6. (sumaArray) Fer una funció que rebi un vector numèric i retorni la suma dels
    seus elements.*/

    public int sumaArray (int [] vector){
        int suma = 0;

        for (int i = 0; i < vector.length; i++) {
            suma = vector[i] + suma;
        }
        return suma;
    }



    /*7. (parellsArray) Fer una funció que rebi un vector i retorni quants elements són parells.*/

    public int parellArray (int [] vector){
        int parells = 0;

        for (int i = 0; i < vector.length ; i++) {
            if (vector[i]%2 == 0){
                parells++;
            }

        }

        return parells;
    }



    /*8. (primersArray) Fer una funció que rebi un vector i retorni un altre vector amb tots
    els elements del vector original que siguin primers.*/

    public Integer [] ex8 (Integer [] vector){

        List llistaPrimers = new ArrayList();

        for (int n:vector) {

            if(esPrimer(n)){
                llistaPrimers.add(n);
            }
        }

        Integer[] arr = (Integer[]) llistaPrimers.stream().toArray(Integer[]::new);
        return arr;
    }



    /*9. (maximMatriu) Fer una funció que retorni el valor màxim d'una matriu.*/
    
    public int matiuMaxim (int [][] matriu){
        
        int maxTemp = matriu[0][0];

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[0].length; j++) {
                if(matriu[i][j] >= maxTemp){
                    maxTemp=matriu[i][j];
                }
            }
        }

        return maxTemp;
    }




    /*10. Fer un programa que reculli des de teclat dos nombres i presenti una sèrie d'opcions
    corresponents a operacions aritmètiques (suma, resta, multiplicació, divisió).
    Segons l'opció escollida es crida una funció que retorni el valor del resultat
    de l'operació. Si es vol seguir operant s'ha de contestar 'S' a un missatge que digui
    "Vols continuar?”. Per acabar el programa s'ha de contestar 'N'. */

    public void programaOpcions(){

        boolean sortir = false;

        while (!sortir) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Entra dos enters: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.close();

            sc = new Scanner(System.in);
            System.out.println("1) suma");
            System.out.println("2) resta");
            System.out.println("3) multiplicacio");
            System.out.println("4) divisio");
            int opcio = sc.nextInt();

            switch (opcio) {
                case 1:
                    System.out.println("La suma es " + suma(a,b));
                    break;
                case 2:
                    System.out.println("La resta es " + resta(a,b));
                    break;
                case 3:
                    System.out.println("La multiplicació es " + multiplicacio(a,b));
                    break;
                case 4:
                    System.out.println("La divisió " + divisio(a,b));
                    break;
            }

            sc.close();

            sc = new Scanner(System.in);
            System.out.println("Vol continuar? S/N:");
            String op = sc.next();

            switch (op) {
                case "S":
                    sortir = true;
                    break;
                case "N":
                    break;

            }
        }
    }


    public int suma (int a, int b){
        return a+b;
    }

    public int resta (int a, int b){
        return a-b;
    }

    public int multiplicacio (int a, int b){
        return a*b;
    }

    public int divisio (int a, int b){
        return a/b;
    }


    
    /*11. El nom del dia de la setmana. L'objectiu d'aquesta activitat és saber codificar un
    mètode amb paràmetres d'entrada i sortida perquè realitzi una tasca concreta.
    Has de crear una funció que si li entrem un enter sigui capaç de traure un String
    indicant quin dia de la setmana és (del 1 al 7), si no està en aquest rang també
    ho ha de dir. Fes l'exercici de dues maneres. Fent que diaDeLaSetmana és una funció
    i fent que diaDeLaSetmana sigui una acció.*/

    public void nomDiaDelaSetmana (int d){

        switch (d) {
            case 1:
                System.out.println("Dilluns " );
                break;
            case 2:
                System.out.println("Dimarts" );
                break;
            case 3:
                System.out.println("Dimecres");
                break;
            case 4:
                System.out.println("Dijous");
                break;
            case 5:
                System.out.println("Divendres");
                break;
            case 6:
                System.out.println("Dissabte");
                break;
            case 7:
                System.out.println("Diumenge");
                break;
            default:
                System.out.println("No es un dia de la setmana");
        }
    }


    public String diaDelaSetmana (int d){

        switch (d) {
            case 1:
                return "Dilluns";
            case 2:
                return "Dimarts";
            case 3:
                return "Dimecres";
            case 4:
                return "Dijous";
            case 5:
                return "Divendres";
            case 6:
                return "Dissabte";
            case 7:
                return "Diumenge";
            default:
                return "No es un dia de la setmana";
        }

    }

    /*12. Fes un convertidor de temperatures. El programa ha de demanar en quina magnitud
    entrem la temperatura (celsius, farenheit o kelvin), tot seguit entrarem el valor numèric.
    A continuació es mostrarà un menú on es permetrà fer la conversió adient: de celsius a
    farenheit, de celsius a kelvin, de farenheit a celsius, de farenheit a kelvin, de kelvin
    a celsius i de kelvin a farenheit.*/

    /* Fes un menú amb aquestes opcions i una última opció per sortir. Implementa les funcions
    que necessitis per a realitzar les conversions, en el main no hi pot haver cap conversió.
    El programa ha de tenir en compte que si ens entren una determinada magnitud aquesta només
    permetrà convertir a les altres dues... sinó ens ha de donar error. Ex: si entrem la
    magnitud inicial amb Celsius, no podrem convertir de Farenheit a Celsius ja que ja ho
    tenim en Celsius.*/

    public void conversorTemperatures (int op, Double valor){

        switch (op) {
            case 1:
                //Celsius -> farenheit;
                valor = celsiusFarenheit(valor);
                break;
            case 2:
                //Celsius -> kelvin;
                valor = celsiusKelvin(valor);
                break;
            case 3:
                //Farenheit -> celsius
                valor = farenheitCelsius(valor);
                break;
            case 4:
                //Farenheit -> kelvin
                valor = farenheitKelvin(valor);
                break;
            case 5:
                //Kelvin -> celsius
                valor = kelvinCelsius(valor);
                break;
            case 6:
                //Kelvin -> farenheit
                valor = kelvinFarenheit (valor);
                break;
        }

        System.out.println("El valor es: " + valor);
    }

    public Double celsiusFarenheit(Double a){
        return a + 33.8;
    }

    public Double celsiusKelvin(Double a){
        return a + 273.15;
    }

    public Double farenheitKelvin(Double a){
        return (a-32) * (5/9);
    }

    public Double farenheitCelsius(Double a){
        return a * (9/5) + 32;
    }

    public Double kelvinCelsius(Double a){
        return a - 273.15;
    }

    public Double kelvinFarenheit(Double a){
        return (9*(a*273.15)/5)+32;
    }


    /*13. Completeu la classe Forecast.java per a que retorni la temperatura, humitat, pressió,
    vent (velocitat i direcció) o estat general del temps de la ciutat que se li passi per
    paràmetre al executar el programa. La informació que desitgem recuperar també es passarà
    per paràmetre (fixeu vosaltres la sintaxi concreta).*/

    public void funcioForecast (){

        forecast ciutatA = new forecast();
        ciutatA.setParametres("Barcelona","25.4","87","1023","23","NO","Nublado");
        ciutatA.pintaInfo();
    }

}
