package reglahont;

import java.util.*;
import java.util.Scanner;

/**
 *
 * Simulador sobre la llei d'Hondt en unes hipotètiques eleccions electorals.
 *
 * Característiques a complir (en un hipotètic país):
 *
 * 1) Entra per teclat el nom dels partits , el nombre de vots obtinguts i el tamany en nombre d'escons del parlament.
 * 2) Sel·lecciona aquells partits que tenen dret a obtenir representació al parlament.
 * 3) Assigna el nombre d'escons segons l'esmentada llei d'Hondt en cada partit.
 * 4) Permet fer algun canvi en el nombre de vots d'un partit i visualitza tot seguit els canvis produïts en
 * l'assignació d'escons.
 * 5) Donats uns partits decidir si permet o no formar equip de govern (per formar equip de govern es necessita la meitat d'escons + 1).
 *
 *
 *
 *
 * La simulació es fa amb el disseny de dos tipus: partir i eleccions.
 *
 * objecte partit: objecte amb les característiques del partit: el nom i el número de vots.
 *
 * objecte eleccions : un objecte que conté els atributs generals de les eleccions (num partits, vots en blanc,
 * vots nuls, etc) i amb les quals es generen dades derivades
 *            -> preguntes: bloc amb funcions d'entrada de dades i assignació de valors al objecte eleccions
 *            -> cálcul: càlcul de les eleccions i resultats derivats.
 *
 * **/



public class reglahont {

    public static void main(String[] args) {

        eleccions generals2017 = new eleccions();

        generals2017.preguntesBasiques();
        generals2017.calcul();
        generals2017.canviVotsPartit();
        generals2017.calcul();
        generals2017.calculGovern();

    }

}



class eleccions {

    private static int votsBlanc = 0;
    private static int votsNuls = 0;
    private static int partits = 0;
    private static int cens = 0;
    private static int representants= 0 ;
    private static int barreraElectoral = 0;

    private static ArrayList<partit> llistat= new ArrayList<partit>();

    private static ArrayList<grup> parlament =  new ArrayList<grup>();


    public void preguntesBasiques(){

        preguntaRepresentats();
        preguntaMinimaRepresentacio();
        preguntaTotalCens();
        preguntaVotsEnBlanc();
        preguntaVotsNuls();
        preguntaNumPartits();
        preguntaVotsPartits();

    }


    public void canviVotsPartit(){

        System.out.println("Entra el nom del partit que vols canviar els vots:");
        Scanner sc = new Scanner(System.in);

        String nom = sc.next();

        for (partit p:llistat){
            if(p.getNom().equals(nom)){
                System.out.println("quantitat:");
                int vots = entraValors();
                p.setVots(vots);
            }else{
                //System.out.println("No s'ha trobat cap partit amb aquest nom");
            }

        }

    }



    public void calculGovern(){

        System.out.println("Indica els partits per veure si poden formar govern.");
        System.out.println("Entra els noms dels partits separats per espai:");

        int esconsGovern = (representants/2) +1;
        int sumaEscons = 0;

        Scanner sc = new Scanner(System.in);

        String partits = sc.nextLine();
        String [] partitsVector = partits.split(" ");

        for(int i=0; i < partitsVector.length; i++){
            sumaEscons= sumaEscons+retornaEscons(partitsVector[i]);
        }

        if(sumaEscons<esconsGovern){
            System.out.println("No sumen. No poden formar govern");
            System.out.println("Es necessiten" + esconsGovern + "i la suma es de " + sumaEscons);
        }else {
            System.out.println("Sí.Poden formar govern. Sumen "+ sumaEscons);
        }

    }



    public void calcul(){
        calculEscons();
    }




    public int retornaEscons (String nomPartit){

        int n = 0;

        for(grup g:parlament){
            if (nomPartit.equals(g.getNom())){
                n= g.getEscons();
            }
        }

        return n;
    }






    public void calculEscons(){

        //1) Es filtra la llista per la barreraElectorial i es desa en un altra ArrayList
        List<partit> llistatFiltrat = filtreBarrera();

        //2) S'ordena l'array filtrat
        Comparator<partit> c = new comparadorResultats();
        Collections.sort(llistatFiltrat,c);


        //3) Posar els vots de cada partit en un array[]
        //arrayVots[0],arrayVots[1],arrayVots[2];

        int [] arrayVots = new int[llistatFiltrat.size()];
        int a = 0;
        for (partit p:llistatFiltrat) {
            arrayVots[a]=p.getVots();
            a++;
        }


        //4) Es crea una array per posar els escons i s'inicialitza a 0
        //esc[0],esc[1],esc[2], ...
        int [] esc =new int[llistatFiltrat.size()];
        for (int i = 0; i < esc.length; i++) {
            esc[i]=0;
        }

        //5) Es realitza l'assignació d'escons. Cada esco d'un total de getRepresentats va a parar al partit en qüestió o
        //a la posició del array esc[]
        for(int i=0; i<getRepresentants(); i++) {
            int as = escons(arrayVots, esc, llistatFiltrat.size());
            esc[as]=esc[as]+1;
        }

        //6) Es pinta el resultat:
        // Es pinta un ArrayList amb els partits i al costat l'array cutre amb els escons.
        a=0;
        for (partit p : llistatFiltrat) {
            grup entrada = new grup();
            entrada.setNom(p.getNom());
            entrada.setEscons(esc[a]);
            System.out.print(p+"--->");
            System.out.println(esc[a]);
            a++;
        }

    }

    //Funcio d'assignació d'escons.
    int escons( int vots[], int esc[], int p) {

        int imax=0;
        int max=0;

        for( int i=0; i < p; ++i) {
            if( max<(vots[i]/(esc[i]+1)) ) {
                max=vots[i]/(esc[i]+1);
                imax=i;
            }
        }
        return imax;
    }






    //Funció que avalua la llista de partits amb els seus vots i retorna un arraylist amb els partits que han passat el
    //tall
    public static ArrayList<partit> filtreBarrera(){

        ArrayList <partit> partitsBarreraSuperada = new ArrayList<partit>();

        for (partit p : llistat) {
            if(superaBarrera(p.getVots())){
                partitsBarreraSuperada.add(p);
            }
        }
        return partitsBarreraSuperada;
    }

    //Funció que retorna true o false depenent dels vots i la barrera Electoral
    public static boolean superaBarrera(int vots){
        boolean resultat=false;

        if( (100*vots)/ totalVots() > barreraElectoral){
            resultat=true;
        }
        return resultat;
    }

    public void mostraPartitsTallSuperat(){
        for (partit p: llistat) {
            System.out.println(p.toString());
        }
    }

    public void mostraTotalVots(){
        System.out.println("Han hagut un total de "+ totalVots()+" vots");
        System.out.println("Vots vàlids: " + (totalVots()-(votsBlanc+votsNuls)));
        System.out.println("Vots en blac: " + votsBlanc);
        System.out.println("Vots nuls: " + votsNuls);
    }

    public static int totalVots() {
        Integer subtotal = 0;

        //Sumem el total de vots de totes les formacions
        for (partit p : llistat) {
            subtotal = p.getVots() + subtotal;
        }

        //Afegim el total de vots en blanc i nuls
        subtotal = subtotal + votsNuls + votsBlanc;

        return subtotal;
    }

    private void preguntaNumPartits(){
        System.out.println("Introdueix número de partits que participen:");
        this.setPartits(entraValors());
    }

    private void preguntaVotsNuls(){
        System.out.println("Introdueix vots nuls:");
        this.setVotsNuls(entraValors());
    }

    private void preguntaVotsEnBlanc(){
        System.out.println("Introdueix vots en blanc:");
        this.setVotsBlanc(entraValors());
    }

    private void preguntaTotalCens(){
        System.out.println("Introdueix el total del cens:");
        this.setCens(entraValors());
    }

    private void preguntaMinimaRepresentacio(){
        System.out.println("Introdueix el % mínim de representació:");
        this.setBarreraElectoral(entraValors());
    }

    private void preguntaRepresentats(){
        System.out.println("Introdueix número de representants a escollir:");
        this.setRepresentants(entraValors());
    }

    private void preguntaVotsPartits(){

        Scanner sc = new Scanner(System.in);

        for(int i=0; i < getPartits(); i++) {
            System.out.println("Entra el nom del partit "+(i+1) +" :");
            String nom = sc.nextLine();
            System.out.println("Número de vots:");
            Integer vots = Integer.parseInt(sc.nextLine());
            partit p = new partit (nom,vots);

            llistat.add(p);
        }
        // amb el sc tancat em rebenta per tot arreu
        //sc.close();

    }

    private int entraValors() {
        int valors;
        Scanner sc = new Scanner(System.in);
        valors = sc.nextInt();
        return valors;
    }



    public ArrayList<partit> getLlistat() {
        return this.llistat;
    }

    public void setLlistat(ArrayList<partit> llistat) {
        eleccions.llistat = llistat;
    }

    public void setVotsBlanc(int votsBlanc) {
        eleccions.votsBlanc = votsBlanc;
    }

    public void setVotsNuls(int votsNuls) {
        eleccions.votsNuls = votsNuls;
    }

    public void setCens(int cens) {
        eleccions.cens = cens;
    }

    public void setRepresentants(int representants) {
        eleccions.representants = representants;
    }

    public void setBarreraElectoral(int barreraElectoral) {
        eleccions.barreraElectoral = barreraElectoral;
    }

    public int getPartits() {

        return partits;
    }

    public void setPartits(int partits) {

        eleccions.partits = partits;
    }

    public int getVotsNuls() {
        return this.votsNuls;
    }

    public int getVotsBlanc() {
        return this.votsBlanc;
    }

    public int getCens() {
        return cens;
    }

    public int getRepresentants() {
        return representants;
    }

    public double getBarreraElectoral() {
        return barreraElectoral;
    }

}


class grup {

    private String nom;
    private int escons;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEscons() {
        return escons;
    }

    public void setEscons(int escons) {
        this.escons = escons;
    }

}








// Desenvolupament del tipus partit
class partit implements Comparable<partit> {

    private String nom;
    private Integer vots;

    partit(String nom, Integer vots) {
        this.nom = nom;
        this.vots = vots;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVots(Integer vots) {
        this.vots = vots;
    }

    public String getNom() {
        return this.nom;
    }

    public Integer getVots() {
        return this.vots;
    }


    @Override
    public String toString() {
        return "partit{" +
                "nom='" + nom + '\'' +
                ", vots=" + vots +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        boolean r = false;
        if (o instanceof partit) {
            partit p = (partit) o;
            r = this.getNom().equals(p.getNom()) && this.getVots().equals(p.getVots());
        }
        return r;
    }

    public int compareTo(partit p) {
        int r;
        r = getNom().compareTo(p.getNom());
        if (r == 0) {
            r = getVots().compareTo(p.getVots());
        }
        return r;
    }

    public int hashCode() {
        return getNom().hashCode() + getVots().hashCode() * 31;
    }

}



class comparadorResultats implements Comparator<partit>{

        public int compare(partit p1, partit p2) {
            int n;
            n = p1.getVots().compareTo(p2.getVots());
            if (n == 0) {
                n = p1.compareTo(p2);
            }
            return n;
        }
    }
