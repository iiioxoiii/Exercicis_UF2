package guerranaval;

public enum ubicacio {

    A0("A0",0,0),
    A1("A1",0,1),
    A2("A2",0,2),
    A3("A3",0,3),
    A4("A4",0,4),
    A5("A5",0,5),
    A6("A6",0,6),
    A7("A7",0,7),
    A8("A8",0,8),
    A9("A9",0,9),
    A10("A10",0,10),

    B0("B0",1,0),
    B1("B1",1,1),
    B2("B2",1,2),
    B3("B3",1,3),
    B4("B4",1,4),
    B5("B5",1,5),
    B6("B6",1,6),
    B7("B7",1,7),
    B8("B8",1,8),
    B9("B9",1,9),
    B10("B10",1,10),

    C0("C0",2,0),
    C1("C1",2,1),
    C2("C2",2,2),
    C3("C3",2,3),
    C4("C4",2,4),
    C5("C5",2,5),
    C6("C6",2,6),
    C7("C7",2,7),
    C8("C8",2,8),
    C9("C9",2,2),
    C10("C10",2,10),

    D0("D0",3,0),
    D1("D1",3,1),
    D2("D2",3,2),
    D3("D3",3,3),
    D4("D4",3,4),
    D5("D5",3,5),
    D6("D6",3,6),
    D7("D7",3,7),
    D8("D8",3,8),
    D9("D9",3,9),
    D10("D10",3,10),

    E0("E0",4,0),
    E1("E1",4,1),
    E2("E2",4,2),
    E3("E3",4,3),
    E4("E4",4,4),
    E5("E5",4,5),
    E6("E6",4,6),
    E7("E7",4,7),
    E8("E8",4,8),
    E9("E9",4,9),
    E10("E10",4,10),

    F0("F0",5,0),
    F1("F1",5,1),
    F2("F2",5,2),
    F3("F3",5,3),
    F4("F4",5,4),
    F5("F5",5,5),
    F6("F6",5,6),
    F7("F7",5,7),
    F8("F8",5,8),
    F9("F9",5,9),
    F10("F10",5,10),

    G0("G0",6,0),
    G1("G1",6,1),
    G2("G2",6,2),
    G3("G3",6,3),
    G4("G4",6,4),
    G5("G5",6,5),
    G6("G6",6,6),
    G7("G7",6,7),
    G8("G8",6,8),
    G9("G9",6,9),
    G10("G10",6,10),

    H0("H0",7,0),
    H1("H1",7,1),
    H2("H2",7,2),
    H3("H3",7,3),
    H4("H4",7,4),
    H5("H5",7,5),
    H6("H6",7,6),
    H7("H7",7,7),
    H8("H8",7,8),
    H9("H9",7,9),
    H10("H10",7,10),

    I0("I0",8,0),
    I1("I1",8,1),
    I2("I2",8,2),
    I3("I3",8,3),
    I4("I4",8,4),
    I5("I5",8,5),
    I6("I6",8,6),
    I7("I7",8,7),
    I8("I8",8,8),
    I9("I9",8,9),
    I10("I10",8,10),

    J0("J0",9,0),
    J1("J1",9,1),
    J2("J2",9,2),
    J3("J3",9,3),
    J4("J4",9,4),
    J5("J5",9,5),
    J6("J6",9,6),
    J7("J7",9,7),
    J8("J8",9,8),
    J9("J9",9,9),
    J10("J10",9,10),

    K0("K0",10,0),
    K1("K1",10,1),
    K2("K2",10,2),
    K3("K3",10,3),
    K4("K4",10,4),
    K5("K5",10,5),
    K6("K6",10,6),
    K7("K7",10,7),
    K8("K8",10,8),
    K9("K9",10,9),
    K10("K10",10,10);

    private String nomCasella;
    private int x;
    private int y;

    private ubicacio(String nomCasella, int x, int y) {
        this.nomCasella = nomCasella;
        this.x = x;
        this.y = y;
    }


    public String getNomCasella() {
        return nomCasella;
    }



/**
 * public enum Equipo
 {
 BARÇA("FC Barcelona",1), REAL_MADRID("Real Madrid",2),
 SEVILLA("Sevilla FC",4), VILLAREAL("Villareal",7);

 private String nombreClub;
 private int puestoLiga;

 private Equipo (String nombreClub, int puestoLiga){
 this.nombreClub = nombreClub;
 this.puestoLiga = puestoLiga;
 }

 public String getNombreClub() {
 return nombreClub;
 }

 public int getPuestoLiga() {
 return puestoLiga;
 }

 }**/


}
