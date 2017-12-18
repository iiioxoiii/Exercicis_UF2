package dissenyModular;

/*
* 6) Donada una frase on apareixen una llista de paraules acabada amb un punt (.)
* i una paraula X. Digues amb quina freqüència apareix la paraula X dins la frase
* (no es distingeix majúscula o minúscula). Per exemple: "cinc boles serveixen per
* cinc jocs i per cinc nens" la paraula "cinc" apareix amb una freqüència de 3/10.
*
* */


public class frequenciaParaula {

    public static void main(String[] args) {
        frequenciaParaula.frequencia("cinc boles serveixen per cinc jocs i per cinc nens", "cinc");
    }

    public static void frequencia(String frase, String paraula){

        int num=0;

        frase = frase.toLowerCase();
        String [] array = frase.split(" ");

        array[array.length-1]= array[array.length-1].replace(".","");

        for (String a:array){
            if(a.equals(paraula)){
                num++;
            }
        }

        System.out.println(num + "/"+ array.length);
    }

}
