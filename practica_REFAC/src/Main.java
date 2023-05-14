//REFACT: Delete unused code import java.util.File and import java.util.List;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //REFACT: Delete unused code String p = "Proves";
        int opcio;
        List<Customer> customers = null;
        List<LineItem> lineItems = null;
        //REFACT: Extract method menuprincipal();
        menuprincipal();
        opcio = scan.nextInt();
        //REFACT: Delete unused code scan.nextLine();
        boolean i = true;
        switch (opcio) {
            case 1:
                System.out.println("Introdueix el primer nombre: ");
                int num1 = scan.nextInt();
                System.out.println("Introdueix el segon nombre: ");
                int num2 = scan.nextInt();
                calcularmesgran(num1, num2); //REFACT: Removed redundant code if
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
                String nom = scan.nextLine();
                ComprovarClient(nom, customers);
                //REFACT: Added user input for producte, quantitat, preu
                while (i = true) {
                    System.out.println("Introdueix el nom del producte: ");
                    String producte = scan.nextLine();
                    System.out.println("Introdueix la quantitat: ");
                    int quantitat = scan.nextInt();
                    System.out.println("Introdueix el preu: ");
                    double preu = scan.nextDouble();
                    System.out.println("Vols afegir una altra línia? (S/N)");
                    String opcioa = scan.nextLine();
                    //REFACT: Remade the procedure to obtain the ticket
                    LineItem lineItem = new LineItem(producte, quantitat, preu);
                    lineItems.add(lineItem);
                    if (opcioa == "N") {
                        i = false;
                        System.out.println("Ticket: ");
                        System.out.println("Client: " + nom);
                        for (LineItem line : lineItems) {
                            System.out.println(line.toString());
                        }
                        System.out.println("Total: " + getTotalPrice(lineItems));                    }
                }
        }
    }


    public static void menuprincipal() { //REFACT: Created method menuprincipal()
        System.out.println("1. Introduir dos nombres i mostrar el més gran");
        System.out.println("2. Introduir els coeficients d'una equació de segon grau i mostrar les seves arrels");
        System.out.println("3. Passar per caixa");

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

    public static void calcEquacioSegongrau(double a, double b, double c) { //REFACT: Added more system.out.println() to make it more user friendly
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


    public static void crearClient(String nom, String cognom, List<Customer> customers) { //REFACT: Created method crearClient()
        Customer client = new Customer(nom, cognom); //REFACT: We extract the class Customer to a new file
        System.out.println("El nom del client és: " + client.getFullName());
    }

    public static void ComprovarClient(String nom, List<Customer> customers) { 
        boolean trobat = false;
        for (Customer client : customers) {
            if (client.getFullName().equals(nom)) {
                trobat = true;
                break;
            }
        }
        if (trobat == false) {
            System.out.println("El client no existeix");
            System.out.println("Vols crear un nou client? (S/N)");
            Scanner scan = new Scanner(System.in);
            String opcio = scan.nextLine();
            if (opcio == "S") {
                System.out.println("Introdueix el nom del client: ");
                String nom1 = scan.nextLine();
                System.out.println("Introdueix el cognom del client: ");
                String cognom = scan.nextLine();
                crearClient(nom1, cognom, customers);
            }
        }
    }

    //REFACT: Deleted unused class Human

    //REFACT: Deleted redundant code in Order
    public static double getTotalPrice(List<LineItem> lineItems) {
        double total = 0;
        for (LineItem line : lineItems) {
            total += line.getPrice();
        }
        total = total * 5.5 / 100;
        return total;
    }
}