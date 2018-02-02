package matricula;

/*
* 4. Formem part d'un projecte de gestió de matrícules. Ens han demanat que implementem pel
* projecte una classe estudiant, ha de ser una classe que guardi la següent informació: DNI de
* l'estudiant, un nom, una adreça, una data de naixament i un telèfon. I que sigui capaç de tenir
* les següents funcionalitats:
*
* - Donar d'alta un estudiant (amb els paràmetres adients).
* - Borrar les dades d'un estudiant.
* - Ordenar un conjunt d'estudiants per DNI.
* - Ordenar un conjunt d'estudiants per edat.
*
* Realitza la classe. Fes una altra classe que es digui Test.java, que serveixi per provar totes
* les funcionalitats que ha de realitzar Estudiant.java.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class matricula {


    static List<matricula.estudiant> llista = new ArrayList<matricula.estudiant>();


    public static void main(String[] args) {
        matricula.matricula inici = new matricula.matricula();
        inici.menu();
    }



    public static void menu(){

        boolean sortir = false;

        while (sortir!=true){

            System.out.println("1) Alta estudiant");
            System.out.println("2) Baixa estudiant");
            System.out.println("3) Ordena estudiant per DNI");
            System.out.println("4) Ordena estudiant per edat");
            System.out.println("5) exit");

            int opcio = preguntaEnter();

            if(opcio==1){
                creaEstudiant();
            }else if (opcio==2){
                baixaEstudiant();
            }else if(opcio==3){
                ordenaPerDNI();
            }else if(opcio==4){
                ordenaPerEdat();
            }else{
                sortir=true;
                System.out.println("by");
            }
        }

    }


    public static void baixaEstudiant(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Entra el DNI:");
        String dni = sc.next();

        for (matricula.estudiant e:llista) {
            if(e.getDni().equals(dni)){
                llista.remove(e);
            }
        }

    }


    public static void ordenaPerDNI(){
        matricula.ComparatorEstudiantPerDNI cc = new matricula.ComparatorEstudiantPerDNI();
        Collections.sort(llista,cc);
        for (matricula.estudiant e: llista) {
            System.out.println(e.toString());
        }
    }


    public static void ordenaPerEdat(){
        matricula.ComparatorEstudiantPerEdat cc= new matricula.ComparatorEstudiantPerEdat();
        Collections.sort(llista,cc);
        for (matricula.estudiant e: llista) {
            System.out.println(e.toString());
        }
    }



    public static void  creaEstudiant(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Entra DNI:");
        String dni= sc.nextLine();
        System.out.println("Entra nom:");
        String nom= sc.nextLine();
        System.out.println("Entra adreça:");
        String adreca= sc.nextLine();
        System.out.println("Entra data:");
        String naixement= sc.nextLine();
        System.out.println("Entra telèfon:");
        String telefon = sc.nextLine();

        //String dni, String nom, String adreca, String naixement, String telefon
        matricula.estudiant estudiant = null;

        try {
            matricula.estudiant e = new matricula.estudiant(dni,nom,adreca,naixement,telefon);
            llista.add(e);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error en creacio d'objecte persona");
        }


    }


    public static int preguntaEnter(){
        Scanner sc = new Scanner(System.in);
        System.out.print(":");
        return sc.nextInt();
    }



}
