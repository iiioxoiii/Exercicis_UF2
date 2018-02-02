package comandament;


    /* 2. Comandament a distància.
    Crearem una classe Comandament.java que farà la funció d'un comandament a distància.
    Aquesta classe tindrà un menú amb diferents funcionalitats:
    - Tindrà botons numèrics que seran els canals de l'1 al 6.
    - Tindrà una opció que serà el volum (valor numèric) que es pot pujar o baixar
    - Tindrà una opció per habilitar els subtítols.
    - Tindrem també una variable numèrica que serà l'hora.
    - Tindrà una altra opció per canviar d'idioma.

    En el nostre programa tindrem una altra classe que es dirà Canals.java, i el que farà
    aquesta classe serà mostrar el programa que fan en cada canal quan es cliqui el seu número.
    Dissenya i implementa el comandament a distància, primer només amb les dues classes, i
    després amb atributs de classe: numCanal, nomPrograma, volum, subtitol i idioma.*/


public class comandament {

    public static void main(String[] args) {
        comandament.comandament inici = new comandament.comandament();
        inici.go();
    }

    public static void go(){

    }
}
