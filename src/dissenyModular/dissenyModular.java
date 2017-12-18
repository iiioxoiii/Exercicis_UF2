package dissenyModular;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class dissenyModular {


/* 3) Fes el disseny modular i la seva posterior implementació en Java d'un programa que porti
 la comptabilitat d'una empresa. L'objectiu és controlar els ingressos i les despeses que hi ha
  hagut durant un període de temps. El programa té un menú amb les següents opcions:

    1. Alta d'ingrés
    2. Alta de despesa
    3. Mostra resum
    4. Històric ingressos
    5. Històric despeses
    6. Fi

    L'opció 'Alta d'ingrés': l'usuari introdueixi una nova partida per a l'ingrés.
    L'opció 'Alta de despesa': l'usuari introdueixi una nova partida per a la despesa.
    L'opció 'Mostra resum': ens mostra un informe on apareix el total d'ingressos i el total
    de despeses. A més, en cas que hi hagi més ingressos que despeses ens mostrarà també la
    següent frase:«L'empresa ha tingut uns beneficis de X euros», on X és la diferència entre
    ingressos i despeses. En cas que les despeses siguin més grans que els ingressos la frase
    a mostrar és: «L'empresa ha tingut un dèficit de X euros», on X és la diferència entre les
    despeses i els ingressos.

    Les opcions històric ingressos i despeses mostraran un llistat dels ingressos i despeses
    realitzats respectivament, així com la data exacte de la seva realització.

    L'opció 'fi' fa que acabi el programa.

    Usar la classe ArrayList per a emmagatzemar els ingressos i despeses, així com les dates.
    Usar la classe Date per a representar les dates.*/

    //static ArrayList <Double> ingressos = new ArrayList();
    //static ArrayList <Double> despeses = new ArrayList();

    static HashMap<Date, Double> ingressos = new HashMap<>();
    static HashMap<Date, Double> despeses = new HashMap<>();




    public static void main(String[]args){
        principal();
    }

    public static void principal (){

        Scanner sc = new Scanner(System.in);
        int opcio = 7;

        while(opcio!=6) {
            System.out.println("1. Alta d'ingrés");
            System.out.println("2. Alta de despesa");
            System.out.println("3. Mostra resum");
            System.out.println("4. Històric ingressos");
            System.out.println("5. Històric despeses");
            System.out.println("6. Fi");

            opcio = sc.nextInt();


            switch (opcio){
                case 1 : altaIngres();
                        break;
                case 2 : altaDespesa();
                        break;
                case 3 : mostraResum();
                        break;
                case 4 : historicIngressos();
                        break;
                case 5 : historicDespeses();
                        break;
            }
        }

        System.out.println("bye");

    }

    public static void altaIngres(){
        Scanner quantitat = new Scanner(System.in);
        ingressos.put(new Date(),quantitat.nextDouble());

    }

    public static void altaDespesa(){
        Scanner quantitat = new Scanner(System.in);
        despeses.put(new Date(), quantitat.nextDouble());

    }

    public static void mostraResum(){
        Double subtotalIngressos = 0.;
        for (HashMap.Entry<Date, Double> ingres :ingressos.entrySet()) {
            subtotalIngressos = ingres.getValue() + subtotalIngressos;
        }

        Double subtotalDespeses = 0.;
        for (HashMap.Entry<Date, Double> despeses :despeses.entrySet()) {
            subtotalDespeses = despeses.getValue() + subtotalDespeses;
        }

        System.out.println("Total ingresos: " + subtotalIngressos);
        System.out.println("Total despeses: " + subtotalDespeses);

        if (subtotalIngressos>subtotalDespeses) {
            System.out.println("L'empresa ha tingut uns beneficis de " + (subtotalIngressos - subtotalDespeses) + "euros");
        }else if (subtotalIngressos<subtotalDespeses){
            System.out.println("L'empresa ha tingut un dèficit de "+ (subtotalDespeses-subtotalIngressos)+ " euros");
        }
    }


    public static void historicIngressos(){

        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy");

        for (HashMap.Entry<Date, Double> ingres: ingressos.entrySet()) {
            String dates = formatter.format(ingres.getKey());
            System.out.println( dates + " " + ingres.getValue().toString());
        }
    }

    public static void historicDespeses(){

        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy");

        for (HashMap.Entry<Date, Double> despesa: despeses.entrySet()) {
            String dates = formatter.format(despesa.getKey());
            System.out.println( dates + " "+ despesa.getValue().toString());
        }

    }



}