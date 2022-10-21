import java.util.Scanner;
public class vector_adder3D {
    public static void main(String[] args) {
        double[] output = new double[3];
        double[] sum = new double[3];
        vector_converter3D.instruction_block();
        System.out.println("Enter your first vector");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().replace(" ", "");
        while (!input.equals("end")) {
            output = vector_converter3D.refine(input);
            sum[0] += output[0];
            sum[1] += output[1];
            sum[2] += output[2];
            System.out.println("Enter your next vector. The rules above still apply. If you are done, enter \"end\".");
            input = scan.nextLine().replace(" ", "");
            }
        System.out.println("Enter the magnitude unit: ");
        String unit = scan.nextLine();
        System.out.print("\n\n");
        vector_converter3D.results(sum, unit);
    }
}