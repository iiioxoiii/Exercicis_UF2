package comandament;


    /* 2. Comandament a distància.
    Crearem una classe Comandament.java que farà la funció d'un comandament a distància.
    Aquesta classe tindrà un menú amb diferents funcionalitats:
    - Tindrà botons numèrics que seran els canal de l'1 al 6.
    - Tindrà una opció que serà el volum (valor numèric) que es pot pujar o baixar
    - Tindrà una opció per habilitar els subtítols.
    - Tindrem també una variable numèrica que serà l'hora.
    - Tindrà una altra opció per canviar d'idioma.

    En el nostre programa tindrem una altra classe que es dirà Canals.java, i el que farà
    aquesta classe serà mostrar el programa que fan en cada canal quan es cliqui el seu número.

    Dissenya i implementa el comandament a distància, primer només amb les dues classes, i
    després amb atributs de classe: numCanal, nomPrograma, volum, subtitol i idioma.*/


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class comandament {

    private int boto;
    private int volum;
    private boolean subtitols;
    private Date hora;
    private String idioma;

    public comandament(int boto, int volum, boolean subtitols, String hora, String idioma) {
        this.boto = boto;
        this.volum = volum;
        this.subtitols = subtitols;

        this.hora = setHora(hora);

        this.idioma = idioma;
    }



    public int getBoto() {
        return boto;
    }

    public void setBoto(int boto) {
        this.boto = boto;
    }

    public int getVolum() {
        return volum;
    }

    public void setVolum(int volum) {
        this.volum = volum;
    }

    public boolean isSubtitols() {
        return subtitols;
    }

    public void setSubtitols(boolean subtitols) {
        this.subtitols = subtitols;
    }

    public Date getHora() {
        return hora;
    }

    public Date setHora(String hora) {

        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        Date h = null;
        try {
            h = format.parse(hora);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return h;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
