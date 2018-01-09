package reglahont;

import java.util.*;




public class reglahont {

    private static int votsBlanc = 0;
    private static int votsNuls = 0;
    private static int partits = 0;
    private static int cens = 0;
    private static int representants= 0 ;
    private static double barreraElectoral = 0.;

    private static HashMap<String, Integer> votsPartit = new HashMap <String, Integer>();

    private static ArrayList<partit> llistatVots = new ArrayList<partit>();
    

    public static void main (String [] args){
        preguntes();
        resultats();
    }



    public static void preguntes(){
        preguntaRepresentats();
        preguntaMinimaRepresentacio();
        preguntaTotalCens();
        preguntaVotsEnBlanc();
        preguntaVotsNuls();
        preguntaNumPartits();
        preguntaVotsPartits(partits);
    }

    public static void resultats(){
        mostraTotalVots();
        lleiElectoral();
    }


    public static HashMap<String, Integer> lleiElectoral(){

        //Primer: Els partits que no superen un llindar no se'ls pot aplicar la llei d'Hondt d'assignació de
        //d'escons. Per tant, es realitza el filtratge de formacions que passin el tall i es desen en el "llistat"

        HashMap<String, Integer> llistat = filtreBarrera();


        //
        llistat.size();

    }


    public static void mostraTotalVots(){
        System.out.println("Han hagut un total de "+ totalVots()+" vots");
        System.out.println("Vots vàlids: " + (totalVots()-(votsBlanc+votsNuls)));
        System.out.println("Vots en blac: " + votsBlanc);
        System.out.println("Vots nuls: " + votsNuls);
    }


   public static int totalVots(){
        Integer subtotal = 0;

       //Sumem el total de vots de les formacions
       for (Map.Entry<String, Integer> entry : votsPartit.entrySet()) {
           subtotal = entry.getValue() + subtotal;
           //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
       }

       //Afegim el total de vots en blanc i nuls
       subtotal=subtotal+votsNuls+votsBlanc;

       return subtotal;
   }




   //Es fa una llista amb els partits a partir de votsPartit i els vots que han passat el tall.
   public static HashMap<String,Integer> filtreBarrera(){

       HashMap<String, Integer> llistatBarreraSuperada = new HashMap<String, Integer>();

       for (Map.Entry<String, Integer> entry : votsPartit.entrySet()) {
           if(superaBarrera(entry.getValue())){
               llistatBarreraSuperada.put(entry.getKey(),entry.getValue());
           }
       }
       return llistatBarreraSuperada;
   }


   public static boolean superaBarrera(int vots){
        boolean resultat=false;

        if( (100*vots)/cens > barreraElectoral){
            resultat=true;
       }
       return resultat;
   }







    public static void preguntaVotsPartits(int numPartits){

        Scanner sc = new Scanner(System.in);

        for(int i=0; i < numPartits; i++) {
            System.out.println("Entra el nom del partit "+(i+1) +" :");
            String nom = sc.nextLine();
            System.out.println("Número de vots:");
            Integer vots = Integer.parseInt(sc.nextLine());
            votsPartit.put(nom,vots);
        }
        sc.close();

    }

    public static void preguntaNumPartits(){
        System.out.println("Introdueix número de partits que participen:");
        partits = entraValors();
    }

    public static void preguntaVotsNuls(){
        System.out.println("Introdueix vots nuls:");
        votsNuls = entraValors();
    }

    public static void preguntaVotsEnBlanc(){
        System.out.println("Introdueix vots en blanc:");
        votsBlanc = entraValors();
    }

    public static void preguntaTotalCens(){
        System.out.println("Introdueix el total del cens:");
        cens = entraValors();
    }

    public static void preguntaMinimaRepresentacio(){
        System.out.println("Introdueix el % mínim de representació:");
        barreraElectoral = entraValors();
    }

    public static void preguntaRepresentats(){
        System.out.println("Introdueix número de representants a escollir:");
        representants = entraValors();
    }


    public static int entraValors() {
        int valors;
        Scanner sc = new Scanner(System.in);
        valors = sc.nextInt();
        return valors;
    }
}









// Desenvolupament del tipus partit
class partit implements Comparable<partit>{

    String nom;
    Integer vots;

    partit(String nom, Integer vots){
        this.nom= nom;
        this.vots = vots;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getVots() {
        return vots;
    }

    public void setVots(Integer vots) {
        this.vots = vots;
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

    @Override
    public String toString() {
        return "partit{" +
                "nom='" + nom + '\'' +
                ", vots=" + vots +
                '}';
    }
}

class ComparadorPartitPerVots implements Comparator<partit>{
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