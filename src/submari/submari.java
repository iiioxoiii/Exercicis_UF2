package submari;

/*
* 5. El fitxer Submari.java implementa el joc anomenat La Caça del Submarí.
* Analitza el codi i fes el següent:
*
* - Explica com funciona el joc, i per tant el programa.
* - Escriu els comentaris javadoc de tots els mètodes, descrivint la seva funcionalitat i
* el significat dels seus arguments i resultats.
* - Modifica el codi de manera que quan no s'encerti el submarí es doni una pista d'on està situat.
* La pista s'ha de donar abans de moure el submarí:
*
* Si el tret no destrueix el submarí però cau en algun dels punts situats just a l'entorn de la posició
* del submarí, s'informarà sobre la proximitat de l'impacte donant les dues coordenades de posició
* del submarí.. Si la càrega no destrueix el submarí ni cau en algun dels punts situats just a l'entorn
* de la posició del submarí, el sònar informarà  del fet tot mostrant a l'usuari el valor de la coordenada
* x del submarí.
*
* */


public class submari {

    public static void main(String[] args) {
        submari.submari inici = new submari.submari();
        inici.go();
    }

    public static void go(){

    }
}
