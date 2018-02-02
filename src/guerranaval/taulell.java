package guerranaval;

class taulell{

 /**

    private casella [][] casella;

    //Només construir el taulell

    public taulell (){

        casella[0][1] = new casella(ubicacio.A0,estat.AIGUA);
        casella[0][2] = new casella(ubicacio.A1,estat.AIGUA);
        casella[0][3] = new casella(ubicacio.A2,estat.AIGUA);
        casella[0][4] = new casella(ubicacio.A3,estat.AIGUA);
        casella[0][5] = new casella(ubicacio.A4,estat.AIGUA);
        casella[0][6] = new casella(ubicacio.A6,estat.AIGUA);
        casella[0][7] = new casella(ubicacio.A7,estat.AIGUA);
        casella[0][8] = new casella(ubicacio.A8,estat.AIGUA);
        casella[0][9] = new casella(ubicacio.A9,estat.AIGUA);

        casella[1][1] = new casella(ubicacio.B0,estat.AIGUA);
        casella[1][2] = new casella(ubicacio.B1,estat.AIGUA);
        casella[1][3] = new casella(ubicacio.B2,estat.AIGUA);
        casella[1][4] = new casella(ubicacio.B3,estat.AIGUA);
        casella[1][5] = new casella(ubicacio.B4,estat.AIGUA);
        casella[1][6] = new casella(ubicacio.B6,estat.AIGUA);
        casella[1][7] = new casella(ubicacio.B7,estat.AIGUA);
        casella[1][8] = new casella(ubicacio.B8,estat.AIGUA);
        casella[1][9] = new casella(ubicacio.B9,estat.AIGUA);

        casella[2][1] = new casella(ubicacio.C0,estat.AIGUA);
        casella[2][2] = new casella(ubicacio.C1,estat.AIGUA);
        casella[2][3] = new casella(ubicacio.C2,estat.AIGUA);
        casella[2][4] = new casella(ubicacio.C3,estat.AIGUA);
        casella[2][5] = new casella(ubicacio.C4,estat.AIGUA);
        casella[2][6] = new casella(ubicacio.C6,estat.AIGUA);
        casella[2][7] = new casella(ubicacio.C7,estat.AIGUA);
        casella[2][8] = new casella(ubicacio.C8,estat.AIGUA);
        casella[2][9] = new casella(ubicacio.C9,estat.AIGUA);

        casella[3][1] = new casella(ubicacio.D0,estat.AIGUA);
        casella[3][2] = new casella(ubicacio.D1,estat.AIGUA);
        casella[3][3] = new casella(ubicacio.D2,estat.AIGUA);
        casella[3][4] = new casella(ubicacio.D3,estat.AIGUA);
        casella[3][5] = new casella(ubicacio.D4,estat.AIGUA);
        casella[3][6] = new casella(ubicacio.D6,estat.AIGUA);
        casella[3][7] = new casella(ubicacio.D7,estat.AIGUA);
        casella[3][8] = new casella(ubicacio.D8,estat.AIGUA);
        casella[3][9] = new casella(ubicacio.D9,estat.AIGUA);

        casella[4][1] = new casella(ubicacio.E0,estat.AIGUA);
        casella[4][2] = new casella(ubicacio.E1,estat.AIGUA);
        casella[4][3] = new casella(ubicacio.E2,estat.AIGUA);
        casella[4][4] = new casella(ubicacio.E3,estat.AIGUA);
        casella[4][5] = new casella(ubicacio.E4,estat.AIGUA);
        casella[4][6] = new casella(ubicacio.E6,estat.AIGUA);
        casella[4][7] = new casella(ubicacio.E7,estat.AIGUA);
        casella[4][8] = new casella(ubicacio.E8,estat.AIGUA);
        casella[4][9] = new casella(ubicacio.E9,estat.AIGUA);

        casella[5][1] = new casella(ubicacio.F0,estat.AIGUA);
        casella[5][2] = new casella(ubicacio.F1,estat.AIGUA);
        casella[5][3] = new casella(ubicacio.F2,estat.AIGUA);
        casella[5][4] = new casella(ubicacio.F3,estat.AIGUA);
        casella[5][5] = new casella(ubicacio.F4,estat.AIGUA);
        casella[5][6] = new casella(ubicacio.F6,estat.AIGUA);
        casella[5][7] = new casella(ubicacio.F7,estat.AIGUA);
        casella[5][8] = new casella(ubicacio.F8,estat.AIGUA);
        casella[5][9] = new casella(ubicacio.F9,estat.AIGUA);

        casella[6][1] = new casella(ubicacio.G0,estat.AIGUA);
        casella[6][2] = new casella(ubicacio.G1,estat.AIGUA);
        casella[6][3] = new casella(ubicacio.G2,estat.AIGUA);
        casella[6][4] = new casella(ubicacio.G3,estat.AIGUA);
        casella[6][5] = new casella(ubicacio.G4,estat.AIGUA);
        casella[6][6] = new casella(ubicacio.G6,estat.AIGUA);
        casella[6][7] = new casella(ubicacio.G7,estat.AIGUA);
        casella[6][8] = new casella(ubicacio.G8,estat.AIGUA);
        casella[6][9] = new casella(ubicacio.G9,estat.AIGUA);

        casella[7][1] = new casella(ubicacio.H0,estat.AIGUA);
        casella[7][2] = new casella(ubicacio.H1,estat.AIGUA);
        casella[7][3] = new casella(ubicacio.H2,estat.AIGUA);
        casella[7][4] = new casella(ubicacio.H3,estat.AIGUA);
        casella[7][5] = new casella(ubicacio.H4,estat.AIGUA);
        casella[7][6] = new casella(ubicacio.H6,estat.AIGUA);
        casella[7][7] = new casella(ubicacio.H7,estat.AIGUA);
        casella[7][8] = new casella(ubicacio.H8,estat.AIGUA);
        casella[7][9] = new casella(ubicacio.H9,estat.AIGUA);

        casella[8][1] = new casella(ubicacio.I0,estat.AIGUA);
        casella[8][2] = new casella(ubicacio.I1,estat.AIGUA);
        casella[8][3] = new casella(ubicacio.I2,estat.AIGUA);
        casella[8][4] = new casella(ubicacio.I3,estat.AIGUA);
        casella[8][5] = new casella(ubicacio.I4,estat.AIGUA);
        casella[8][6] = new casella(ubicacio.I6,estat.AIGUA);
        casella[8][7] = new casella(ubicacio.I7,estat.AIGUA);
        casella[8][8] = new casella(ubicacio.I8,estat.AIGUA);
        casella[8][9] = new casella(ubicacio.I9,estat.AIGUA);

        casella[9][1] = new casella(ubicacio.J0,estat.AIGUA);
        casella[9][2] = new casella(ubicacio.J1,estat.AIGUA);
        casella[9][3] = new casella(ubicacio.J2,estat.AIGUA);
        casella[9][4] = new casella(ubicacio.J3,estat.AIGUA);
        casella[9][5] = new casella(ubicacio.J4,estat.AIGUA);
        casella[9][6] = new casella(ubicacio.J6,estat.AIGUA);
        casella[9][7] = new casella(ubicacio.J7,estat.AIGUA);
        casella[9][8] = new casella(ubicacio.J8,estat.AIGUA);
        casella[9][9] = new casella(ubicacio.J9,estat.AIGUA);

    }

    public void getEstatCasella(int x, int y){
        return ubicacio;
    }

  **/
}