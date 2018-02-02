package calculadora;
import java.util.Scanner;

public class operacions {

    public static void suma(){
        double a = preguntaDouble();
        double b = preguntaDouble();
        System.out.println("a + b = " + (a+b));
    }

    public static void resta(){
        double a = preguntaDouble();
        double b = preguntaDouble();
        System.out.println("a - b = " + (a-b));

    }

    public static void multiplicacio(){
        double a = preguntaDouble();
        double b = preguntaDouble();
        System.out.println("a * b = " + (a*b));
    }

    public static void divisio(){
        double a = preguntaDouble();
        double b = preguntaDouble();
        System.out.println("a / b = " + (a/b));
    }

    public static void residu(){
        double a = preguntaDouble();
        double b = preguntaDouble();
        System.out.println("a % b = " + (a%b));

    }

    public static double preguntaDouble(){
        Scanner n = new Scanner(System.in);
         return n.nextDouble();
    }


}
