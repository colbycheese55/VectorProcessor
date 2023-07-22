import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number for your desired operation: ");
        System.out.println("(1) Converter, (2) Adder, (3) Cross Product, (4) Dot Product");
        String option = scan.nextLine().replace(" ", "");
        switch (option) {
            case "1":
                converterMode(scan);
                break;
            case "2":
                sumMode(scan);
                break;
            case "3":
                crossProductMode(scan);
                break;
            case "4":
                dotProductMode(scan);
                break;
            default:
                System.out.println("ERROR: UNRECOGNIZED CHOICE. ONLY ENTER A INTEGER, LIKE 2. TRY AGAIN ");
                main(args);
        }
    }

    private static void converterMode(Scanner scan) {
        System.out.println("Enter the vector to convert:");
        Vector vector = new Vector(scan.nextLine());
        System.out.println(vector);
    }
    private static void sumMode(Scanner scan) {
        System.out.println("Enter the first vector: ");
        double Xsum = 0, Ysum = 0, Zsum = 0;
        String input = scan.nextLine();
        while (!input.equals("end")) {
            Vector intermediateVector = new Vector(input);
            Xsum += intermediateVector.getX();
            Ysum += intermediateVector.getY();
            Zsum += intermediateVector.getZ();
            System.out.println("Enter the next vector, or \"end\" to stop");
            input = scan.nextLine();
        }
        Vector endVector = new Vector(Xsum, Ysum, Zsum);
        System.out.println(endVector);
    }
    private static void crossProductMode(Scanner scan) {
        System.out.println("Enter the first vector: ");
        Vector v1 = new Vector(scan.nextLine());
        System.out.println("Enter the second vector");
        Vector v2 = new Vector(scan.nextLine());

        double x = v1.getY()*v2.getZ()-v1.getZ()*v2.getY();
        double y = v1.getZ()*v2.getX()-v1.getX()*v2.getZ();
        double z = v1.getX()*v2.getY()-v1.getY()*v2.getX();

        Vector crossedVector = new Vector(x, y, z);
        System.out.println(crossedVector);
    }
    private static void dotProductMode(Scanner scan) {
        System.out.println("Enter the first vector: ");
        Vector v1 = new Vector(scan.nextLine());
        System.out.println("Enter the second vector");
        Vector v2 = new Vector(scan.nextLine());

        double result = v1.getX()*v2.getX() + v1.getY()*v2.getY() + v1.getZ()*v2.getZ();
        double theta = Math.toDegrees(Math.acos(result/(v1.getMag()*v2.getMag())));
        System.out.println("Scalar value: "+result);
        System.out.println("Angle between input vectors: "+theta);

    }
}
