//REFACT: Delete unused code import java.util.File and import java.util.List;
import java.util.Scanner;


public class RefactorizedMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //REFACT: Delete unused code String p = "Proves";
        int opcio;
        //REFACT: Extract method menuprincipal();
        menuprincipal();
        opcio = scan.nextInt();
        //REFACT: Delete unused code scan.nextLine();
        switch (opcio) {
            case 1:
                System.out.println("Introdueix el primer nombre: ");
                int num1 = scan.nextInt();
                System.out.println("Introdueix el segon nombre: ");
                int num2 = scan.nextInt();
                calcularmesgran(num1, num2);
                break;
            case 2:
                //REFACT: Added user input for a, b, c
                System.out.println("Introdueix el coeficient a: ");
                double a = scan.nextDouble();
                System.out.println("Introdueix el coeficient b: ");
                double b = scan.nextDouble();
                System.out.println("Introdueix el coeficient c: ");
                double c = scan.nextDouble();
                calcEquacioSegongrau(a, b, c);
                break;
            case 3:
                System.out.println("Introdueix el nom del client: ");
                //Comprovem si el client existeix
                String nom = scan.nextLine();
                ComprovarClient(nom);




    }

    public static void menuprincipal() { 
        System.out.println("1. Introduir dos nombres i mostrar el més gran");
        System.out.println("2. Introduir els coeficients d'una equació de segon grau i mostrar les seves arrels");

    }

    public static void calcularmesgran(int num1, int num2) { //REFACT: Changed method name to calcularmesgran() 
        if (num1 > num2) {
            System.out.println("El número més gran és: " + num1);
        } else if (num1 == num2) {
            System.out.println("Els dos nombres són iguals");
        } else {
            System.out.println("El número més gran és: " + num2);
        }
    }

    public static void calcEquacioSegongrau(double a, double b, double c) {
        double D = b * b - 4 * a * c;
        if (D > 0) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("Les arrels de l'equació són: " + x1 + " i " + x2);
        } else if (D == 0) {
            double x = -b / (2 * a);
            System.out.println("L'arrel de l'equació és: " + x);
        } else {
            System.out.println("L'equació no té solució");
        }
    }

    public static void crearClient(String nom) 
    }

}