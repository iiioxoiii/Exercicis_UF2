package reglahont;

import java.util.*;

class eleccions {

    private static int votsBlanc = 0;
    private static int votsNuls = 0;
    private static int partits = 0;
    private static int cens = 0;
    private static int representants= 0 ;
    private static int barreraElectoral = 0;

    //Llista amb els partits de les eleccions (partit [nom-vots])
    private static ArrayList<partit> llistat= new ArrayList<partit>();

    //Llista anomenada parlament amb les dades derivades del càlcul. Cada grup és
    //un objecte amb nom del partit que ha passat el tall i amb els escons assignats

    private static ArrayList<grup> parlament =  new ArrayList<grup>();


    /**
     * Métode global de la classe eleccions
     */
    public void preguntesBasiques(){

        preguntaRepresentats();
        preguntaMinimaRepresentacio();
        preguntaTotalCens();
        preguntaVotsEnBlanc();
        preguntaVotsNuls();
        preguntaNumPartits();
        preguntaVotsPartits();

    }


    /**
     * El métode pregunta si cal canviar els valors a l'arrayList "llistat"
     */
    public void canviVotsPartit(){

        boolean sortir = false;

        while(!sortir){
            System.out.println("Vols canviar el valor de vots d'algun partit (s/n)?");
            Scanner ss = new Scanner(System.in);
            String resposta = ss.nextLine();

            if (resposta.equals("s")) {

                System.out.println("Entra el nom del partit que vols canviar els vots:");
                Scanner sc = new Scanner(System.in);

                String nom = sc.next();

                for (partit p : llistat) {
                    if (p.getNom().equals(nom)) {
                        System.out.println("Nova quantitat de vots:");
                        int vots = entraValors();
                        p.setVots(vots);
                    } else {
                        //System.out.println("No s'ha trobat cap partit amb aquest nom");
                    }

                }
            }else {
                sortir = true;
            }
        }
    }


    /**
     * Funció que calcula la possibilitat de fer govern.
     * Pregunta el nom dels partits, agafa els vots associats, els suma i comprova si sobrepassen
     * la meitat +1 del total d'escons del parlament,
     */
    public void calculGovern() {

        System.out.println("Proposta de pacte de govern introduint el noms dels partits (separats per espais):");

        int esconsGovern = (representants / 2) + 1;
        int sumaEscons = 0;

        Scanner sc = new Scanner(System.in);

        String partits = sc.nextLine();
        String[] partitsVector = partits.split(" ");


        for (int i = 0; i < partitsVector.length; i++) {
            for (grup p : parlament) {

                if (partitsVector[i].equals(p.getNom())){
                    //System.out.println("partitsVector: " + partitsVector[i]);
                    //System.out.println("p.getnom: " + p.getNom() + p.getEscons());
                    sumaEscons = sumaEscons + retornaEscons(partitsVector[i]);
                }
            }
        }

        if(sumaEscons<esconsGovern){
            System.out.println("No sumen. No poden formar govern");
            System.out.println("Es necessiten " + esconsGovern + " i la suma es de " + sumaEscons);
        }else {
            System.out.println("Sí.Poden formar govern. Sumen "+ sumaEscons);
        }

    }


    /**
     * Funció de retorn d'escons associat al Arraylist "parlament"
     * @param  nomPartit és una cadena amb el nom del partit guardat a la llista parlament (un grup)
     * @return n és el número de escons assignats
     */
    public int retornaEscons (String nomPartit){

        int n = 0;

        for(grup g:parlament){
            if (nomPartit.equals(g.getNom())){
                n= g.getEscons();
            }
        }

        return n;
    }


    /**
     * Agafa el llistat amb tots els vots i tots els partits, selecciona els que passen el tall
     * ,mostra l'assigació de escons i desa les dades a l'arrayList "parlament"
     */
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


        //6) Es borra el contingut del parlament (si es que ja hi havia una assignació d'escons anterior)

        parlament.clear();

        //7) Es pinta el resultat:
        // Es pinta un ArrayList amb els partits i al costat l'array cutre amb els escons.
        a=0;
        for (partit p : llistatFiltrat) {
            grup g = new grup();
            g.setNom(p.getNom());
            g.setEscons(esc[a]);
            System.out.print(p+"--->");
            System.out.println(esc[a]);

            parlament.add(g);
            a++;
        }

    }

    /**
     * Funció que retorna els escons assignats de les formacions.
     * @param vots array amb vots
     * @param esc array amb escons asignats
     * @param p número de escons a repartir
     * @return
     */
    //Funcio d'assignació d'escons.
    public int escons( int vots[], int esc[], int p) {

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


    /**Funció que avalua la llista de partits amb els seus vots i
     * retorna un arraylist amb els partits que han passat el tall
     * @return
     */
    public static ArrayList<partit> filtreBarrera(){

        ArrayList <partit> partitsBarreraSuperada = new ArrayList<partit>();

        for (partit p : llistat) {
            if(superaBarrera(p.getVots())){
                partitsBarreraSuperada.add(p);
            }
        }
        return partitsBarreraSuperada;
    }


    /**
     * Funció que retorna true o false depenent dels vots i la barrera Electoral
     * @param vots
     * @return true or false
     */
    public static boolean superaBarrera(int vots){
        boolean resultat=false;

        if( (100*vots)/ totalVots() > barreraElectoral){
            resultat=true;
        }
        return resultat;
    }

    /**
     * Suma tots els vots de la llista inicial:
     * Vots de tots els partits, vots en blanc, nuls.
     * @return El total de vots
     */
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

    /**
     * Mostra per pantalla els partits que pasen el tall electoral
     */
    public void pintaPartitsTallSuperat(){
        for (partit p: llistat) {
            System.out.println(p.toString());
        }
    }

    /**
     * Mostra per pantalla el total de vots
     */
    public void pintaTotalVots(){
        System.out.println("Han hagut un total de "+ totalVots()+" vots");
        System.out.println("Vots vàlids: " + (totalVots()-(votsBlanc+votsNuls)));
        System.out.println("Vots en blac: " + votsBlanc);
        System.out.println("Vots nuls: " + votsNuls);
    }

    /**
     * Pregunta número de partits
     */
    private void preguntaNumPartits(){
        System.out.println("Introdueïx número de partits que participen:");
        this.setPartits(entraValors());
    }

    /**
     * Pregunta número de vots nuls
     */
    private void preguntaVotsNuls(){
        System.out.println("Introdueïx vots nuls:");
        this.setVotsNuls(entraValors());
    }

    /**
     * Pregunta vots en blanc
     */
    private void preguntaVotsEnBlanc(){
        System.out.println("Introdueïx vots en blanc:");
        this.setVotsBlanc(entraValors());
    }

    /**
     * Pregunta el total cens
     */
    private void preguntaTotalCens(){
        System.out.println("Introdueïx el total del cens:");
        this.setCens(entraValors());
    }

    /**
     * Pregunta el % per la mínima representació
     */
    private void preguntaMinimaRepresentacio(){
        System.out.println("Introdueïx el % mínim de representació:");
        this.setBarreraElectoral(entraValors());
    }

    /**
     * Pregunta els escons del parlament
     */
    private void preguntaRepresentats(){
        System.out.println("Introduex número de representants a escollir:");
        this.setRepresentants(entraValors());
    }

    /**
     * Pregunta el nom i els vots dels partits que participen a les eleccions
     */
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

    /**Funció que instacia Scanner i per entrar per teclat valors enters.
     * @return Un enter
     */
    private int entraValors() {
        int valors;
        Scanner sc = new Scanner(System.in);
        valors = sc.nextInt();
        return valors;
    }


    /**
     *GETTERS I SETTERS
     */
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