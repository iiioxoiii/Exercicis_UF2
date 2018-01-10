package reglahont;

import java.util.*;


public class reglahont {

    public static void main(String[] args) {

        eleccions generals2017 = new eleccions();

        generals2017.preguntesBasiques();
        generals2017.calcul();

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


    public void preguntesBasiques(){

        preguntaRepresentats();
        preguntaMinimaRepresentacio();
        preguntaTotalCens();
        preguntaVotsEnBlanc();
        preguntaVotsNuls();
        preguntaNumPartits();
        preguntaVotsPartits();

    }

    public void calcul(){
        calculEscons(llistat);
    }



    public void calculEscons(ArrayList<partit> llista){

        // Es filtra la llista per la barreraElectorial i es desa en un altra ArrayList
        ArrayList llistaFiltrada;
        llistaFiltrada=filtreBarrera();

        //!!!No sé per què no pilla que és p pot ser persona??!!!
        for (Object p : llistaFiltrada){
            System.out.println(p);
        }

        //S'ordena l'array filtrat
        Comparator.new comparadorPartitPerVots();


        //1) Posar els vots de cada partit en un array[]
        //arrayVots[0],arrayVots[1],arrayVots[2];

        int [] arrayVots ={100000, 50000, 75000, 450000};
        int [] esc ={0,0,0,0};


        for(int i=0; i<150; i++) {
            int as = escons(arrayVots, esc, 4);
            esc[as]=esc[as]+1;
        }

        for(int i=0; i< esc.length; i++){
            System.out.println(esc[i]);
        }
    }

        //return llistaEscons;


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







    //Es fa una llista amb els partits a partir de votsPartit i els vots que han passat el tall.
    public static ArrayList<partit> filtreBarrera(){

        ArrayList <partit> partitsBarreraSuperada = new ArrayList<partit>();

        for (partit p : llistat) {
            if(superaBarrera(p.getVots())){
                partitsBarreraSuperada.add(p);
            }
        }
        return partitsBarreraSuperada;
    }

    public static boolean superaBarrera(int vots){
        boolean resultat=false;

        if( (100*vots)/cens > barreraElectoral){
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

    public int totalVots() {
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

        sc.close();

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



// Desenvolupament del tipus partit
class partit implements Comparable<partit>{

    private String nom;
    private Integer vots;

    partit(String nom, Integer vots){
        this.nom= nom;
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
        if(o instanceof partit){
            partit p = (partit) o;
            r = this.getNom().equals(p.getNom()) && this.getVots().equals(p.getVots());
        }
        return r;
    }

    public int compareTo(partit p){
        int r;
        r = getNom().compareTo(p.getNom());
        if (r==0){
            r = getVots().compareTo(p.getVots());
        }
        return r;
    }

    public int hashCode(){
        return getNom().hashCode()+getVots().hashCode()*31;
    }

}


class comparadorPartitPerVots implements Comparator<partit>{

    @Override
    public int compare(partit p1, partit p2) {
        int n;
        n= p1.getVots().compareTo(p2.getVots());
            if (n==0){
                n=p1.compareTo(p2);
            }
        return n;
    }
}