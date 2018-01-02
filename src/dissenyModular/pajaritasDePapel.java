package dissenyModular;



public class pajaritasDePapel {

    public static int vegades= 0;


    public static void main(String[] args) {
        calcula(1108., 1208.);
        System.out.println(vegades);
    }

    public static void calcula(double a, double l){

        System.out.println("Cicle: " + vegades);
        System.out.println("info a="+a);
        System.out.println("info l="+l);


        if ((l >= 10.) && (a >= 10.)) {
            if (l > a) {
                vegades++;
                System.out.println("l>a");
                System.out.println("a: " + a);
                System.out.println("b: " + l);
                System.out.println("Suma un!");
                calcula(l-a,a);
            }else if( l < a) {
                vegades++;
                System.out.println("l<a");
                System.out.println("a: " + a);
                System.out.println("b: " + l);
                System.out.println("Suma un!");
                calcula(a - l, l);

            }else{
                System.out.println("costats iguals");
            }
        }

    }


}
