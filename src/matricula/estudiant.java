package matricula;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class estudiant {

    private static int n = 0;

    private String dni;
    private String nom;
    private String adreca;
    private Date naixement;
    private String telefon;


    public estudiant(String dni, String nom, String adreca, String naixement, String telefon) {
        this.dni = dni;
        this.nom = nom;
        this.adreca = adreca;
        this.naixement = naixementToDate(naixement);
        this.telefon = telefon;
        n++;
    }


    public Date naixementToDate(String dd_MM_yyyy){

        Date data = null;

        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(dd_MM_yyyy);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }


    public void setNaixement(Date naixement){
        this.naixement = naixement;
    }


    public String getNaixement(){

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String naixement = df.format(this.naixement);
        return naixement;
    }



    public String getDni(){
        return this.dni;
    }

    public void setDni(String dni){
        this.dni=dni;
    }


    public String getNom() {

        return this.nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public String getAdreca() {

        return adreca;
    }

    public void setAdreca(String adreca) {

        this.adreca = adreca;
    }


    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }



    // Són dos estudiants iguals aquells que tenen:
    // nom i dni iguals
    public boolean equals(Object o){
        boolean r = false;

        if(o instanceof estudiant){
            estudiant e = (estudiant) o;
            r = this.getNom().equals(e.getNom()) &&
                    this.getDni().equals(e.getDni());
        }
        return r;
    }


    //El compareTo amb els mateixos elements que el equals
    //nom i dni
    public int compareTo(estudiant e){
        int r;
        r = getNom().compareTo(e.getNom());
        if (r==0){
            r = getDni().compareTo(e.getDni());
        }

        return r;
    }


    public String toString() {
        String s;
        s = "["+getDni() + ", " + getNom() + ", " + getAdreca() + ", " + getTelefon()
                + ", " + getNaixement()+"]";
        return s;
    }


}
