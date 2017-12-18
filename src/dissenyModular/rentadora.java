package dissenyModular;

import java.util.Scanner;

/*
* 7) Haurem de fer la gestió d'una rentadora. Tenim dos cubells, un per roba blanca i
* un altre per roba d'altres colors. Hem de dissenyar un programa modular on anem introduint
* la roba i especifiquem el pes i el color. Si és de color blanc el dispositem en el cubell
* blanc i sinó al de color. Quan un dels dos cubells traspassa els 2 kg de pes s'ha d'enviar
* a rentar, és llavors quan acaba el programa i ens ha d'anunciar quin dels dos cubells ha
* rentat i amb quin pes.*/

public class rentadora {

    static int cubellRobaBlanca = 0;
    static int cubellRobaColor = 0;
    static COLOR c;

    public static void main(String[] args) {

        while ((cubellRobaBlanca < 2000) && (cubellRobaColor < 2000)){
            Scanner sc = new Scanner (System.in);
            System.out.println("Entra pes: ");
            int pes = sc.nextInt();
            System.out.println("Entra roba (BLANCA/COLOR): ");
            c = COLOR.valueOf(sc.next().toUpperCase());

            entraRoba(pes, c);
        }

        if(cubellRobaColor > 2000){
            System.out.println("El cubell de "+ cubellRobaColor + " de roba color s'ha netejat");
        }else{
            System.out.println("El cubell de "+ cubellRobaBlanca + " de roba blanca s'ha netejat");
        }
    }

    public static void entraRoba(int pes, COLOR c){

        if(c.equals(COLOR.BLANCA)){
            cubellRobaBlanca = cubellRobaBlanca + pes;
        }else if (c.equals(COLOR.COLOR)){
            cubellRobaColor = cubellRobaColor + pes;
        }else{
            System.out.println("No s'ha afegit roba a cap cubell");
        }

    }
}


